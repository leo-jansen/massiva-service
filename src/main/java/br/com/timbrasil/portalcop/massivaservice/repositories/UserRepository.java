package br.com.timbrasil.portalcop.massivaservice.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.timbrasil.portalcop.massivaservice.model.User;

public interface UserRepository extends JpaRepository<User, String> {
  @Query(value = "SELECT u FROM User u WHERE u.matricula = :matricula")
  Optional<User> findByMatricula(String matricula);
}
