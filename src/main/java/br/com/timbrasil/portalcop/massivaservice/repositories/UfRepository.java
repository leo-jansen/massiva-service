package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.dto.UfDto;
import br.com.timbrasil.portalcop.massivaservice.model.Uf;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.UfSql;

public interface UfRepository extends JpaRepository<Uf, Long>{
  @Query(value = UfSql.SQL_GET_UF_CIDADE)
  List<UfDto> getListaUf();
}
