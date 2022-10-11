package br.com.timbrasil.portalcop.massivaservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COP_APP_USER", schema = "CICOP")
public class User {
  @Id
  @Column(name = "MATRICULA")
  private String matricula;
  @Column(name = "NOME")
  private String nome;
  @Column(name = "EMPRESA")
  private String empresa;
  @Column(name = "DATACRIACAO")
  private LocalDateTime dataCriacao;
  @Column(name = "ACESSO")
  private boolean acesso;
  @Column(name = "SENHA")
  private String senha;
  @Column(name = "ID")
  private String id;
  @Column(name = "AREA")
  private String area;
  @Column(name = "DATAALT")
  private LocalDateTime dataAlt;
  @Column(name = "ATIVO")
  private boolean ativo;
  @Column(name = "ULTIMO_ACESSO")
  private LocalDateTime ultimoAcesso;
  @Column(name = "AREA_USUARIO")
  private String areaUsuario;
  @Column(name = "MOTIVO_BLOQUEIO")
  private String motivoBloqueio;
}
