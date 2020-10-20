package com.unesp.rc.homework.repository;

import com.unesp.rc.homework.model.Usuario;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
@Transactional
@Repository
public interface UsuarioRepository extends UsuarioBaseRepository<Usuario> {
    
    @Query(value = "SELECT * FROM usuario WHERE login = ?1 AND senha = ?2", nativeQuery = true)
    public Optional<Usuario> authenticate(String login, String senha);
}
