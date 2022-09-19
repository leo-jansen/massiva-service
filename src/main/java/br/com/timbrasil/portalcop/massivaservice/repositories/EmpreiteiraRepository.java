package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.dto.EmpreiteiraDto;
import br.com.timbrasil.portalcop.massivaservice.model.Empreiteira;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.EmpreiteiraSql;

public interface EmpreiteiraRepository extends JpaRepository<Empreiteira, Long>{
  @Query(value = EmpreiteiraSql.GET_LIST_EMPREITEIRA)
  List<EmpreiteiraDto> getEmpreiteiraByAtiva();
}
