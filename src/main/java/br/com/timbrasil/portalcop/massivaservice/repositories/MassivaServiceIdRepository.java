package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.dto.RelatorioMassivaDto;
import br.com.timbrasil.portalcop.massivaservice.model.MassivaServiceId;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.MassivaSql;

public interface MassivaServiceIdRepository extends JpaRepository<MassivaServiceId, Long> {
  @Query(value = MassivaSql.SQL_GET_CLIENTES_IMPACTADOS_MASSIVA)
  List<RelatorioMassivaDto> getRelatorioMassiva(Long idMassiva);
}
