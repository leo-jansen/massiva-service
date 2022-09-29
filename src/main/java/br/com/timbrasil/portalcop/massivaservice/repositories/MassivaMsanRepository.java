package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.model.MassivaMsan;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.MassivaSql;

public interface MassivaMsanRepository extends JpaRepository<MassivaMsan, Long>{
  @Query(value = MassivaSql.SQL_BUSCAR_MSANS_MASSIVA_SELECT)
  List<String> getMsanByFkMassiva(Long idMassiva);
}
