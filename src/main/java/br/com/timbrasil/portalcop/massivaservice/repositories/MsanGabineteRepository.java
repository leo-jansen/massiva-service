package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.model.MsanGabinete;

public interface MsanGabineteRepository extends JpaRepository<MsanGabinete, String>{
  @Query(value = "SELECT m.msanGabinete FROM MsanGabinete m WHERE m.cidade = :cidade")
  Optional<List<String>> getComboMsanByCidade(String cidade);
}
