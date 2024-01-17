public class PrincipalArvore {
    
    public static void main(String[] args) {
        
        Arvore<Integer> arvore = new Arvore<Integer>(null);

        arvore.adicionar(10);
        arvore.adicionar(8);
        arvore.adicionar(5);
        arvore.adicionar(9);
        arvore.adicionar(7);
        arvore.adicionar(18);
        arvore.adicionar(13);
        arvore.adicionar(20);

        System.out.println("em Ordem: ");
        arvore.emOrdem(arvore.getRaiz());
        
        System.out.println("Removeu: " + arvore.remover(8));

        System.out.println("em Ordem: ");
        arvore.emOrdem(arvore.getRaiz());

        // System.out.println("pré Ordem: ");
        // arvore.preOrdem(arvore.getRaiz());

        // System.out.println("pós Ordem: ");
        // arvore.posOrdem(arvore.getRaiz());
    }
}
