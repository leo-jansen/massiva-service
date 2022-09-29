package br.com.timbrasil.portalcop.massivaservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.timbrasil.portalcop.massivaservice.model.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long>{
  
}
