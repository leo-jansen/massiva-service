package br.com.timbrasil.portalcop.massivaservice.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MassivaDto {
  private String ntt;
  private LocalDateTime dtAbertura;
  private String nomeAtividade;
  private String subTipoAbertura;
  private String prioridade;
  private String cidade;
  private LocalDateTime dtPrevisao;
  private Long qtd;
  private Long dtqIndisponiveis;
  private Long id;
  private String topologia;
  private Long qtdElementos;
  private String areaAbertura;
  private String estadoAtividade;
}
