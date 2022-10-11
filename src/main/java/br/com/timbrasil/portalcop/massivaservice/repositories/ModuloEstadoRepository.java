package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.model.ModuloEstado;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.ModuloEstadoSql;

public interface ModuloEstadoRepository extends JpaRepository<ModuloEstado, Long>{
  @Query(value = ModuloEstadoSql.SELECT_ID_ESTADO_BY_REFSTATUS_FKMODULO)
  Optional<Long> getIdByRefStatusAndFkModulo(String refStatus, Long idModulo);
}
