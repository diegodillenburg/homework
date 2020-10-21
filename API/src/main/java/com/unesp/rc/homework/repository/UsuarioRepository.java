package com.unesp.rc.homework.repository;

import com.unesp.rc.homework.model.Usuario;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
@Transactional
@Repository
public interface UsuarioRepository extends UsuarioBaseRepository<Usuario> {
    
}
