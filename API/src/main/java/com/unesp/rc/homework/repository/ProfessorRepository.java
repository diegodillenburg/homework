package com.unesp.rc.homework.repository;
import com.unesp.rc.homework.model.Professor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface ProfessorRepository extends UsuarioBaseRepository <Professor> {
}
