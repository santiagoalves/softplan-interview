package br.org.siege.softplan.exercicio2.core.exception;

import java.io.IOException;

public class InputParseFailedExecption extends RuntimeException {
    public InputParseFailedExecption(String msg, IOException ex) {
        super(msg, ex);
    }
}
