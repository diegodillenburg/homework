package com.unesp.rc.homework.repository;
import com.unesp.rc.homework.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    @Query(value = "SELECT * FROM turmas INNER JOIN matriculas on turmas.id = matriculas.id WHERE matriculas.aluno_id = ?1", nativeQuery = true)
    public List<Turma> findTurmasByAlunoId(Long aluno_id);

    List<Turma> findTurmasByProfessorId(Long profesorId);
}

