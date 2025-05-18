//*************************** ATENÇÃO! ****************************
// O método main() deve ser alterado somente nos comentários TODO.
// Todas as outras instruções devem permanecer intactas e o código
// deve funcionar conforme descrito no enunciado da atividade.
//*************************** ATENÇÃO! ****************************
// arquivo: src/MainApl2.java

// TODO: Colocar a identificação dos(as) integrantes aqui.
//Arthur Roldan Slikta 							RA: 10353847
//Carlos Eduardo Diniz de Almeida 				RA: 10444407
//Guilherme Clauz Morlina da Silva 				RA: 10436477

import apl2.*;

import java.io.IOException;
import java.util.Scanner;

public class MainApl2 {
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int option = 0;

		LinkedListOriginal list = new LinkedListOriginal();
        DLinkedList fixedList = null;
        DLinkedList filteredGradedList = null;
        float average = 0;
        String contents = "";

		String data = Data.loadTextFileToString("dados.txt");
		String[] conteudo = data.split("\n");

		for (int i = 0; i < conteudo.length; i++){
			String[] dados = conteudo[i].split("#");
			int id = Integer.parseInt(dados[0]);
			String nome = dados[1];
			int inteiro = Integer.parseInt(dados[2]);
			int decimal = Integer.parseInt(dados[3]);
			list.append(id, nome, inteiro, decimal);
		}

		while (option != 8) {
			System.out.println("");
            System.out.println("1. Dados originais.");
            System.out.println("2. Dados convertidos.");
            System.out.println("3. Lista notas filtradas válidas.");
            System.out.println("4. Lista notas filtradas inválidas.");
            System.out.println("5. Média de notas válidas.");
            System.out.println("6. Notas acima da média.");
            System.out.println("7. Lista mapeada para uma única string.");
            System.out.println("8. Finaliza sistema.");
            System.out.print("Informe a opção desejada: ");
            option = scanner.nextInt();

			switch (option) {
				case 1:
					System.out.println("\n>>> Dados originais <<<");
					System.out.println(list);
					break;
				case 2:
					System.out.println("\n>>> Dados convertidos <<<");
					fixedList = Operation.map(list);
					System.out.println(fixedList);
					contents = Operation.mapToString(fixedList);
                    try {
                        Data.saveStringToTextFile("dados.csv", contents);
                    } catch (IOException e) {
                        System.err.println("Erro ao salvar arquivo!");
                        e.printStackTrace();
                    }
                    break;
				case 3:
					System.out.println("\n>>> Lista notas filtradas válidas <<<");
					filteredGradedList = Operation.filterRemoveNonGraded(fixedList);
					System.out.println(filteredGradedList);
					break;
				case 4:
					System.out.println("\n>>> Lista notas filtradas inválidas <<<");
					DLinkedList filteredNonGradedList = Operation.filterRemoveGraded(fixedList);
					System.out.println(filteredNonGradedList);
					break;
				case 5:
					System.out.println("\n>>> Média de notas válidas <<<");
					average = Operation.reduce(filteredGradedList);
					System.out.println(average);
					break;
				case 6:
					System.out.println("\n>>> Notas acima da média <<<");
					DLinkedList aboveAverageList = Operation.filterRemoveBelowAverage(filteredGradedList, average);
					System.out.println(aboveAverageList);
					break;
				case 7:
					System.out.println("\n>>> Lista mapeada para uma única string <<<");
					System.out.println(contents);
					break;
				case 8:
					System.out.println("\n>>> Sistema finalizado <<<");
					break;
				default:
					System.out.println("Opção inválida.");
			}
		}

		scanner.close();

	// 	System.out.println(">>>>>>>>>> Dados originais (sistema legado) >>>>>>>>>>");
	// 	System.out.println(list);
	// 	System.out.println("<<<<<<<<<< Dados originais (sistema legado) <<<<<<<<<<\n");
		
	// 	DLinkedList fixedList = Operation.map(list);
	// 	System.out.println(">>>>>>>>>> Dados convertidos para a nova representação dos dados >>>>>>>>>>");
	// 	System.out.println(fixedList);
	// 	System.out.println("<<<<<<<<<< Dados convertidos para a nova representação dos dados <<<<<<<<<<\n");
		
	// 	DLinkedList filteredGradedList = Operation.filterRemoveNonGraded(fixedList);
	// 	System.out.println(">>>>>>>>>> Lista filtrada (somente notas válidas) >>>>>>>>>>");
	// 	System.out.println(filteredGradedList);
	// 	System.out.println("<<<<<<<<<< Lista filtrada (somente notas válidas) <<<<<<<<<<\n");
		
