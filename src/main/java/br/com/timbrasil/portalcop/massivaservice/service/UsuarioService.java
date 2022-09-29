package br.com.timbrasil.portalcop.massivaservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.timbrasil.portalcop.massivaservice.model.Modulo;
import br.com.timbrasil.portalcop.massivaservice.model.User;
import br.com.timbrasil.portalcop.massivaservice.model.Usuario;
import br.com.timbrasil.portalcop.massivaservice.repositories.ModuloRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.UserRepository;
import br.com.timbrasil.portalcop.massivaservice.repositories.UsuarioRepository;

@Service
public class UsuarioService {
  @Autowired
  UserRepository userRepository;

  @Autowired
  UsuarioRepository usuarioRepository;

  @Autowired
  ModuloRepository moduloRepository;

  public Long getIdUsuario(String matricula) {
    Optional<Usuario> usuario = usuarioRepository.findByfkId(matricula);
    if (usuario.isPresent()) {
      return usuario.get().getId();
    } else {
      Optional<User> user = userRepository.findByMatricula(matricula);
      if (user.isPresent()) {
        Usuario usuarioSalvo = usuarioRepository.save(new Usuario("USR", matricula, null));
        return usuarioSalvo.getId();
      } else {
        Optional<Modulo> modulo = moduloRepository.findByMatricula(matricula);
        if (modulo.isPresent()) {
          Usuario usuarioSalvo = usuarioRepository.save(new Usuario("SYS", null, matricula));
          return usuarioSalvo.getId();
        } else {
          throw new RuntimeException("Usuário não localizado no sistema.");
        }
      }
    }
  }
}
