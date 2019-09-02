package br.org.softplan.unic.exercicio1.remessa_simples.customizada.formatter;

import br.org.softplan.unic.exercicio1.ObservacaoFormatter;
import br.org.softplan.unic.exercicio1.remessa_simples.customizada.dao.RemessaSimplesDao;

import java.math.BigDecimal;
import java.util.List;

import static br.org.softplan.unic.exercicio1.MsgBundleProperties.*;
import static br.org.softplan.unic.exercicio1.util.Utils.INSTANCE_CURRENCY_FORMATER;
import static br.org.softplan.unic.exercicio1.util.Utils.MSG_BUNDLE;

public class SingularCustomizadoFormatter implements ObservacaoFormatter<List<Integer>, String> {

    private static SingularCustomizadoFormatter singularCustomizadoFormatter;

    private RemessaSimplesDao remessaSimplesDao;

    private SingularCustomizadoFormatter(RemessaSimplesDao remessaSimplesDao) {
        this.remessaSimplesDao = remessaSimplesDao;
    }

    public static SingularCustomizadoFormatter instance(RemessaSimplesDao remessaSimplesDao) {
        if (singularCustomizadoFormatter == null) {
            singularCustomizadoFormatter = new SingularCustomizadoFormatter(remessaSimplesDao);
        }
        return singularCustomizadoFormatter;
    }

    @Override
    public String formmat(List<Integer> codigos) {
        Integer codigo = codigos.get(0);
        BigDecimal preco = remessaSimplesDao.encontrarPrecoParaCodigo(codigo);
        String precoFormatado = String.format(MSG_BUNDLE.getString(CUSTOM_TEMPLATE_OCORRENCIA),
                codigo, INSTANCE_CURRENCY_FORMATER.format(preco));
        return String.format(MSG_BUNDLE.getString(CUSTOM_TEMPLATE_TOTAL_SINGULAR)
                , MSG_BUNDLE.getString(PREFIXO_SINGULAR), precoFormatado);
    }

}
