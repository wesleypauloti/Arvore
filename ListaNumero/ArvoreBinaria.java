class No {
    int valor;
    No esquerda, direita;

    public No(int item) {
        valor = item;
        esquerda = direita = null;
    }
}

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    // Método público para iniciar a remoção
    public void remover(int valor) {
        raiz = removerNo(raiz, valor);
    }

    // Método privado recursivo para removerr um nó
    private No removerNo(No raiz, int valor) {
        // Caso base: a árvore está vazia ou o elemento não está presente
        if (raiz == null) {
            return raiz;
        }

        // Caso recursivo: desce na árvore
        if (valor < raiz.valor) {
            raiz.esquerda = removerNo(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = removerNo(raiz.direita, valor);
        } else {
            // Nodo com somente um filho ou nenhum filho
            if (raiz.esquerda == null) {
                return raiz.direita;
            } else if (raiz.direita == null) {
                return raiz.esquerda;
            }

            // Nodo com dois filhos: encontra o menor valor da subárvore direita
            raiz.valor = valorminimo(raiz.direita);

            // Remover o nó com o menor valor
            raiz.direita = removerNo(raiz.direita, raiz.valor);
        }

        return raiz;
    }

    // Método auxiliar para encontrar o menor valor em uma subárvore
    private int valorminimo(No raiz) {
        int valorminimo = raiz.valor;
        while (raiz.esquerda != null) {
            valorminimo = raiz.esquerda.valor;
            raiz = raiz.esquerda;
        }
        return valorminimo;
    }

    // Método para inserir um novo elemento na árvore
    public void adicionar(int valor) {
        raiz = adicionarNo(raiz, valor);
    }

    // Método privado recursivo para inserir um novo nó
    private No adicionarNo(No raiz, int valor) {
        if (raiz == null) {
            raiz = new No(valor);
            return raiz;
        }

        if (valor < raiz.valor) {
            raiz.esquerda = adicionarNo(raiz.esquerda, valor);
        } else if (valor > raiz.valor) {
            raiz.direita = adicionarNo(raiz.direita, valor);
        }

        return raiz;
    }

    // Método para percorrer a árvore em ordem
    public void emOrdem() {
        emOrdem(raiz);
    }

    // Método privado recursivo para percorrer a árvore em ordem
    private void emOrdem(No raiz) {
        if (raiz != null) {
            emOrdem(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            emOrdem(raiz.direita);
        }
    }

    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        // Inserir elementos na árvore
        arvore.adicionar(10);
        arvore.adicionar(8);
        arvore.adicionar(5);
        arvore.adicionar(9);
        arvore.adicionar(7);
        arvore.adicionar(18);
        arvore.adicionar(13);
        arvore.adicionar(20);

        System.out.println("Árvore original:");
        arvore.emOrdem();

        // Removerr elementos da árvore
        arvore.remover(20);
        arvore.remover(8);

        System.out.println("\nÁrvore após a remoção:");
        arvore.emOrdem();
    }
}
