package br.com.timbrasil.portalcop.massivaservice.repositories.sql;

public class MassivaMetalicaMsgSql {
  public static final String CONTAGEM_CLIENTES_NRM = """
    INSERT INTO
      CICOP.COP_APP_METAL_MASS_SERVICEID (
        ID,
        FK_METAL_MASSIVA,
        SERVICEID,
        NRM_MDF,
        SGF_CAIXA,
        SGF_PAR,
        BSS_STATUS_BANDA_LARGA
      )
    SELECT
      CICOP.SQ_APP_METAL_MASS_SERVICEID.NEXTVAL,
      :id,
      BSS_SERVICE_ID,
      NRM_MDF,
      SGF_CAIXA,
      SGF_PAR,
      BSS_STATUS_BANDA_LARGA
    FROM
      CICOP.TB_INF_CADASTRO_CENTRALIZADO
    WHERE
      BSS_STATUS_BANDA_LARGA = 'Ativo'
      AND NRM_MSAN_GABINETE = :gabinete
      AND CICOP.FN_TO_NUMBER (REPLACE (NRM_MDF, 'MDF-', '')) BETWEEN :parInicio
      AND :parFim    
  """;

  public static final String CONTAGEM_CLIENTES_SGF = """
    INSERT INTO
      CICOP.COP_APP_METAL_MASS_SERVICEID (
        ID,
        FK_METAL_MASSIVA,
        SERVICEID,
        NRM_MDF,
        SGF_CAIXA,
        SGF_PAR,
        BSS_STATUS_BANDA_LARGA
      )
    SELECT
      CICOP.SQ_APP_METAL_MASS_SERVICEID.NEXTVAL,
      :id,
      BSS_SERVICE_ID,
      NRM_MDF,
      SGF_CAIXA,
      SGF_PAR,
      BSS_STATUS_BANDA_LARGA
    FROM
      CICOP.TB_INF_CADASTRO_CENTRALIZADO
    WHERE
      BSS_STATUS_BANDA_LARGA = 'Ativo'
      AND SGF_MSAN_GABINETE = :gabinete
      AND CICOP.FN_TO_NUMBER(SGF_PAR) BETWEEN :parInicio
      AND :parFim    
  """;
}
