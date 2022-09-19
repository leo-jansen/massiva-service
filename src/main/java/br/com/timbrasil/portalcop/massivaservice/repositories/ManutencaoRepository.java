package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.dto.ManutencaoDto;
import br.com.timbrasil.portalcop.massivaservice.model.Manutencao;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.ManutencaoSql;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long>{
  @Query(value = ManutencaoSql.GET_LIST_TIPO_MANUTENCAO)
  List<ManutencaoDto> getComboTipoManutencaoMetal(Long idTpAcao);
}
