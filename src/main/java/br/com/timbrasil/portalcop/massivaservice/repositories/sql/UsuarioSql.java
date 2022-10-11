package br.com.timbrasil.portalcop.massivaservice.repositories.sql;

public class UsuarioSql {
  public static final String FK_ID = """
    SELECT
      u
    FROM
      Usuario u
    WHERE
      NVL (u.fkUsr, u.fkApp) = :matricula 
  """;
}
