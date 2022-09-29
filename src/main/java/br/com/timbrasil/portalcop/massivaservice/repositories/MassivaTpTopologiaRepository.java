package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.model.MassivaTpTopologia;

public interface MassivaTpTopologiaRepository extends JpaRepository<MassivaTpTopologia, Long>{
  @Query(value = "SELECT m.id FROM MassivaTpTopologia m WHERE m.topologia = :tipoTopologia")
  Optional<Long> getIdMassivaTopologia(String tipoTopologia);
}
