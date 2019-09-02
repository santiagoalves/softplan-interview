package br.org.softplan.unic.exercicio1.remessa_simples.customizada.formatter;

import br.org.softplan.unic.exercicio1.ObservacaoFormatter;
import br.org.softplan.unic.exercicio1.remessa_simples.customizada.TotalizadorPreco;
import br.org.softplan.unic.exercicio1.remessa_simples.customizada.dao.RemessaSimplesDao;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static br.org.softplan.unic.exercicio1.MsgBundleProperties.*;
import static br.org.softplan.unic.exercicio1.util.Utils.INSTANCE_CURRENCY_FORMATER;
import static br.org.softplan.unic.exercicio1.util.Utils.MSG_BUNDLE;

public class PluralCustomizadoFormatter implements ObservacaoFormatter<List<Integer>, String> {

    private RemessaSimplesDao remessaSimplesDao;
    private static PluralCustomizadoFormatter pluralCustomizadoFormatter;

    private PluralCustomizadoFormatter(RemessaSimplesDao remessaSimplesDao) {
        this.remessaSimplesDao = remessaSimplesDao;
    }

    public static PluralCustomizadoFormatter instance(RemessaSimplesDao remessaSimplesDao) {
        if (pluralCustomizadoFormatter == null) {
            pluralCustomizadoFormatter = new PluralCustomizadoFormatter(remessaSimplesDao);
        }
        return pluralCustomizadoFormatter;
    }

    @Override
    public String formmat(List<Integer> codigos) {

        final TotalizadorPreco totalizador = new TotalizadorPreco();
        final int indexUltimoElemento = codigos.size() - 1;

        final String ocorrencias = codigos.subList(0, indexUltimoElemento)
                .stream()
                .map(codigo -> formatarOcorrencias(codigo, totalizador))
                .collect(Collectors.joining(", ")).concat(" e ")
                .concat(formatarOcorrencias(codigos.get(indexUltimoElemento), totalizador));

        return String.format(
                MSG_BUNDLE.getString(CUSTOM_TEMPLATE_TOTAL_PLURAL)
                , MSG_BUNDLE.getString(PREFIXO_PLURAL)
                , ocorrencias, totalizador);

    }

    private String formatarOcorrencias(Integer codigo, TotalizadorPreco totalizador) {
        return String.format(MSG_BUNDLE.getString(CUSTOM_TEMPLATE_OCORRENCIA), codigo, encontrarPrecoParaCodigo(codigo, totalizador));
    }

    private String encontrarPrecoParaCodigo(Integer codigo, TotalizadorPreco totalizador) {
        BigDecimal preco = remessaSimplesDao.encontrarPrecoParaCodigo(codigo);
        totalizador.somar(preco);
        return INSTANCE_CURRENCY_FORMATER.format(preco);
    }

}
