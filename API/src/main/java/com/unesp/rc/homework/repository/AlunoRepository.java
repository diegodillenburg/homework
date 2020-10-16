/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unesp.rc.homework.repository;
import com.unesp.rc.homework.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Felipe
 */
@Repository
public interface AlunoRepository extends JpaRepository<Assignment, Long> {
}