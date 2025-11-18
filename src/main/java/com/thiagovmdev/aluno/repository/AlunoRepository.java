package com.thiagovmdev.aluno.repository;


import com.thiagovmdev.aluno.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findByUsuarioAcesso(String usuarioAcesso);

    Optional<Aluno> findByEmailAluno(String emailAluno);
}
