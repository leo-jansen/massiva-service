package br.com.timbrasil.portalcop.massivaservice.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MassivaMetalicaDto {
  private long id;
  private String idMassiva;
  private int idAcao;
  private String descAcao;
  private String dataAbertura;
  private String tipo;
  private int status;
  private String msan;
  private String parInicio;
  private String parFim;
  private String uf;
  private String cidade;
  private int idFalha;
  private String descFalha;
  private int idArea;
  private String descArea;
  private LocalDateTime prazo;
  private String expirado;
  private String empreiteira;
  private String qtdClientes;
  private String dataInicioIndisponibilidade;
  private String dataFimIndisponibilidade;
  private int indisponibilidade;
  private String observacao;
}
