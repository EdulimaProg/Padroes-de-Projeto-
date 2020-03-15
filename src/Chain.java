interface Rede{
    String tipoRede();
}
class Linux implements Rede{

    @Override
    public String tipoRede() {
        return "Rede Linux";
    }
}
class Microsoft implements Rede{

    @Override
    public String tipoRede() {
        return "Rede Microsoft";
    }
}
class WebServer{
    private WebServer next;
    private String nome;

    public WebServer(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "WebServer: " + nome;
    }
    public void add(WebServer nextWs){
        if (next != null){
            next.add(nextWs);
        }else{
            next = nextWs;
        }
    }
    public void wrapAround(WebServer firstWS){
        if (next != null){
            next.wrapAround(firstWS);
        }else {
            next = firstWS;
        }
    }
    public void handle(Rede rede){
        if((int)(Math.random()*4) % 2 == 0){
            System.out.println("WebServer Conectado " + rede.tipoRede() + " Em "+ next);
        }else{
            System.out.println("WebServer " + rede.tipoRede() + "  Ocupado ");
            next.handle(rede);
        }
    }
}


public class Chain {
    public static void main(String[] args) {
        new Chain().gerencia();
    }
    public void gerencia(){
        WebServer wp = new WebServer("WS Principal");
        WebServer primeiro = new WebServer("WS1");
        wp.add(primeiro);
        wp.add(new WebServer("WS2"));
        wp.add(primeiro);

        Rede [] redes = {
              new Linux(),
              new Linux(),
              new Microsoft()
        };

        for( Rede rede : redes){
            wp.handle(rede);
        }
    }
}
