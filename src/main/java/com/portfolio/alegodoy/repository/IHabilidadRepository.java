package com.portfolio.alegodoy.repository;

import com.portfolio.alegodoy.model.Habilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHabilidadRepository extends JpaRepository<Habilidad,Long> {
}
