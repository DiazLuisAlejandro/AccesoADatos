package com.docencia.objetos.service.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO: añadir métodos derivados si se necesitan (p.ej. existsByEmail)
public interface AlumnoJpaRepository extends JpaRepository<AlumnoEntity, Long> {
  
      boolean existsByEmail(String email);
}
