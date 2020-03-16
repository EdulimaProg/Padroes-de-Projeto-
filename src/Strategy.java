import org.omg.CORBA.PUBLIC_MEMBER;

interface ArrayFormato{
    public void mostar(int [] arr);
}
class FormatoPadrao implements ArrayFormato{

    @Override
    public void mostar(int[] arr) {
        System.out.println("{");
        for (int n = 0; n < arr.length-1; n++)
            System.out.print(arr[n] + ", ");
        System.out.print(arr[arr.length-1]+ "}");
    }
}
class FormatoPosicional implements ArrayFormato{

    @Override
    public void mostar(int[] arr) {
        for (int n = 0; n < arr.length-1; n++)
            System.out.println("Arr [" + n + "] = "+ arr[n]);
    }
}
class MeuArray{
    private int[] array;
    private int tam;
    ArrayFormato formata;

    public MeuArray(int tam) {
        array = new int[tam];
    }

    public void addValorEmPos(int valor, int pos){
        array[pos] = valor;
    }
    public void setEstrategia(ArrayFormato st){
        formata = st;
        formata.mostar(array);
    }
}
public class Strategy {
    public static void main(String[] args) {
        new Strategy().padronizar();
    }
    public void padronizar(){
        MeuArray m = new MeuArray(10);
        m.addValorEmPos(6 , 1);
        m.addValorEmPos(8 , 0);
        m.addValorEmPos(1 , 4);
        m.addValorEmPos(7 , 9);
        System.out.println("\n Formato Corrente \n");
        m.setEstrategia(new FormatoPadrao());
        System.out.println("\n Formato Posicional \n");
        m.setEstrategia(new FormatoPosicional());

    }
}
