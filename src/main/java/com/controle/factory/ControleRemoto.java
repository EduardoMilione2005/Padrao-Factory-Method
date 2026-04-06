package factory;

import devices.Dispositivo;

public abstract class ControleRemoto {

    protected abstract Dispositivo criarDispositivo(String nome);

    public Dispositivo iniciarDispositivo(String nome) {
        Dispositivo d = criarDispositivo(nome);
        System.out.println("=== Controle configurado para: " + d.getNome() + " ===");
        return d;
    }

    public void ligar(Dispositivo d)           { d.ligar(); }
    public void desligar(Dispositivo d)        { d.desligar(); }
    public void aumentarVolume(Dispositivo d)  { d.aumentarVolume(); }
    public void diminuirVolume(Dispositivo d)  { d.diminuirVolume(); }
    public void aumentarBrilho(Dispositivo d)  { d.aumentarBrilho(); }
    public void diminuirBrilho(Dispositivo d)  { d.diminuirBrilho(); }
    public void exibirStatus(Dispositivo d)    { System.out.println(d.getStatus()); }
}
