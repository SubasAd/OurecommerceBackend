package com.subas.ourecommerce.users.Users;


import lombok.*;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@ToString
@RequiredArgsConstructor

@Entity
public class MyUser extends SecurityProperties.User implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    long phone;
    String username;
    String password;
    String Role;
    boolean isAccountUnexpired = true;
    boolean isAccountNonLocked = true;
    boolean isCredentialsNonExpired = true;
    boolean isEnabled = true;


    @Override
    public String getAuthority() {
        return Role;
    }
}
