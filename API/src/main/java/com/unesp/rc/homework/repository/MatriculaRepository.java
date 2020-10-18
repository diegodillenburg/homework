/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unesp.rc.homework.repository;

import com.unesp.rc.homework.model.Matricula;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Spiga
 */
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
    
    @Query(value = "SELECT * FROM matriculas WHERE aluno_id = ?1", nativeQuery = true)
    public List<Matricula> findByAlunoId(Long aluno_id);
}
