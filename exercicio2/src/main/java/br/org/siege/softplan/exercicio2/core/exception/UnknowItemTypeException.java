package br.org.siege.softplan.exercicio2.core.exception;

public class UnknowItemTypeException extends RuntimeException {

    public UnknowItemTypeException(String unknowType) {
        super(String.format("Unknow type of item: %s", unknowType));
    }
}
