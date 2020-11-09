package com.se2.easypc.auth.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{

    private static final String[] publicResources = new String[]{ "/public/**" };
    private static final String[] adminResources = new String[]{ "/admin/**" };

    @Override
    public void configure( HttpSecurity httpSecurity ) throws Exception{
        httpSecurity
                .authorizeRequests( )
                .antMatchers( publicResources ).permitAll( )
                .antMatchers( adminResources ).hasAuthority( "ROLE_ADMIN" )
                .and( ).cors( ).disable( );
    }

}