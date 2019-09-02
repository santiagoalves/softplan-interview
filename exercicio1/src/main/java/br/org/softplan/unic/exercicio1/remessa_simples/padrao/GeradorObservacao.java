package br.org.softplan.unic.exercicio1.remessa_simples.padrao;

import br.org.softplan.unic.exercicio1.CodigosRemessaSimplesUndefinedException;
import br.org.softplan.unic.exercicio1.IGeradorObservacao;
import br.org.softplan.unic.exercicio1.remessa_simples.padrao.formatter.PluralFormatter;
import br.org.softplan.unic.exercicio1.remessa_simples.padrao.formatter.SingularFormatter;

import java.util.List;

import static br.org.softplan.unic.exercicio1.MsgBundleProperties.DEFAULT_VALUE;
import static br.org.softplan.unic.exercicio1.util.Utils.MSG_BUNDLE;

public class GeradorObservacao implements IGeradorObservacao<List<Integer>, String> {

    public String geraObservacao(List<Integer> codigos) {

        if (codigos == null) {
            throw new CodigosRemessaSimplesUndefinedException();
        }

        if (codigos.isEmpty()) {
            return MSG_BUNDLE.getString(DEFAULT_VALUE);
        }

        if (codigos.size() > 1) {
            return PluralFormatter.instance().formmat(codigos);
        }

        return SingularFormatter.instance().formmat(codigos);

    }

}
