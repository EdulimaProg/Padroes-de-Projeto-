interface Expressao{
    public boolean entender(String contexto);
}
class ExpressaoFinal implements Expressao{
    private String dado;

    public ExpressaoFinal(String dado) {
        this.dado = dado;
    }

    @Override
    public boolean entender(String contexto) {
        return contexto.contains(dado);
    }
}
class ExpressaoE implements Expressao{
    private Expressao expr1 = null;
    private Expressao expr2 = null;

    public ExpressaoE(Expressao expr1, Expressao expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean entender(String contexto) {
        return expr1.entender(contexto) && expr2.entender(contexto);
    }
}
class ExpressaoOu implements Expressao{
    private Expressao expr1 = null;
    private Expressao expr2 = null;

    public ExpressaoOu(Expressao expr1, Expressao expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean entender(String contexto) {
        return expr1.entender(contexto) || expr2.entender(contexto);
    }
}


public class Inter {
    public Expressao carregarAutores(String autor1, String autor2){
        return new ExpressaoOu(
                new ExpressaoFinal(autor1),
                new ExpressaoFinal(autor2)
        );
    }
    public Expressao carregarLinguagem(String pessoa){
        return new ExpressaoE(
                new ExpressaoFinal(pessoa),
                new ExpressaoFinal("Java")
        );
    }
    public static void main(String[] args) {
        new Inter().verificar();
    }
    public void verificar(){
        Expressao autores = carregarAutores("Fernando", "Anselmo");
        Expressao conhecimento = carregarLinguagem("Fernando");

        System.out.println("Fernando foi Autor deste Curso " + autores.entender("Fernando Autor"));

        System.out.println("Fernando sabe Java " +conhecimento.entender("Fernando Java") );
    }
}
