package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.model.Modulo;

public interface ModuloRepository extends JpaRepository<Modulo, Long> {
  @Query(value = "SELECT m FROM Modulo m WHERE m.matricula = :matricula")
  Optional<Modulo> findByMatricula(String matricula);
}
