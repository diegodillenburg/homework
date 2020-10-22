package com.unesp.rc.homework.repository;

import com.unesp.rc.homework.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
//    public List<Comentario> findByAtividadeId(Long atividade_id);
}
