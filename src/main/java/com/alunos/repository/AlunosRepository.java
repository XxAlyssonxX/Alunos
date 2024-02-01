package com.alunos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alunos.entities.Alunos;

public interface  AlunosRepository extends JpaRepository<Alunos,Long>{

}