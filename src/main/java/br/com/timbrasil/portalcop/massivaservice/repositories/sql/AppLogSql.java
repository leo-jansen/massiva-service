package br.com.timbrasil.portalcop.massivaservice.repositories.sql;

public class AppLogSql {
  public static final String SQL_INS_COP_APP_LOG = """
    INSERT INTO
      CICOP.COP_APP_LOG (
        DATAACAO,
        ACAO,
        MATRICULA,
        PERFIL,
        IDLG,
        ORDEM,
        STATUS,
        SERVICE_ID,
        NTT,
        RESULTADO
      )
    VALUES
      (
        SYSDATE,
        :acao,
        :matricula,
        :perfil,
        :idLg,
        :ordem,
        :status,
        :serviceId,
        :ntt,
        :resultado
      )    
  """;
}
