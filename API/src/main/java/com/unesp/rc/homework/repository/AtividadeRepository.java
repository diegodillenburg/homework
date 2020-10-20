package com.unesp.rc.homework.repository;

import com.unesp.rc.homework.model.Atividade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

    @Query(value = "SELECT * FROM atividades WHERE turma_id = ?1", nativeQuery = true)
    public List<Atividade> findByTurmaId(Long turmaId);
}
