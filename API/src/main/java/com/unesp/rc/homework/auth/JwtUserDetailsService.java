package com.unesp.rc.homework.auth;

import com.unesp.rc.homework.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.unesp.rc.homework.model.Usuario;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    
    
     private PasswordEncoder passwordEncoder;

  public JwtUserDetailsService(PasswordEncoder passwordEncoder) {
    this.passwordEncoder = passwordEncoder;
  }

    @Autowired
    private UsuarioRepository usuarioRepository;;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
                com.unesp.rc.homework.model.Usuario user =  usuarioRepository.authenticateJwt(login);
		
		if (user.getLogin().equals(login)) {
			return new User(login,  passwordEncoder.encode(user.getSenha()),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with email: " + login);
		}                 
        }
}
