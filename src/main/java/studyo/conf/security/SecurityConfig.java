package studyo.conf.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import studyo.authentication.DemoAuthenticationProvider;
import studyo.filter.AuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private DemoAuthenticationProvider demoAuthenticationProvider;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {        
                
        http
        .csrf().disable()
        .authorizeRequests()
            .antMatchers("/**").permitAll();
                //.addFilterBefore(new AuthenticationFilter(), BasicAuthenticationFilter.class)                
        ;
                        
    }
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {        
        auth.authenticationProvider(demoAuthenticationProvider);        
    }    
    
}