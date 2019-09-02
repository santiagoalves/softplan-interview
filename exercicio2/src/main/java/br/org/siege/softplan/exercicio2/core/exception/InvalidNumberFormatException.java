package br.org.siege.softplan.exercicio2.core.exception;

public class InvalidNumberFormatException extends RuntimeException {
    public InvalidNumberFormatException(String value) {
        super(String.format("Invalid number value: %s", value));
    }
}
