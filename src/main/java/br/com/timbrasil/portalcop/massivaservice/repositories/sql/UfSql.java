package br.com.timbrasil.portalcop.massivaservice.repositories.sql;

public class UfSql {
  public static final String SQL_GET_UF_CIDADE = """
    SELECT
      new br.com.timbrasil.portalcop.massivaservice.dto.UfDto(
        CIDADE.id,
        CONCAT(UF.sigla, '/', CIDADE.nome)
      )  
    FROM
      Cidade CIDADE
      JOIN Uf UF ON CIDADE.fkUf = UF.id
    WHERE
      CIDADE.flagAtivo = 1
      AND UF.flagAtivo = 1
    ORDER BY
      UF.nome,
      CIDADE.nome
  """;
}
