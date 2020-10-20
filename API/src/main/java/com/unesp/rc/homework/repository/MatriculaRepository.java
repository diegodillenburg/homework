package com.unesp.rc.homework.repository;

import com.unesp.rc.homework.model.Matricula;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
    
    @Query(value = "SELECT * FROM matriculas WHERE aluno_id = ?1", nativeQuery = true)
    public List<Matricula> findByAlunoId(Long aluno_id);
}
