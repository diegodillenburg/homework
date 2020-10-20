package com.unesp.rc.homework.repository;
import com.unesp.rc.homework.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
    @Query(value = "SELECT * FROM turmas INNER JOIN matriculas on turmas.id = matriculas.turma_id WHERE matriculas.aluno_id = ?1", nativeQuery = true)
    public List<Turma> findTurmasByAlunoId(Long aluno_id);

    @Query(value = "SELECT *, count(matriculas.turma_id) as matriculados FROM turmas LEFT JOIN matriculas on turmas.id = matriculas.turma_id WHERE data_inicio_inscricao < CURDATE() AND data_fim_inscricao > CURDATE() GROUP BY turmas.id HAVING matriculados < max_alunos", nativeQuery = true)
    List<Turma> findTurmasDisponiveis();

    List<Turma> findTurmasByProfessorId(Long profesorId);
}

