package studyo.filter;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import studyo.authentication.DemoAuthenticationToken;
import studyo.authentication.GoogleUser;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthenticationFilter extends OncePerRequestFilter {

	private static final JacksonFactory jacksonFactory = new JacksonFactory();
	private static final HttpTransport transport = new NetHttpTransport();
	// TODO: put this configuration in an external file (application.xml)
	private static final String CLIENT_ID = "678647856070-hq2qe321rqilfs4fgosd98nn6ofm86jk.apps.googleusercontent.com";
	
    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        String idToken = request.getParameter("idToken");
        
        GoogleUser userFromGoogle;
		try {
			userFromGoogle = getUserFromGoogle(idToken);
		} catch (GeneralSecurityException e) {
			throw new SecurityException();
		}
        
        // validate the idToken
        if (userFromGoogle == null){
            throw new SecurityException();
        }                            
        
        // The token is 'valid' so magically get a user id from it
        //String id = getUserIdFromToken(xAuth);
        
        // Create our Authentication and let Spring know about it
        Authentication auth = new DemoAuthenticationToken(userFromGoogle);
        SecurityContextHolder.getContext().setAuthentication(auth);            
        
        filterChain.doFilter(request, response);
    }
    
    private GoogleUser getUserFromGoogle(String token) throws GeneralSecurityException, IOException {
    	GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jacksonFactory)
    		    .setAudience(Collections.singletonList(CLIENT_ID))
    		    // Or, if multiple clients access the backend:
    		    //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))	
    		    .build();

    		// (Receive idTokenString by HTTPS POST)
    		if (token == null) {
    			return null;
    		}
    		
    		GoogleIdToken idToken = verifier.verify(token);
    		if (idToken != null) {
    			
    			GoogleUser user = new GoogleUser();
    		  Payload payload = idToken.getPayload();

    		  // Print user identifier
    		  String userId = payload.getSubject();
    		  user.setUserId(userId);
    		  
    		  // Get profile information from payload
    		  user.setEmail(payload.getEmail());
    		  user.setEmailVerified(Boolean.valueOf(payload.getEmailVerified()));
    		  user.setName((String) payload.get("name"));
    		  user.setPictureUrl((String) payload.get("picture"));
    		  user.setLocale((String) payload.get("locale"));
    		  user.setFamilyName((String) payload.get("family_name"));
    		  user.setGivenName((String) payload.get("given_name"));

    		  System.out.println("User: " + user);
    		  
    		  return user;
    		} else {
    		  return null;
    		}
    }
}