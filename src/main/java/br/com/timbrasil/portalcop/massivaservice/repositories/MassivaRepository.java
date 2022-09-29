package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.dto.MassivaDetalhadaDto;
import br.com.timbrasil.portalcop.massivaservice.dto.MassivaDto;
import br.com.timbrasil.portalcop.massivaservice.model.Massiva;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.MassivaSql;

public interface MassivaRepository extends JpaRepository<Massiva, Long>{
  @Query(value = MassivaSql.QUERY_LISTA_MASSIVAS_ABERTAS)
  List<MassivaDto> getListaMassivas();

  @Query(value = MassivaSql.SEARCH_NTT)
  Optional<Massiva> findByNtt(String ntt);

  @Query(value = MassivaSql.QUERY_BUSCAR_MASSIVA)
  Optional<MassivaDetalhadaDto> getMassivaById(Long idMassiva);
}
