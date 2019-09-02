
import java.util.Iterator;
import java.util.List;

public class GeradorObservacao {

	// TODO a formatação do valor de preço não está correta pois o valor do total não leva o simbolo de preço
	// enquanto as ocorrência levam...
	// TODO a mensagem poderia ser coloda em um builder próprio...
	//Textos pr�-definidos
	static final String umoNota = "Fatura da nota fiscal de simples remessa: ";
	// TODO remover campo temporario
	//Identificador da entidade
	String texto;

	//Gera observa��es, com texto pre-definido, incluindo os n�meros, das notas fiscais, recebidos no par�metro
	public String geraObservacao(List lista)
	{ //TODO falta de padrão na organização do código
		texto = "";
		// TODO possível nullpointerException
		if (!lista.isEmpty())
		{
			return retornaCodigos(lista) + ".";
		}
		return "";
	}

	//TODO não está definindo o valor da lista
	//Cria observa��o
	private String retornaCodigos(List lista) {
		if (lista.size() >= 2) {
			texto = "Fatura das notas fiscais de simples remessa: ";
		} else {
			texto = umoNota;
		}

		//Acha separador
		StringBuilder cod = new StringBuilder();
		for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
			Integer c = iterator.next();
			String s = "";
			if( cod.toString() == null || cod.toString().length() <= 0 )
				s =  "";
				else if( iterator.hasNext() )
					s =  ", ";
				else
					s =  " e ";

			cod.append(s + c);
		}

		return texto + cod;
	}
}