package br.org.softplan.unic.exercicio1;

import static br.org.softplan.unic.exercicio1.MsgBundleProperties.CODIGO_REMESSA_UNDEFINED_EXCEPTION;
import static br.org.softplan.unic.exercicio1.util.Utils.MSG_BUNDLE;

public class CodigosRemessaSimplesUndefinedException extends RuntimeException {

    public CodigosRemessaSimplesUndefinedException() {
        super(MSG_BUNDLE.getString(CODIGO_REMESSA_UNDEFINED_EXCEPTION));
    }
}
