class SalaChat{
    public static void show(Usuario usuario, String mens){
        System.out.println(usuario+ " : " + mens);
    }
}
class Usuario{
    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return  nome;
    }


    public void enviarMens(String mens){
        SalaChat.show(this, mens);
    }
}
public class Med {
    public static void main(String[] args) {
        new Med().abrirSala();
    }
    public void abrirSala(){
        Usuario fernando = new Usuario("Fernando");
        Usuario anselmo = new Usuario("Anselmo");

        fernando.enviarMens("Olá");
        anselmo.enviarMens("eai");
    }
}
