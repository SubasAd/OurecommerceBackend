package com.subas.ourecommerce.users.controllers;

import com.subas.ourecommerce.users.UserRepository;
import com.subas.ourecommerce.users.Users.MyUser;
import com.subas.ourecommerce.users.Users.MyUserDetailsService;
import com.subas.ourecommerce.users.Util.Jwtutil;
import com.subas.ourecommerce.users.models.AuthenticationRequest;
import com.subas.ourecommerce.users.models.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {


    @Autowired
    UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    MyUserDetailsService UserDetailsService;
    @Autowired
    Jwtutil jwtTokenUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));


        } catch (BadCredentialsException e) {


            return ResponseEntity.badRequest().body("Incorrect credentials");
        }

        final UserDetails userdetails = UserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userdetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping("/users")
    public ResponseEntity<?> addNewUser(@RequestBody MyUser user) throws Exception {

        if (userRepository.getUserByUsername(user.getUsername()) != null) {

            return ResponseEntity.badRequest().body("User already exists");
        }

        userRepository.save(user);

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        final UserDetails userdetails = UserDetailsService.loadUserByUsername(user.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userdetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));


    }
    @PostMapping("/userdetails")
    public ResponseEntity<?> getUserDetails( @RequestBody String jwt) throws Exception
    {
      String username =  jwtTokenUtil.extractUsername(jwt);
        if(username != null)
        {
         MyUser u =  userRepository.getUserByUsername(username);
        return ResponseEntity.ok(u);
        }
        return ResponseEntity.badRequest().body("Invalid Jwt, Jwt can't resolve user");
    }


}
