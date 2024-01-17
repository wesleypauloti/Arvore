public class ListaEncadeada<T> {
    
    int tamanho;
    No<T> primeiro;

    public ListaEncadeada() {
        primeiro = null;
        tamanho = 0;
    }

    public void adicionar(T elemento) {
       No<T> novoNo = new No<T>(elemento);
        if (primeiro == null) {
            primeiro = novoNo;
        } else {
           No<T> atual = primeiro;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
        }
        System.out.println("Elemento " + elemento + " adcionado no fim lista");
        tamanho++;
    }
    
    public void adicionarNoMeio(T elemento, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            System.out.println("Índice inválido para inserção");
            return;
        }
       No<T> novoNo = new No<T>(elemento);
        if (posicao == 0) {
            novoNo.setProximo(primeiro);
            primeiro = novoNo;
        } else {
           No<T> atual = primeiro;
            int indice = 0;
            while (indice < posicao - 1) {
                atual = atual.getProximo();
                indice++;
            }
            novoNo.setProximo(atual.getProximo());
            atual.setProximo(novoNo);
        }
        System.out.println("Elemento " + elemento + " adcionado no meio lista");
        tamanho++;
    }

    public void buscarPorIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            System.out.println("\nNa busca por índice: Índice fora dos limites");
            return; // Valor inválido
        }
       No<T> atual = primeiro;
        int contador = 0;
        while (contador < indice) {
            atual = atual.getProximo();
            contador++;
        }
        System.out.println("\nNa busca por índice: Valor " + atual.getElemento() + " encontrado no índice " + indice);
        return;
    }

    public void buscarPorValor(T elemento) {
       No<T> atual = primeiro;
        int indice = 0;
        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                System.out.println("\nNa busca por valor no índice " + indice + " foi encontrado o valor " + atual.getElemento());
                return;
            }
            atual = atual.getProximo();
            indice++;
        }
        System.out.println("\nNa busca por valor: Valor " + elemento + " não foi encontrado na lista");
    }

    public void removerPorIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            System.out.println("\nNo remover por índice: Índice fora dos limites");
            return;
        }
        if (indice == 0) {
            System.out.println("\nNo remover por índice: Valor " + primeiro.getElemento() + " foi removido do índice " + indice);
            primeiro = primeiro.getProximo();
        } else {
           No<T> atual = primeiro;
            int contador = 0;
            while (contador < indice - 1) {
                atual = atual.getProximo();
                contador++;
            }
            System.out.println("\nNo remover por índice: Valor " + atual.getProximo().getElemento() + " foi removido do índice " + indice);
            atual.setProximo(atual.getProximo().getProximo());
        }
        tamanho--;
    }

    public void removerPorValor(T elemento) {
       No<T> atual = primeiro;
        int indice = 0;
    
        if (atual != null && atual.getElemento().equals(elemento)) {
            System.out.println("\nNo remover por valor: Do índice " + indice + " foi removido o valor " + elemento);
            primeiro = atual.getProximo();
            tamanho--;
            return;
        }
    
        while (atual != null && atual.getProximo() != null) {
            indice++;
            if (atual.getProximo().getElemento().equals(elemento)) {
                System.out.println("\nNo remover por valor: Do índice " + indice + " foi removido o valor " + elemento);
                atual.setProximo(atual.getProximo().getProximo());
                tamanho--;
                return;
            }
            atual = atual.getProximo();
        }
        System.out.println("\nNo remover por valor: Valor " + elemento + " não encontrado na lista");
        
    }    

    public void exibirLista() {
        System.out.print("\nLista Atual: ");
        No<T> atual = primeiro;
        while (atual != null) {
            System.out.print(atual.getElemento() + " -> ");
            atual = atual.getProximo();
        }
        System.out.println("null");
    }

    public int getTamanho() {
        return tamanho;
    }
}
