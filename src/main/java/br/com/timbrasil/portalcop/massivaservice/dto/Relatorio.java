package br.com.timbrasil.portalcop.massivaservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Relatorio {
  private String idMassiva;
  private String serviceId;
  private String mdf;
  private String caixa;
  private String par;
}
