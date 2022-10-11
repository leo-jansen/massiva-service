package br.com.timbrasil.portalcop.massivaservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.timbrasil.portalcop.massivaservice.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long>{
  
}
