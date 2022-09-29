package br.com.timbrasil.portalcop.massivaservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "TB_USUARIO", schema = "CICOP")
public class Usuario {
  @Id
  @Column(name = "ID")
  @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SQ_USUARIOS_ID_USR", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
  private Long id;
  @NotNull
  @Column(name = "TIPO_USUARIO")
  private String tipoUsuario;
  @Column(name = "FK_USR")
  private String fkUsr;
  @Column(name = "FK_APP")
  private String fkApp;

  public Usuario(String tipoUsuario, String fkUsr, String fkApp) {
    this.tipoUsuario = tipoUsuario;
    this.fkUsr = fkUsr;
    this.fkApp = fkApp;
  }
}