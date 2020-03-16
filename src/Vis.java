interface ParteVisistor{
    public void visit(Cpu cpu);
    public void visit(Periferico periferico);
}
class ShowVisitor implements ParteVisistor{

    @Override
    public void visit(Cpu cpu) {
        System.out.println("Computador.....");
    }

    @Override
    public void visit(Periferico periferico) {
        System.out.println("Computador " + periferico);
    }
}
interface ParteComp{
    public void adicionar(ParteVisistor parteVisistor);
}
class Periferico implements ParteComp{
    private String nome;
    public Periferico(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public void adicionar(ParteVisistor parteVisistor) {
        parteVisistor.visit(this);
    }
}
class Cpu implements ParteComp{
    private ParteComp[] partes;

    public Cpu(){
        partes = new ParteComp[] {
                new Periferico("Mouse"),
                new Periferico("Teclado"),
                new Periferico("Monitor")
        };
    }

    @Override
    public void adicionar(ParteVisistor parteVisistor) {
        parteVisistor.visit(this);
        for (int i = 0; i < partes.length; i++){
            partes[i].adicionar(parteVisistor);
        }
    }
}
public class Vis {
    public static void main(String[] args) {
        ParteComp comp = new Cpu();
        comp.adicionar(new ShowVisitor());
    }
}
