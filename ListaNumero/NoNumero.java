public class NoNumero {
    
    int valor;
    NoNumero proximo;    

    public NoNumero(int i) {
        this.valor = i;
    }

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public NoNumero getProximo() {
        return proximo;
    }
    public void setProximo(NoNumero proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "" + valor;
    }

    
}
