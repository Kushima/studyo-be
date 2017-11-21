package studyo.authentication;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;

public class DemoAuthenticationToken extends AbstractAuthenticationToken {

	private static final long serialVersionUID = -1949976839306453197L;
	private GoogleUser googleUser;

	public DemoAuthenticationToken(GoogleUser googleUser) {
		super(Arrays.asList());
		this.googleUser = googleUser;
	}

	public DemoAuthenticationToken(Collection<? extends GrantedAuthority> authorities, GoogleUser googleUser) {
		super(authorities);
		this.googleUser = googleUser;
	}

	@Override
	public Object getCredentials() {
		return "";
	}	

	@Override
	public Object getPrincipal() {
		return googleUser;
	}

	public String getUid() {
		return googleUser.getUserId();
	}

}