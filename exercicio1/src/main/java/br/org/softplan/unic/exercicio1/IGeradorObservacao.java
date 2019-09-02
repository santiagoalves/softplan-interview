package br.org.softplan.unic.exercicio1;

/**
 *
 * @param <T>
 * @param <R>
 */
public interface IGeradorObservacao<T, R> {

    /**
     *
     * @param t valor base para alimentar o gerador de observacao
     * @return objeto representando a observação gerada
     */
    R geraObservacao(T t);

}
