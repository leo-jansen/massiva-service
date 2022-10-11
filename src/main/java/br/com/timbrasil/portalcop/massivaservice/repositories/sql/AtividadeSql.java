package br.com.timbrasil.portalcop.massivaservice.repositories.sql;

public class AtividadeSql {
  public static final String SQL_INSERT_HISTORICO = """
    INSERT INTO
      CICOP.TB_HISTORICO (
        ID,
        FK_ATIVIDADE,
        FK_MENSAGEM,
        CONTEUDO_HIST,
        DT_INC_HIST,
        FK_USR_INC_HIST
      )
    VALUES
      (
        CICOP.SQ_HIST_ATIVIDADE_ID_HIST.NEXTVAL,
        :idAtividade,
        :idMensagem,
        :msg,
        SYSDATE,
        :idUsuario
      )
  """;
}
