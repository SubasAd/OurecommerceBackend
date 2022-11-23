package com.subas.ourecommerce.users.Users;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import java.util.Arrays;
import java.util.Collection;

public class MyUserDetails implements org.springframework.security.core.userdetails.UserDetails {


    MyUser myUser;

    MyUserDetails(MyUser myUser) {
        this.myUser = myUser;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println(myUser.getAuthority());
        return Arrays.asList(new SimpleGrantedAuthority(myUser.getAuthority()));

    }

    @Override
    public String getPassword() {

        return myUser.getPassword();
    }

    @Override
    public String getUsername() {
        return myUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return myUser.isAccountUnexpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return myUser.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return myUser.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return myUser.isEnabled();
    }
}
