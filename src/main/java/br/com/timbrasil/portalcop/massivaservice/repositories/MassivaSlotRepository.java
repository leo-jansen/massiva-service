package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.model.MassivaSlot;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.MassivaSql;

public interface MassivaSlotRepository extends JpaRepository<MassivaSlot, Long>{
  @Query(value = MassivaSql.SQL_BUSCAR_SLOTS_MASSIVA_SELECT)
  List<String> getSlotByFkMassiva(Long idMassiva);
}
