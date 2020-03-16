abstract class Item{
    public final boolean remover(int qtd){
        if (!validarQtd(qtd)){
            System.out.println("Impedir Remover");
            return false;
        }
        if (getEstoque() >= qtd){
            decEstoque(qtd);
            System.out.println("Itens Removidos");
            return true;
        }
        System.out.println("Impedir Remover");
        return false;
    }
    protected abstract boolean validarQtd(int qtd);
    protected abstract int getEstoque();
    protected abstract void decEstoque(int qtd);
}
class ItemGeral extends Item{
    private String nome;
    private int qtd;
    private int qtdMatriz;

    public ItemGeral(String nome, int qtd, int qtdMatriz) {
        this.nome = nome;
        this.qtd = qtd;
        this.qtdMatriz = qtdMatriz;
    }

    @Override
    public String toString() {
        return nome + ", Na Loja: " + qtd + " Na Matriz temos: " + qtdMatriz;
    }

    @Override
    protected boolean validarQtd(int qtd) {
        return qtd >= 0;
    }

    @Override
    protected int getEstoque() {
        return qtd + qtdMatriz;
    }

    @Override
    protected void decEstoque(int qtdDec) {
        if(qtdDec > this.qtd){
            qtdDec -= this.qtd;
            this.qtd = 0;
            qtdMatriz -= qtdDec;
        }else{
            this.qtd -= qtdDec;
        }
    }
}
class ItemRaro extends Item{
    private String nome;
    private int qtd;
    private int maxRetirada;

    public ItemRaro(String nome, int maxRetirada, int qtd) {
        this.nome = nome;
        this.qtd = qtd;
        this.maxRetirada = maxRetirada;
    }

    @Override
    public String toString() {
        return nome + ", Na Loja: " + qtd + " Max de Retirada : " + maxRetirada;
    }

    @Override
    protected boolean validarQtd(int qtd) {
        return qtd >= 0 && qtd <= Math.min(qtd, maxRetirada);
    }

    @Override
    protected int getEstoque() {
        return qtd ;
    }

    @Override
    protected void decEstoque(int qtdDec) {
            this.qtd -= qtdDec;
    }
}
public class Templ {
    public static void main(String[] args) {
        new Templ().negociar();
    }
    public void negociar(){
        System.out.println("Exemplo Item Geral");
        Item normal = new ItemGeral("Sal", 20, 10);
        System.out.println(normal);
        System.out.println("Obter 6 Unidades");
        normal.remover(6);
        System.out.println(normal);
        System.out.println("Obter 17 Unidades");
        normal.remover(17);
        System.out.println(normal);

        System.out.println("Exemplo Item Geral");
        Item raro = new ItemRaro("Plutonio", 5, 20);
        System.out.println(raro);
        System.out.println("Obter 6 Unidades");
        raro.remover(6);
        System.out.println(raro);
        System.out.println("Obter 3 Unidades");
        raro.remover(3);
        System.out.println(raro);



    }
}
