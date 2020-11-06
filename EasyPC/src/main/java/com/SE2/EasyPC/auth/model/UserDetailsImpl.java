package com.SE2.EasyPC.auth.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.SE2.EasyPC.dataAccess.model.Role;
import com.SE2.EasyPC.dataAccess.model.User;


public class UserDetailsImpl implements UserDetails{

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;


    public UserDetailsImpl( User user ){
        this.username = user.getUsername( );
        this.password = user.getPassword( );
        this.authorities = translateRoles( user.getRoles( ) );
    }

    @Override
    public String getUsername( ){
        return username;
    }

    @Override
    public String getPassword( ){
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities( ){
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired( ){
        return true;
    }

    @Override
    public boolean isAccountNonLocked( ){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired( ){
        return true;
    }

    @Override
    public boolean isEnabled( ){
        return true;
    }

    private Collection<? extends GrantedAuthority> translateRoles( List<Role> roles ){
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>( );
        for( Role role : roles ){
            String roleName = "ROLE_" + role.getRoleName( ).toUpperCase( );
            grantedAuthorities.add( new SimpleGrantedAuthority( roleName ) );
        }
        return grantedAuthorities;
    }
}