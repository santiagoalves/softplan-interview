package br.org.softplan.unic.exercicio1;

import br.org.softplan.unic.exercicio1.remessa_simples.customizada.GeradorObservacaoCustomizado;
import br.org.softplan.unic.exercicio1.util.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GeradorObservacaoCustomizadoTest {

    @Test
    public void deve_gerar_observacao_conforme_template_customizado_singular() {
        final String observacaoEsperada = "Fatura da nota fiscal de simples remessa: 5 cujo valor é R$ 0,30.";
        final IGeradorObservacao<List<Integer>, String> geradorObservacao = new GeradorObservacaoCustomizado();
        final String observacaoGerada = geradorObservacao.geraObservacao(Collections.singletonList(5));
        Assert.assertEquals(observacaoEsperada, observacaoGerada);
    }

    @Test
    public void deve_gerar_observacao_conforme_template_customizado_plural() {
        final String resultadoEsperado = "Fatura das notas fiscais de simples remessa: " +
                "1 cujo valor é R$ 10,00, 2 cujo valor é R$ 35,00, 3 cujo valor é " +
                "R$ 5,00, 4 cujo valor é R$ 1.500,00 e 5 cujo valor é R$ 0,30. " +
                "Total = 1.550,30.";
        final IGeradorObservacao<List<Integer>, String> geradorObservacao = new GeradorObservacaoCustomizado();
        final String observacao = geradorObservacao.geraObservacao(Arrays.asList(1, 2, 3, 4, 5));
        Assert.assertEquals(resultadoEsperado, observacao);
    }

    @Test
    public void deve_gerar_valor_padrao_se_nao_houver_codigos() {
        final IGeradorObservacao<List<Integer>, String> geradorObservacao = new GeradorObservacaoCustomizado();
        final String observacao = geradorObservacao.geraObservacao(Collections.emptyList());
        Assert.assertEquals(Utils.MSG_BUNDLE.getString(MsgBundleProperties.DEFAULT_VALUE), observacao);
    }

    @Test(expected = CodigosRemessaSimplesUndefinedException.class)
    public void deve_gerar_excecao_se_lista_codigos_for_indefinida() {
        new GeradorObservacaoCustomizado().geraObservacao(null);
    }

}
