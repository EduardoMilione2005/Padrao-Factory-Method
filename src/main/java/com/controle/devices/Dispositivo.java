package devices;

public interface Dispositivo {
    void ligar();
    void desligar();
    void aumentarVolume();
    void diminuirVolume();
    void aumentarBrilho();
    void diminuirBrilho();
    String getStatus();
    String getNome();
}
