package com.unesp.rc.homework.repository;

import com.unesp.rc.homework.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface UsuarioBaseRepository <T extends Usuario>  extends JpaRepository<T, Long> {
}