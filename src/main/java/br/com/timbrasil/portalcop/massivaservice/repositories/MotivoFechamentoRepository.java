package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.dto.MotivoFechamentoDto;
import br.com.timbrasil.portalcop.massivaservice.model.MotivoFechamento;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.MotivoFechamentoSql;

public interface MotivoFechamentoRepository extends JpaRepository<MotivoFechamento, Long>{
  @Query(value = MotivoFechamentoSql.GET_LIST_MOTIVO_FECHAMENTO)
  List<MotivoFechamentoDto> getComboMotivoFechamento(String descAcao);
}
