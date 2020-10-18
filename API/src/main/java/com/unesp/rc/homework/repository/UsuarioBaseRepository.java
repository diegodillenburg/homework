/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unesp.rc.homework.repository;

import com.unesp.rc.homework.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *
 * @author Felipe
 */
@NoRepositoryBean
public interface UsuarioBaseRepository <T extends Usuario>  extends JpaRepository<T, Long> {
}