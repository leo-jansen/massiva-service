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
}
