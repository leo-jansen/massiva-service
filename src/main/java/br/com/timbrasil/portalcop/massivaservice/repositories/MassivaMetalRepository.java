package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.dto.MassivaMetalicaDto;
import br.com.timbrasil.portalcop.massivaservice.dto.Relatorio;
import br.com.timbrasil.portalcop.massivaservice.model.MassivaMetal;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.MassivaSql;

public interface MassivaMetalRepository extends JpaRepository<MassivaMetal, Long>{
  @Query(value = MassivaSql.GET_MASSIVAS_METALICO)
  Optional<List<MassivaMetalicaDto>> getMassivasMetalica();

  @Query(value = MassivaSql.SQL_VERF_MASS_METAL_ABERTA)
  Optional<MassivaMetal> findByIdTpAcaoAndMsanAndParInicioAndParFim(Long idAcao, String msan, String parIni, String parFim);

  @Query(value = MassivaSql.SEARCH_OPEN_RMT)
  Optional<MassivaMetal> findByMsanAndParInicioAndParFim(String msan, String parIni, String parFim);

  @Query(value = "SELECT m FROM MassivaMetal m WHERE m.idMassiva = :idMassiva")
  Optional<MassivaMetal> findByIdMassiva(String idMassiva);

  @Query(value = MassivaSql.SQL_GET_CLIENTES_IMPACTADOS)
  List<Relatorio> getRelatorio(Long id);
}
