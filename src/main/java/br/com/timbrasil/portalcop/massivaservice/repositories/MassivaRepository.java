package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.dto.MassivaDto;
import br.com.timbrasil.portalcop.massivaservice.model.Massiva;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.MassivaSql;

public interface MassivaRepository extends JpaRepository<Massiva, Long>{
  @Query(value = MassivaSql.QUERY_LISTA_MASSIVAS_ABERTAS)
  List<MassivaDto> getListaMassivas();
}
