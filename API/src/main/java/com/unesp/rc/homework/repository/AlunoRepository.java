package com.unesp.rc.homework.repository;

import com.unesp.rc.homework.model.Aluno;
import javax.transaction.Transactional;

@Transactional
public interface AlunoRepository extends UsuarioBaseRepository<Aluno> {
}