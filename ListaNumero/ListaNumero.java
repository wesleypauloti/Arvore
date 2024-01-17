public class ListaNumero {

    int tamanho;
    NoNumero primeiro;
    NoNumero ultimo;
    int trocas = 0;

    public ListaNumero() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }

    public void adicionar(int valor) {
        NoNumero novoNo = new NoNumero(valor);
        if (primeiro == null) {
            primeiro = novoNo;
        } else {
            NoNumero atual = primeiro;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novoNo;
        }
        tamanho++;
    }

    public void adicionarNoMeio(int valor, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            System.out.println("Índice inválido para inserção");
            return;
        }
        NoNumero novoNo = new NoNumero(valor);
        if (posicao == 0) {
            novoNo.proximo = primeiro;
            primeiro = novoNo;
        } else {
            NoNumero atual = primeiro;
            int indice = 0;
            while (indice < posicao - 1) {
                atual = atual.proximo;
                indice++;
            }
            novoNo.proximo = atual.proximo;
            atual.proximo = novoNo;
        }
        tamanho++;
    }

    public void buscarPorIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            System.out.println("\nNa busca por índice: Índice fora dos limites");
            return; // Valor inválido
        }
        NoNumero atual = primeiro;
        int contador = 0;
        while (contador < indice) {
            atual = atual.proximo;
            contador++;
        }
        System.out.println("\nNa busca por índice: Valor " + atual.valor + " encontradoNoNumero índice " + indice);
        return;
    }

    public void buscarPorValor(int valor) {
        NoNumero atual = primeiro;
        int indice = 0;
        while (atual != null) {
            if (atual.valor == valor) {
                System.out.println(
                        "\nNa busca por valor:NoNumero índice " + indice + " foi encontrado o valor " + atual.valor);
                return;
            }
            atual = atual.proximo;
            indice++;
        }
        System.out.println("\nNa busca por valor: Valor " + valor + " não foi encontrado na lista");
    }

    public void removerPorIndice(int indice) {
        if (indice < 0 || indice >= tamanho) {
            System.out.println("\nNo remover por índice: Índice fora dos limites");
            return;
        }
        if (indice == 0) {
            System.out
                    .println("\nNo remover por índice: Valor " + primeiro.valor + " foi removido do índice " + indice);
            primeiro = primeiro.proximo;
        } else {
            NoNumero atual = primeiro;
            int contador = 0;
            while (contador < indice - 1) {
                atual = atual.proximo;
                contador++;
            }
            System.out.println(
                    "\nNo remover por índice: Valor " + atual.proximo.valor + " foi removido do índice " + indice);
            atual.proximo = atual.proximo.proximo;
        }
        tamanho--;
    }

    public void removerPorValor(int valor) {
        NoNumero atual = primeiro;
        int indice = 0;

        if (atual != null && atual.valor == valor) {
            System.out.println("\nNo remover por valor: Do índice " + indice + " foi removido o valor " + valor);
            primeiro = atual.proximo;
            tamanho--;
            return;
        }

        while (atual != null && atual.proximo != null) {
            indice++;
            if (atual.proximo.valor == valor) {
                System.out.println("\nNo remover por valor: Do índice " + indice + " foi removido o valor " + valor);
                atual.proximo = atual.proximo.proximo;
                tamanho--;
                return;
            }
            atual = atual.proximo;
        }
        System.out.println("\nNo remover por valor: Valor " + valor + " não encontrado na lista");

    }

    public void exibirLista() {
        System.out.print("\nLista Atual: [");
        NoNumero atual = primeiro;
        while (atual != null) {
            System.out.print(atual.valor);
            if (atual.getProximo() != null) {
                System.out.print(", ");
            }
            atual = atual.proximo;
        }
        System.out.println("]");
    }

    public int getTamanho() {
        return tamanho;
    }

    public void insertionSort2() {
        if (primeiro == null || primeiro.proximo == null) {
            return;
        }
        NoNumero atual = primeiro;

        while (atual != null) {
            System.out.println("Atual: " + atual);
            System.out.println("Atual Proximo: " + atual.getProximo());
            NoNumero buscador = atual.getProximo();
            NoNumero aux = null;
            NoNumero menor = atual;
            NoNumero proximo = atual.proximo;

            while (buscador != null) {
                if (buscador.getValor() < menor.getValor()) {
                    menor = buscador;
                }
                buscador = buscador.getProximo();
            }
            aux = menor;
            aux.setProximo(atual.getProximo());
            System.out.println("aux: " + aux);
            System.out.println("aux Proximo: " + aux.getProximo());
            atual = atual.getProximo();
        }
    }

    public void insertionSort() {
        if (primeiro == null || primeiro.proximo == null) {
            return;
        }

        NoNumero menorValor = null;
        System.out.println("menorValor: " + menorValor);
        NoNumero atual = primeiro; // atual = i
        System.out.println("atual: " + atual);

        while (atual != null) {
            NoNumero proximo = atual.proximo; // proximo = i++
            if (menorValor == null || atual.getValor() <= menorValor.getValor()) {
                atual.proximo = menorValor;
                System.out.println("atual.proximo: " + atual.proximo);
                menorValor = atual;
                System.out.println("menorValor: " + menorValor);
                // Neste if é verificado se o valor atual é menor do primeiro da lista nova
            } else {
                NoNumero busca = menorValor;
                System.out.println("busca: " + busca);
                while (busca.proximo != null && atual.getValor() > busca.proximo.getValor()) {
                    busca = busca.proximo;
                    System.out.println("\n1-busca.proximo: " + busca.proximo);
                    // Aqui o busca organiza a ordem crescente
                }
                atual.proximo = busca.proximo; // [5, 12, 2, 8, 4, 9]
                System.out.println("atual.proximo: " + atual.proximo);
                System.out.println("\n2-busca.proximo: " + busca.proximo);
                busca.proximo = atual;
                System.out.println("3-busca.proximo: " + busca.proximo);
                System.out.println("atual.proximo: " + atual.proximo);
            }

            atual = proximo;
        }

        primeiro = menorValor;
        menorValor = null;
    }

    public void testeAdicionar(int valor) {
        NoNumero novoValor = new NoNumero(valor);
        int cont = 1;
        if (primeiro == null) {
            primeiro = novoValor;
            System.out.println("Valor " + valor + " adicionado no indice 0");
            return;
        }
        NoNumero atual = primeiro;
        while (atual != null) {
            if (atual.proximo == null) {
                atual.proximo = novoValor;
                System.out.println("Valor " + valor + " adicionado no indice " + cont);
                return;
            }
            atual = atual.proximo;
            cont++;
        }
    }

    public void testeAdicionar(int indice, int valor) {
        if (indice < 0) {
            System.out.println("Indice inválido");
            return;
        }
        NoNumero novoValor = new NoNumero(valor);
        NoNumero atual = primeiro;
        NoNumero anterior = null;
        int cont = 0;
        if (indice == 0) {
            anterior = novoValor;
            novoValor.proximo = atual;
            primeiro = novoValor;
            System.out.println("Valor " + valor + " adicionado no indice " + cont);
            return;
        }
        anterior = atual;
        atual = atual.proximo;
        cont++;

        while (anterior != null) {
            if (cont == indice) {
                anterior.proximo = novoValor;
                novoValor.proximo = atual;
                System.out.println("Valor " + valor + " adicionado no indice " + cont);
                return;
            }
            anterior = atual;
            atual = atual.proximo;
            cont++;
        }
        System.out.println("Indice " + indice + " maior do que a lista[" + cont + "]");
    }

    public void testeAlterar(int indice, int valor) {
        if (indice < 0) {
            System.out.println("Indice inválido");
            return;
        }
        NoNumero novoValor = new NoNumero(valor);
        NoNumero atual = primeiro;
        NoNumero anterior = null;
        int cont = 0;
        if (indice == 0) {
            anterior = novoValor;
            novoValor.proximo = atual;
            primeiro = novoValor;
            System.out.println("Valor " + valor + " adicionado no indice " + cont);
            return;
        }
        anterior = atual;
        atual = atual.proximo;
        cont++;

        while (anterior != null) {
            if (cont == indice) {
                anterior.proximo = novoValor;
                novoValor.proximo = atual;
                System.out.println("Valor " + valor + " adicionado no indice " + cont);
                return;
            }
            anterior = atual;
            atual = atual.proximo;
            cont++;
        }
        System.out.println("Indice " + indice + " maior do que a lista[" + cont + "]");
    }

    public void testeExcluir(int valor) {
        NoNumero atual = primeiro;
        NoNumero procurado = atual.proximo;
        int cont = 1;

        while (true) {
            if (atual.valor == valor) {
                primeiro = atual.proximo;
                System.out.println("\nValor " + valor + " excluido no indice " + 0);
                break;
            } else if (procurado.valor == valor) {
                atual.proximo = procurado.proximo;
                System.out.println("\nValor " + valor + " excluido no indice " + cont);
                break;
            } else if (procurado.proximo == null) {
                System.out.println("\nValor " + valor + " não encotrado");
                break;
            }
            cont++;
            procurado = procurado.proximo;
            atual = atual.proximo;
        }
    }

    public void bubleSort() {
        boolean troca;
        int contador = 0;

        do {
            NoNumero atual = primeiro;
            NoNumero proximo = atual.proximo;
            NoNumero anterior = null;
            troca = false;
            int cont = contador;
            while (cont < tamanho - 1) {
                if (atual.valor > proximo.valor) {
                    trocas++;
                    if (anterior != null) {
                        anterior.proximo = proximo;
                    } else {
                        primeiro = proximo;
                    }
                    atual.proximo = proximo.proximo;
                    proximo.proximo = atual;
                    // Primeira iteração no if {8, 2, 1, 6, 4, 3}, {2, 8, 1, 6, 4, 3}
                    // {2, 1, 8, 6, 4, 3}, {2, 1, 6, 8, 4, 3}, {2, 1, 6, 4, 8, 3}, {2, 1, 6, 4, 3,
                    // 8}
                    anterior = proximo;
                    proximo = atual.proximo;
                    troca = true; // {8, 2, 1, 6, 4, 3} Lista desordenada
                                  // {2, 1, 6, 4, 3, 8} 1º que entra no while
                                  // {1, 2, 4, 3, 6, 8} 2º
                                  // {1, 2, 3, 4, 6, 8} 3º
                                  // {1, 2, 3, 4, 6, 8} ultima
                } else {
                    anterior = atual;
                    atual = proximo;
                    proximo = atual.proximo;
                }
                cont++;
            }
            contador++;
        } while (troca);
    }

    public void meuInsertionSort() {
        NoNumero listaOrdenada = null;
        NoNumero atual = primeiro;
        int cont = 1;

        while (atual != null) {
            NoNumero proximo = atual.proximo;

            if (listaOrdenada == null || listaOrdenada.valor >= atual.valor) {
                atual.proximo = listaOrdenada;
                listaOrdenada = atual;
                trocas++;

            } else { // [8, 2, 1, 6, 4, 3]
                NoNumero aux = listaOrdenada;

                while (aux.proximo != null && aux.proximo.valor < atual.valor) {
                    aux = aux.proximo;
                }
                atual.proximo = aux.proximo;
                aux.proximo = atual;
                trocas++;
            }
            atual = proximo;
            cont++;
        }
        primeiro = listaOrdenada;
        listaOrdenada = null;
    }
}
