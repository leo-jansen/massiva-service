package br.com.timbrasil.portalcop.massivaservice.repositories.sql;

public class ModuloEstadoSql {
  public static final String SELECT_ID_ESTADO_BY_REFSTATUS_FKMODULO = """
    SELECT
      m.id
    FROM
      ModuloEstado m
    WHERE
      m.refEstado = :refStatus
      AND m.fkModulo = :idModulo    
  """;
}
