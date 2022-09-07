package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.model.UfCidade;

public interface UfCidadeRepository extends JpaRepository<UfCidade, Long>{
  @Query(value = "SELECT DISTINCT u.uf FROM UfCidade u ORDER BY u.uf")
  List<String> getComboUfs();

  @Query(value = "SELECT DISTINCT u.cidade FROM UfCidade u WHERE u.cidade = :cidade ORDER BY u.uf")
  List<String> getComboCidade(String cidade);
}
