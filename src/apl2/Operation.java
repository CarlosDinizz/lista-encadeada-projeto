
//*************************** ATENÇÃO! *****************************
// As assinaturas dos métodos desta classe não devem ser alteradas!
//*************************** ATENÇÃO! *****************************
// arquivo: src/apl2/Operation.java

// TODO: Colocar a identificação dos(as) integrantes aqui.
//Arthur Roldan Slikta 							RA: 10353847
//Carlos Eduardo Diniz de Almeida 				RA: 10444407
//Guilherme Clauz Morlina da Silva 				RA: 10436477

package apl2;

public class Operation {

	/**
	 * <p>Recebe como parâmetro uma lista encadeada do tipo {@code LinkedListOriginal}, sendo que os nós da lista estão
	 * populados com o conteúdo da base de dados original (conteúdo do arquivo dados.txt).</p>
	 * <p>A operação {@code map()} deve mapear os dados originais para uma lista encadeada do tipo {@code DLinkedList} e
	 * retornar a referência da {@code DLinkedList} que possui os dados mapeados para a nova estrutura usada pelo sistema de notas.</p>
	 * 
	 * @param original Base de dados original carregada em uma {@code LinkedListOriginal}.
	 * @return Uma nova {@code DLinkedList} que contém o mapeamento da coleção de dados {@code original} para a nova estrutura usada pelo sistema de notas. 
	 */
	public static DLinkedList map(final LinkedListOriginal original) {
		DLinkedList newLinkedList = new DLinkedList();
		NodeOriginal nodeOriginal = original.getHead();

		while (nodeOriginal != null){
			String newId = "23.S1-" + String.valueOf(nodeOriginal.getId());
			String nome = nodeOriginal.getNome();
			Float nota = 99.9f;

			if (nodeOriginal.getInteiro() != -1){
				if (nodeOriginal.getDecimo() != -1){
					String notaString =
							String.valueOf(nodeOriginal.getInteiro()) +
							"." +
							String.valueOf(nodeOriginal.getDecimo());
					nota = Float.valueOf(notaString);
				}
			}

			newLinkedList.append(newId, nome, nota);
			nodeOriginal = nodeOriginal.getNext();
		}

		return newLinkedList;
	}

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code map()}.</p>
	 * <p>A operação {@code filterRemoveNonGraded()} deve filtrar os nós que não possuem notas válidas (caso de "ausência de nota")
	 * e retornar uma nova lista do tipo {@code DLinkedList} contendo apenas os nós com notas válidas.</p>
	 * 
	 * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
	 * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada com nós que possuem apenas pessoas com notas válidas.
	 */
	public static DLinkedList filterRemoveNonGraded(final DLinkedList data) {
		DLinkedList dataFiltered = new DLinkedList();

		Node headData = data.getHead();

		while (headData != null){
			if (headData.getNota() <= 10.0f){
				dataFiltered.append(headData.getId(), headData.getNome(), headData.getNota());
			}
			headData = headData.getNext();
		}

		return dataFiltered;
	}

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code map()}.</p>
	 * <p>A operação {@code filterRemoveGraded()} deve filtrar os nós que possuem notas válidas e retornar uma nova lista do
	 * tipo {@code DLinkedList} contendo apenas os nós com notas inválidas (caso de "ausência de nota").</p>
	 * 
	 * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
	 * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada com nós que possuem apenas pessoas com notas inválidas.
	 */
	public static DLinkedList filterRemoveGraded(final DLinkedList data) {
		DLinkedList dataFiltered = new DLinkedList();

		Node headData = data.getHead();

		while (headData != null){
			if (headData.getNota() == 99.9f){
				dataFiltered.append(headData.getId(), headData.getNome(), headData.getNota());
			}
			headData = headData.getNext();
		}

		return dataFiltered;
	}

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code filterRemoveNonGraded()}, e a média de notas válidas, calculadas com a
	 * operação {@code reduce()}.</p>
	 * <p>A operação {@code filterRemoveBelowAverage()} deve filtrar os nós que possuem notas abaixo da média e retornar uma
	 * nova lista do tipo {@code DLinkedList} contendo apenas os nós com notas acima da média.
	 * 
	 * @param data Base de dados filtrada com a operação {@code filterRemoveNonGraded()}.
	 * @param average Média de notas válidas calculada com a operação {@code reduce()}.
	 * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada somente com pessoas com notas maiores do que {@code average}.
	 */
	public static DLinkedList filterRemoveBelowAverage(final DLinkedList data, float average) {
		DLinkedList dataFiltered = new DLinkedList();

		Node theHead = data.getHead();

		while(theHead != null){
			if (theHead.getNota() > average){
				dataFiltered.append(theHead.getId(), theHead.getNome(), theHead.getNota());
			}
			theHead = theHead.getNext();
		}

		return dataFiltered;
	}
	
	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code filterRemoveNonGraded()}.</p>
	 * <p>A operação {@code reduce()} deve calcular a média das notas contidas na coleção de dados passada como parâmetro e
	 * retornar a média calculada.
	 * 
	 * @param data Base de dados filtrada com a operação {@code filterRemoveNonGraded()}.
	 * @return Média das notas ({@code float}) contidas na coleção de dados ({@code data}).
	 */
	public static float reduce(final DLinkedList data) {

		Node temp = data.getHead(); // armazena a cabeça no current

		float sum = 0;
		int count = data.count();

		while (temp != null){
			sum += temp.getNota(); // soma as notas
			temp = temp.getNext(); // pula para o próximo nó
		}

		if (count == 0){ // caso a lista esteja vazia, evita a divisão por zero
			return 0;
		}

		return sum/count;
	}

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code map()}.</p>
	 * <p>A operação {@code mapToString()} deve mapear todos os nós da coleção de dados passada como parâmetro para uma única
	 * {@code String}, sendo que cada dado de uma pessoa é separado por ponto-e-vírgula (;) e cada pessoa é separada por uma
	 * quebra de linha.</p>
	 * 
	 * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
	 * @return {@code String} com a coleção de dados separada por ponto-e-vírgula (dados de cada pessoa) e quebras de linha (cada pessoa).
	 */
	public static String mapToString(final DLinkedList data) {

		StringBuilder sb = new StringBuilder();
		Node temp = data.getHead(); // armazena head em temp

		while (temp != null){
			sb.append(temp.getId()).append(";").append(temp.getNome()).append(";").append(temp.getNota()).append("\n");

			temp = temp.getNext(); // pula para o próximo nó
		}

		return sb.toString();
	}
}
