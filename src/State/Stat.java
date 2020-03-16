package State;

class Acao {
    private String empresa;
    private float valor;
    private Variacao variacao = new Variacao();

    public Acao(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return  empresa + " - " + valor;
    }

    public void setValor(float valor) {
        if(variacao.isTroca(valor)){
            this.valor = valor;
        }else{
            System.out.println("Troca de Valor Indevida");
        }

    }
}
interface State{
    byte getNivel();
    boolean isValor(float valor);
}
class AcaoEmBaixa implements State{

    @Override
    public byte getNivel() {
        return (byte)1;
    }

    @Override
    public boolean isValor(float valor) {
        return valor < 4;
    }
}
class AcaoNaMedia implements State{

    @Override
    public byte getNivel() {
        return (byte)2;
    }

    @Override
    public boolean isValor(float valor) {
        return valor >= 4 && valor <= 20;
    }
}
class AcaoEmAlta implements State{

    @Override
    public byte getNivel() {
        return (byte)3;
    }

    @Override
    public boolean isValor(float valor) {
        return valor > 20;
    }
}
class Variacao {
    private State atual;

    public Variacao(){
        atual = new AcaoEmBaixa();
    }
    public boolean isTroca(float valor){
        if(atual.isValor(valor)){
            return true;
        }
        State novo = trocarAtual(valor);
        if(novo.getNivel() == atual.getNivel() + 1 ||
                novo.getNivel() == atual.getNivel() - 1){
            atual = novo;
            return true;
        }
        return false;
    }
    private State trocarAtual(float valor){
        if (new AcaoEmAlta().isValor(valor)){
            return new AcaoEmAlta();
        }
        else if (new AcaoEmBaixa().isValor(valor)){
            return new AcaoEmBaixa();
        }
        else if (new AcaoNaMedia().isValor(valor)){
            return new AcaoNaMedia();
        }

        return null;
    }
}

public class Stat {
    public static void main(String[] args) {
        new Stat().procederVariação();
    }
    public void procederVariação(){
        Acao padrao = new Acao("Lagado inc");
        padrao.setValor(3.0f);
        System.out.println(padrao);
        padrao.setValor(8.0f);
        System.out.println(padrao);
        padrao.setValor(25.0f);
        System.out.println(padrao);
        padrao.setValor(1.0f);
        System.out.println(padrao);
    }
}
