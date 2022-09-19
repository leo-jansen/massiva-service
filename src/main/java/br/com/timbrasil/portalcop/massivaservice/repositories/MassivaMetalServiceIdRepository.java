package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.model.MassivaMetalServiceId;

public interface MassivaMetalServiceIdRepository extends JpaRepository<MassivaMetalServiceId, Long> {
  @Query(value = "SELECT m FROM MassivaMetalServiceId m WHERE m.fkMetalMassiva = :fkMetalMassiva")
  Optional<MassivaMetalServiceId> findbyFkMetalMassiva(Long fkMetalMassiva);
}
