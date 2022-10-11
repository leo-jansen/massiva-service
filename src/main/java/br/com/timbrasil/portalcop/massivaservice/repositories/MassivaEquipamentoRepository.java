package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.model.MassivaEquipamento;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.MassivaSql;

public interface MassivaEquipamentoRepository extends JpaRepository<MassivaEquipamento, Long>{
  @Query(value = MassivaSql.SQL_BUSCAR_EQUIPAMENTOS_MASSIVA_SELECT)
  List<String> getEquipamentosByFkMassiva(Long idMassiva);
}
