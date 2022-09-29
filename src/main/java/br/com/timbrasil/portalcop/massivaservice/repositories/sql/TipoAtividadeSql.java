package br.com.timbrasil.portalcop.massivaservice.repositories.sql;

public class TipoAtividadeSql {
  public static final String SQL_SELECT_ATIVIDADE_TIPO_MODULO = """
    SELECT
      new br.com.timbrasil.portalcop.massivaservice.dto.TipoDto(
        tipo.id,
        tipo.nomeAtividade
      )
    FROM
      AtividadeTipo tipo
    WHERE
      tipo.fkModulo = (
        SELECT
          m.id
        FROM
          Modulo m
        WHERE
          m.moduloName = 'MASSIVA'
      )
    ORDER BY
      tipo.nomeAtividade
  """;

  public static final String SQL_SELECT_ATIVIDADE_TIPO_ID = """
    SELECT
      tipo.id
    FROM
      AtividadeTipo tipo
    WHERE
      tipo.nomeAtividade = :tipoAtividade
      AND tipo.fkModulo = :idModulo
  """;
}
