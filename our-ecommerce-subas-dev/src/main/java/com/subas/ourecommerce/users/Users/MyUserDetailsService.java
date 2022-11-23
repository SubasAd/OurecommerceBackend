package com.subas.ourecommerce.users.Users;

import com.subas.ourecommerce.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user1 = userRepository.getUserByUsername(username);
        if (user1 == null) {
            throw new UsernameNotFoundException("Couldn't find User");
        }

        return new MyUserDetails(user1);
    }
}
