import devices.Projetor;
import devices.SomEstereo;
import devices.Televisao;
import factory.ControleProjetor;
import factory.ControleSom;
import factory.ControleTV;

public class Main {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║  SISTEMA DE CONTROLE DE DISPOSITIVOS     ║");
        System.out.println("║  Padrão: Factory Method                  ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        System.out.println("─── Televisão ───────────────────────────────");
        ControleTV controleTV = new ControleTV();
        Televisao tv = (Televisao) controleTV.iniciarDispositivo("Samsung QLED");

        controleTV.ligar(tv);
        controleTV.aumentarVolume(tv);
        controleTV.proximoCanal(tv);
        controleTV.proximoCanal(tv);
        controleTV.aumentarBrilho(tv);
        controleTV.exibirStatus(tv);
        controleTV.desligar(tv);

        System.out.println();

        System.out.println("─── Som Estéreo ─────────────────────────────");
        ControleSom controleSom = new ControleSom();
        SomEstereo som = (SomEstereo) controleSom.iniciarDispositivo("Sony HiFi");

        controleSom.ligar(som);
        controleSom.aumentarVolume(som);
        controleSom.aumentarVolume(som);
        controleSom.trocarModo(som);
        controleSom.trocarModo(som);
        controleSom.exibirStatus(som);
        controleSom.desligar(som);

        System.out.println();

        System.out.println("─── Projetor ────────────────────────────────");
        ControleProjetor controleProjetor = new ControleProjetor();
        Projetor projetor = (Projetor) controleProjetor.iniciarDispositivo("Epson 4K");

        controleProjetor.ligar(projetor);
        controleProjetor.diminuirBrilho(projetor);
        controleProjetor.trocarResolucao(projetor);
        controleProjetor.exibirStatus(projetor);
        controleProjetor.desligar(projetor);

        System.out.println("\n[Fim da demonstração]");
    }
}
