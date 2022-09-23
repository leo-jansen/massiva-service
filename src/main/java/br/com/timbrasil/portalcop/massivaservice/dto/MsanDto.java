package br.com.timbrasil.portalcop.massivaservice.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MsanDto {
  @Id
  private String msan;
  private Long modelo;
  private String uf;
  /* dto com anotação de entidade e id para o retorno do entityManager.createNativeQuery(sql).getResultList()
  funcionar, para não precisar criar 16 novas entidades e funções de conversão de entidade para dto, prazo apertado.
  me desculpe */ 
}
