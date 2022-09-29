package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.model.Usuario;
import br.com.timbrasil.portalcop.massivaservice.repositories.sql.UsuarioSql;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
  @Query(value = UsuarioSql.FK_ID, nativeQuery = true)
  Optional<Usuario> findByfkId(String matricula);
}
