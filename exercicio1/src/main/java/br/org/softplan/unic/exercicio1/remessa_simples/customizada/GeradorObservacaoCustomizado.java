package br.org.softplan.unic.exercicio1.remessa_simples.customizada;

import br.org.softplan.unic.exercicio1.CodigosRemessaSimplesUndefinedException;
import br.org.softplan.unic.exercicio1.IGeradorObservacao;
import br.org.softplan.unic.exercicio1.remessa_simples.customizada.dao.RemessaSimplesCustomizadaDao;
import br.org.softplan.unic.exercicio1.remessa_simples.customizada.dao.RemessaSimplesDao;
import br.org.softplan.unic.exercicio1.remessa_simples.customizada.formatter.PluralCustomizadoFormatter;
import br.org.softplan.unic.exercicio1.remessa_simples.customizada.formatter.SingularCustomizadoFormatter;

import java.util.List;

import static br.org.softplan.unic.exercicio1.MsgBundleProperties.DEFAULT_VALUE;
import static br.org.softplan.unic.exercicio1.util.Utils.MSG_BUNDLE;

public class GeradorObservacaoCustomizado implements IGeradorObservacao<List<Integer>, String> {

    private RemessaSimplesDao remessaSimplesDao;

    public GeradorObservacaoCustomizado() {
        remessaSimplesDao = new RemessaSimplesCustomizadaDao();
    }

    @Override
    public String geraObservacao(List<Integer> codigos) {
        if (codigos == null) {
            throw new CodigosRemessaSimplesUndefinedException();
        }

        if (codigos.isEmpty()) {
            return MSG_BUNDLE.getString(DEFAULT_VALUE);
        }

        if (codigos.size() > 1) {
            return PluralCustomizadoFormatter.instance(remessaSimplesDao).formmat(codigos);
        }
        return SingularCustomizadoFormatter.instance(remessaSimplesDao).formmat(codigos);
    }

}
