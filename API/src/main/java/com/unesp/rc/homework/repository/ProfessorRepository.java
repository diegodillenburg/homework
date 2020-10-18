/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unesp.rc.homework.repository;
import com.unesp.rc.homework.model.Professor;
import javax.transaction.Transactional;

/**
 *
 * @author Felipe
 */
@Transactional
public interface ProfessorRepository extends UsuarioBaseRepository <Professor> {
}
