package br.com.timbrasil.portalcop.massivaservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "COP_APP_METAL_MASSIVA_MSG", schema = "CICOP")
public class MassivaMetalicaMsg {
  @Id
  @Column(name = "MSG_ID")
  @SequenceGenerator(name = "TB_METAL_MASSIVA_MSG_ID_GENERATOR", sequenceName = "SQ_COP_APP_METAL_MASIVA_MSG", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_METAL_MASSIVA_MSG_ID_GENERATOR")
  private Long msgId;
  @Column(name = "DT_ACAO")
  private LocalDateTime dataAcao;
  @Column(name = "ID_MASSIVA")
  private String idMassiva;
  @Column(name = "USUARIO")
  private String usuario;
  @Column(name = "ACAO_EXEC")
  private String acaoExec;
}
