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
@Table(name = "COP_APP_METAL_MASSIVA", schema = "CICOP")
public class MassivaMetal {
  @Id
  @SequenceGenerator(name = "TB_METAL_MASSIVA_ID_GENERATOR", sequenceName = "COP_SEQ_METAL_MASSIVA", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TB_METAL_MASSIVA_ID_GENERATOR")
  private Long id;
  @Column(name = "ID_MASSIVA")
  private String idMassiva;
  @Column(name = "ID_TP_ACAO")
  private Long idTpAcao;
  @Column(name = "DT_ABERTURA")
  private LocalDateTime dataAbertura;
  @Column(name = "USU_ABERTURA")
  private String usuarioAbertura;
  @Column(name = "DT_FIM")
  private LocalDateTime dataFim;
  @Column(name = "USU_FIM")
  private String usuarioFim;
  @Column(name = "TIPO")
  private String tipo;
  @Column(name = "STATUS")
  private Long status;
  @Column(name = "MSAN")
  private String msan;
  @Column(name = "PAR_INI")
  private String parInicio;
  @Column(name = "PAR_FIM")
  private String parFim;
  @Column(name = "UF")
  private String uf;
  @Column(name = "CIDADE")
  private String cidade;
  @Column(name = "ID_TP_FALHA")
  private Long idTpFalha;
  @Column(name = "ID_AREA")
  private Long idArea;
  @Column(name = "PRAZO")
  private LocalDateTime prazo;
  @Column(name = "DT_ACEITE")
  private LocalDateTime dataAceite;
  @Column(name = "USU_ACEITE")
  private String usuarioAceite;
  @Column(name = "ID_MOTIVO_REJEICAO")
  private Long idMotivoRejeicao;
  @Column(name = "ID_MOTIVO_FECHAMENTO")
  private Long idMotivoFechamento;
  @Column(name = "EMPREITEIRA")
  private String empreiteira;
  @Column(name = "OBSERVACAO")
  private String observacao;
  @Column(name = "ID_TP_MANUTENCAO")
  private Long idTpManutencao;
  @Column(name = "DT_MANUTENCAO_PROGRAMADA")
  private LocalDateTime dataManutencaoProg;
  @Column(name = "USU_ATUALIZADO")
  private String usuarioAtualizado;
  @Column(name = "DT_ATUALIZADO")
  private LocalDateTime dataAtualizado;
  @Column(name = "FILE_ID")
  private String fileId;
  @Column(name = "QTD_CLIENTES")
  private Long quantClientes;
  @Column(name = "DT_INI_INDISPONIBILIDADE")
  private LocalDateTime dataIniIndisp;
  @Column(name = "DT_FIM_INDISPONIBILIDADE")
  private LocalDateTime dataFimIndisp;

  public MassivaMetal(Long idTpAcao, String usuarioAbertura, String tipo, String msan, String parInicio, String parFim,
      String uf, String cidade, Long idTpFalha, Long idArea, LocalDateTime prazo, String empreiteira, String observacao,
      Long idTpManutencao, LocalDateTime dataManutencaoProg, String fileId, LocalDateTime dataIniIndisp,
      LocalDateTime dataFimIndisp) {
    this.idTpAcao = idTpAcao;
    this.dataAbertura = LocalDateTime.now();
    this.usuarioAbertura = usuarioAbertura;
    this.tipo = tipo;
    this.msan = msan;
    this.parInicio = parInicio;
    this.parFim = parFim;
    this.uf = uf;
    this.cidade = cidade;
    this.idTpFalha = idTpFalha;
    this.idArea = idArea;
    this.prazo = prazo;
    this.empreiteira = empreiteira;
    this.observacao = observacao;
    this.idTpManutencao = idTpManutencao;
    this.dataManutencaoProg = dataManutencaoProg;
    this.fileId = fileId;
    this.dataIniIndisp = dataIniIndisp;
    this.dataFimIndisp = dataFimIndisp;
    this.quantClientes = 0L;
  }
}
