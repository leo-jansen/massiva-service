package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.dto.TipoDto;
import br.com.timbrasil.portalcop.massivaservice.model.AtividadeTipo;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.TipoAtividadeSql;

public interface AtividadeTipoRepository extends JpaRepository<AtividadeTipo, Long>{
  @Query(value = TipoAtividadeSql.SQL_SELECT_ATIVIDADE_TIPO_MODULO)
  List<TipoDto> getAtividadeMassiva();

  @Query(value = TipoAtividadeSql.SQL_SELECT_ATIVIDADE_TIPO_ID)
  Optional<Long> getIdByFkModuloAndNomeAtividade(String tipoAtividade, Long idModulo);
}
