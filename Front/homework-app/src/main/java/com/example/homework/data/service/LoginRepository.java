/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.homework.data.service;

import com.example.homework.data.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Spiga
 */
public interface LoginRepository extends JpaRepository<Usuario, Integer> {
    
}
