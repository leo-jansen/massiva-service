package br.com.timbrasil.portalcop.massivaservice.repositories.sql;

public class PortaSql {
  public static final String QUERIE_SLOTS_POR_MSAN = """
    SELECT
      DISTINCT FK_MODELO AS MODELO,
      SLOT
    FROM
      CICOP.TB_PORTA_DE_TESTE
    ORDER BY
      FK_MODELO,
      SLOT    
  """;
}
