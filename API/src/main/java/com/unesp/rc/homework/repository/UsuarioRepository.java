package com.unesp.rc.homework.repository;

import com.unesp.rc.homework.model.Usuario;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
@Transactional
@Repository
public interface UsuarioRepository extends UsuarioBaseRepository<Usuario> {
    
    @Query(value = "SELECT * FROM usuario WHERE login = ?1 AND senha = ?2", nativeQuery = true)
    public Usuario authenticate(String login, String senha);    
    
    @Query(value = "SELECT * FROM usuario WHERE login = ?", nativeQuery = true)
    public Usuario authenticateJwt(String login);
}
