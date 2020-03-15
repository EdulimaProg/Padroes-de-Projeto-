import java.util.Scanner;

class TV{
    private boolean ligada = false;
    private byte volume = 0;

    public void ligarDesligar(){
        if (ligada = !ligada){
            System.out.println("Tv Ligada");
        }else {
            System.out.println("Tv Desligada");
        }
    }
    public void aumentaVolume(){
        if (ligada) {
            if (volume < 10) volume++;
            System.out.println("Volume da TV: " + volume);
        }else {
            System.out.println("Ligue a TV");
        }
    }
    public void abaixaVolume(){
        if (ligada) {
            if (volume >= 10) volume--;
            System.out.println("Volume da TV: " + volume);
        }else {
            System.out.println("Ligue a TV");
        }
    }
}
interface Command{
    void executar();
}
class TVLigaDesligaCommand implements Command{
    private TV tv;

    public TVLigaDesligaCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void executar() {
        tv.ligarDesligar();
    }
}
class TVAumVolumeCommand implements Command{
    private TV tv;

    public TVAumVolumeCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void executar() {
        tv.aumentaVolume();
    }
}
class TVAbxVolumeCommand implements Command{
    private TV tv;

    public TVAbxVolumeCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void executar() {
        tv.abaixaVolume();
    }
}
class ControleRemoto{
    private Command btLigDes, btAumVol, btAbxVol;

    public ControleRemoto(TV tv){
        btLigDes = new TVLigaDesligaCommand(tv);
        btAumVol = new TVAumVolumeCommand(tv);
        btAbxVol = new TVAbxVolumeCommand(tv);
    }
    public void pressLigaDes(){
        btLigDes.executar();
    }
    public void pressAumVol(){
        btAumVol.executar();
    }
    public void pressAbxVol(){
        btAbxVol.executar();
    }
}
public class Com {
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new Com().assistir();
    }
    public void assistir(){
        byte opcao = 0;
        ControleRemoto remoto = new ControleRemoto(new TV());
        do{
            System.out.println("Selecione o commando (0 para sair)");
            System.out.println("1 - Ligar/Desligar");
            System.out.println("2 - Aumentar Volume");
            System.out.println("3 - Abaixar Volume");
            opcao = sc.nextByte();
            switch (opcao){
                case 1: remoto.pressLigaDes(); break;
                case 2: remoto.pressAumVol(); break;
                case 3: remoto.pressAbxVol(); break;
            }
        }while (opcao != 0);
    }
}
