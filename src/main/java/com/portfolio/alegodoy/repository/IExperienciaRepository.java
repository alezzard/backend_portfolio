package com.portfolio.alegodoy.repository;

import com.portfolio.alegodoy.model.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia,Long> {
    List<Experiencia> findByTipo(boolean tipo);
}