	// 	DLinkedList filteredNonGradedList = Operation.filterRemoveGraded(fixedList);
	// 	System.out.println(">>>>>>>>>> Lista filtrada (somente 'ausência de nota') >>>>>>>>>>");
	// 	System.out.println(filteredNonGradedList);
	// 	System.out.println("<<<<<<<<<< Lista filtrada (somente 'ausência de nota') <<<<<<<<<<\n");

	// 	float average = Operation.reduce(filteredGradedList);
	// 	System.out.println(">>>>>>>>>> Média das notas válidas >>>>>>>>>>");
	// 	System.out.println(average);
	// 	System.out.println("<<<<<<<<<< Média das notas válidas <<<<<<<<<<\n");
		
	// 	DLinkedList aboveAverageList = Operation.filterRemoveBelowAverage(filteredGradedList, average);
	// 	System.out.println(">>>>>>>>>> Lista com notas acima da média >>>>>>>>>>");
	// 	System.out.println(aboveAverageList);
	// 	System.out.println("<<<<<<<<<< Lista com notas acima da média <<<<<<<<<<\n");
		
	// 	String contents = Operation.mapToString(fixedList);
	// 	System.out.println(">>>>>>>>>> Lista mapeada para uma única string >>>>>>>>>>");
	// 	System.out.println(contents);
	// 	System.out.println("<<<<<<<<<< Lista mapeada para uma única string <<<<<<<<<<\n");
		
	// 	try {
	// 		Data.saveStringToTextFile("dados.csv", contents);
	// 	} catch (IOException e) {
 	// 		System.err.println("Erro ao gravar arquivo!");
 	// 		e.printStackTrace();
	// 	}
		
	// 	Node test1 = fixedList.getNode("23.S1-999");
	// 	System.out.println(">>>>>>>>>> test1 >>>>>>>>>>\n" + test1 + "\n<<<<<<<<<< test1 <<<<<<<<<<\n");

	// 	Node test2 = fixedList.removeNode("23.S1-999");
	// 	System.out.println(">>>>>>>>>> test2 >>>>>>>>>>\n" + test2 + "\n<<<<<<<<<< test2 <<<<<<<<<<\n");

	// 	Node test3 = fixedList.getNode("23.S1-999");
	// 	System.out.println(">>>>>>>>>> test3 >>>>>>>>>>\n" + test3 + "\n<<<<<<<<<< test3 <<<<<<<<<<\n");

	// 	aboveAverageList.clear();
	// 	System.out.println(">>>>>>>>>> aboveAverageList.clear() >>>>>>>>>>\n" + aboveAverageList + "\n<<<<<<<<<< aboveAverageList.clear() <<<<<<<<<<\n");

	// 	DLinkedList testList = new DLinkedList();
		
	// 	testList.insert("ABC", "John Doe", 4.7f);
		
	// 	testList.append("XYZ", "Jane Doe", 9.9f);
		
	// 	testList.insert("321", "Test", 2.3f);
		
	// 	testList.append("Nothing", "Yada yada yada", 99.9f);

	// 	System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
	// 	System.out.println("testList.getHead(): " + testList.getHead());
	// 	System.out.println("testList.getTail(): " + testList.getTail());
	// 	System.out.println("testList.removeHead(): " + testList.removeHead());
	// 	System.out.println("testList.removeTail(): " + testList.removeTail() + '\n');
	// 	System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
	// 	System.out.println("testList.getHead(): " + testList.getHead());
	// 	System.out.println("testList.getTail(): " + testList.getTail());
	// 	System.out.println("testList.removeNode(\"ABC\"): " + testList.removeNode("ABC") + '\n');
	// 	System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
	// 	System.out.println("testList.getHead(): " + testList.getHead());
	// 	System.out.println("testList.getTail(): " + testList.getTail() + '\n');
		
	// 	testList.insert("qwerty", "QWERTY", 1.2f);
		
	// 	testList.append("WASD", "wasd", 3.4f);
		
	// 	testList.insert("ijkl", "IJKL", 5.6f);
		
	// 	testList.append("1234", "Um Dois Tres Quatro", 7.8f);

	// 	System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
	// 	testList.clear();
	// 	System.out.println(">>>>>>>>>> testList.clear() >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList.clear() <<<<<<<<<<\n");
	// }
	}
}