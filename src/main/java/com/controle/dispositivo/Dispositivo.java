package com.controle.dispositivo;

public interface Dispositivo {
    void ligar();
    void desligar();
    void aumentarVolume();
    void diminuirVolume();
    String getNome();
    boolean isLigado();
    int getVolume();
}
