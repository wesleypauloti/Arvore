class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void testeAdicionar(int valor) {
        Node novoValor = new Node(valor);
        int cont = 1;
        if(head == null) {
            head = novoValor;
            System.out.println("Valor " + valor + " adicionado no indice 0");
            return;
        }
        Node atual = head;
        while (atual != null) {
            if(atual.next == null) {
                atual.next = novoValor;
                System.out.println("Valor " + valor + " adicionado no indice " + cont);
                return;
            }
            atual = atual.next;
            cont++;
        }
    }

    // Método para percorrer a lista do fim para o início
    void printReverse() {
        Node atual = head;
        Node anterior = null;
        Node next;

        while (atual != null) {
            next = atual.next;
            atual.next = anterior;
            anterior = atual;
            atual = next;
        }

        // Agora, anterior aponta para o último nó, que é o novo cabeçalho
        head = anterior;

        // Imprime os elementos da lista revertida
        atual = anterior;
        while (atual != null) {
            System.out.print(atual.data + " ");
            atual = atual.next;
        }
        System.out.println();
    }

    // Método para adicionar um nó no início da lista
    void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList lista = new LinkedList();        

        // Adiciona alguns elementos à lista
        lista.testeAdicionar(1);
        lista.testeAdicionar(2);
        lista.testeAdicionar(3);
        lista.testeAdicionar(4);
        lista.testeAdicionar(5);

        System.out.println("Lista original:");
        lista.printReverse();
    }
}
