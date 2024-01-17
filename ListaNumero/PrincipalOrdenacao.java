class PrincipalOrdenacao {
    public static void main(String[] args) {
        
        ListaNumero lista = new ListaNumero();

        // for (int i = 0; i < 20000; i++) {
            
        //     lista.adicionar((int)(Math.random() * 100));
        // }

        lista.adicionar(8);
        lista.adicionar(2);
        lista.adicionar(1);
        lista.adicionar(6);
        lista.adicionar(4);
        lista.adicionar(3);

        long inicio, fim;
        
        lista.exibirLista();

        inicio = System.currentTimeMillis();
        
        lista.bubleSort();
        // lista.meuInsertionSort();

        fim = System.currentTimeMillis();

        lista.exibirLista();

        // System.out.println("Tempo: " + (fim - inicio) + "ms");
        // System.out.println("Trocas: " + lista.trocas);
        
        System.out.println("\n\n");
    }
}