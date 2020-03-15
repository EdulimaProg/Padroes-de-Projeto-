import java.util.*;

class AcaoMemento{
    private float valor;

    public AcaoMemento(float valor) {
        this.valor = valor;
    }

    public float getState() {
        return valor;
    }

}

class Acao{
    private String empresa;
    private float valor;
    private List<AcaoMemento> memoria = new ArrayList<AcaoMemento>();

    public Acao(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return empresa + "  - " + valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
        memoria.add(new AcaoMemento(valor));
    }
    public void undo(){
        if (memoria.size() > 1){
            memoria.remove(memoria.size() - 1);
            this.valor = memoria.get(memoria.size() - 1).getState();
        }
    }
}

public class Meme {
    public static void main(String[] args) {
        new Meme().bolsa();
    }
    public void bolsa(){
        Acao padrao = new Acao("Edu inc");
        padrao.setValor(3.0f);
        System.out.println(padrao);
        padrao.setValor(8.0f);
        System.out.println(padrao);
        padrao.setValor(25.0f);
        System.out.println(padrao);
        padrao.undo();
        System.out.println(padrao);
        padrao.undo();
        System.out.println(padrao);

    }
}
