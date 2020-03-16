import java.util.*;

abstract class Observer{
    protected Numero num;
    public abstract void notificar();

}
class Numero{
    private List<Observer> observadores = new ArrayList<Observer>();
    private int valor;

    public int hasCode(){
        return valor;
    }
    public void setValor(int valor){
        this.valor = valor;
        for (Observer obs: observadores){
            obs.notificar();
        }
    }
    public void add(Observer obs){
        observadores.add(obs);
    }
}
class HexObsever extends Observer{
    public HexObsever(Numero num) {
        this.num = num;
        this.num.add(this);
    }

    @Override
    public void notificar() {
        System.out.println(num.hasCode() + " Em Hexadecimal: " + Integer.toHexString(num.hasCode()));
    }
}
class OctalObsever extends Observer{
    public OctalObsever(Numero num) {
        this.num = num;
        this.num.add(this);
    }

    @Override
    public void notificar() {
        System.out.println(num.hasCode() + " Em Octal: " + Integer.toOctalString(num.hasCode()));
    }
}
public class Obse {
    public static void main(String[] args) {
        new Obse().converter();
    }
    public void converter(){
        Numero num = new Numero();
        new HexObsever(num);
        new OctalObsever(num);

        num.setValor(15);
        num.setValor(30);
        num.setValor(12);
    }
}
