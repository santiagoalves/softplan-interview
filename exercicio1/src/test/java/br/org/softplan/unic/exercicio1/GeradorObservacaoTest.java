package br.org.softplan.unic.exercicio1;

import br.org.softplan.unic.exercicio1.remessa_simples.padrao.GeradorObservacao;
import br.org.softplan.unic.exercicio1.util.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GeradorObservacaoTest {

    @Test
    public void deve_gerar_observacao_conforme_template_legado_singular() {
        final String observacaoEsperada = "Fatura da nota fiscal de simples remessa: 5.";
        final IGeradorObservacao<List<Integer>, String> geradorObservacao = new GeradorObservacao();
        final String observacaoGerada = geradorObservacao.geraObservacao(Collections.singletonList(5));
        Assert.assertEquals(observacaoEsperada, observacaoGerada);
    }

    @Test
    public void deve_gerar_observacao_conforme_template_legado_plural() {
        final String resultadoEsperado = "Fatura das notas fiscais de simples remessa: 1, 2, 3, 4 e 5.";
        final IGeradorObservacao<List<Integer>, String> geradorObservacao = new GeradorObservacao();
        final String observacao = geradorObservacao.geraObservacao(Arrays.asList(1, 2, 3, 4, 5));
        Assert.assertEquals(resultadoEsperado, observacao);
    }

    @Test
    public void deve_gerar_valor_padrao_se_lista_codigos_estiver_vazia() {
        final IGeradorObservacao<List<Integer>, String> geradorObservacao = new GeradorObservacao();
        final String observacao = geradorObservacao.geraObservacao(Collections.emptyList());
        Assert.assertEquals(Utils.MSG_BUNDLE.getString(MsgBundleProperties.DEFAULT_VALUE), observacao);
    }

    @Test(expected = CodigosRemessaSimplesUndefinedException.class)
    public void deve_gerar_excecao_se_lista_codigos_for_indefinida() {
        new GeradorObservacao().geraObservacao(null);
    }

}
