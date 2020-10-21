package com.unesp.rc.auth;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  private PasswordEncoder passwordEncoder;

  public JwtUserDetailsService(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if ("felipe".equals(username)) {
       //Aqui estamos setando o valor de um user e sua senha encriptada
      return new User("felipe", passwordEncoder.encode("123456"),
          new ArrayList<>());
    } else {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
  }
}
