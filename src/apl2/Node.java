// arquivo: src/apl2/Node.java

// TODO: Colocar a identificação dos(as) integrantes aqui.
//Arthur Roldan Slikta 							RA: 10353847
//Carlos Eduardo Diniz de Almeida 				RA: 10444407
//Guilherme Clauz Morlina da Silva 				RA: 10436477

package apl2;

// -- A classe Node (que pertence ao pacote apl2) deve conter os atributos que
// representam a nova versão dos dados de uma pessoa, conforme descrito no
// enunciado da atividade Apl2.
// -- A classe deve conter os construtores apropriados, assim como os métodos
// getters e setters.
// -- A classe também representa um nó que é usado na implementação da lista
// duplamente encadeada (classe DLinkedList).
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com os valores dos atributos da classe.

public class Node {

	private String id;
    private String nome;
    private Float nota;

    private Node previous;
    private Node next;

    public Node(){
        id = null;
        nome = "";
        nota = 99.9F;
        previous = null;
        next = null;
    }

    public Node(String id, String nome, Float nota, Node previous, Node next) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.previous = previous;
        this.next = next;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String idPrevious = null;
        String idNext = null;

        if (previous != null){
            idPrevious = previous.getId();
        }
        if (next != null){
            idNext = next.getId();
        }

        sb.append(idPrevious)
                .append(" <- (")
                .append(getId()).append(";").append(getNome()).append(";").append(nota)
                .append(") -> ").append(idNext);

        return sb.toString();
    }
}