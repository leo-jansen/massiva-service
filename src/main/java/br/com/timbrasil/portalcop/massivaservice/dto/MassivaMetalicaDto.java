package br.com.timbrasil.portalcop.massivaservice.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MassivaMetalicaDto {
  private Long id;
  private String idMassiva;
  private Long idAcao;
  private String descAcao;
  private String dataAbertura;
  private String tipo;
  private Long status;
  private String msan;
  private String parInicio;
  private String parFim;
  private String uf;
  private String cidade;
  private Long idFalha;
  private String descFalha;
  private Long idArea;
  private String descArea;
  private LocalDateTime prazo;
  private String expirado;
  private String empreiteira;
  private String qtdClientes;
  private String dataInicioIndisponibilidade;
  private String dataFimIndisponibilidade;
  private Long indisponibilidade;
  private String observacao;
}
