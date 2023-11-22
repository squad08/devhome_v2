package com.devhome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devhome.models.CursoModel;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel, Long> {

}