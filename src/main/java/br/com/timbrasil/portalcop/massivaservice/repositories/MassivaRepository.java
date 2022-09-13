package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.dto.MassivaMetalicaDto;
import br.com.timbrasil.portalcop.massivaservice.model.Massiva;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.MassivaSql;

public interface MassivaRepository extends JpaRepository<Massiva, Long>{
  @Query(value = MassivaSql.GET_MASSIVAS_METALICO)
  Optional<List<MassivaMetalicaDto>> getMassivasMetalica();

  @Query(value = MassivaSql.SQL_VERF_MASS_METAL_ABERTA)
  Optional<Massiva> findByIdTpAcaoAndMsanAndParInicioAndParFim(Long idAcao, String msan, String parIni, String parFim);

  @Query(value = MassivaSql.SEARCH_OPEN_RMT)
  Optional<Massiva> findByMsanAndParInicioAndParFim(String msan, String parIni, String parFim);

  @Query(value = "SELECT m FROM Massiva m WHERE m.idMassiva = :idMassiva")
  Optional<Massiva> findByIdMassiva(String idMassiva);
}
