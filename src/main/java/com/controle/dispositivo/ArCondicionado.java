package com.controle.dispositivo;

public class ArCondicionado extends DispositivoBase {

    private int temperatura;
    private String modo;

    public ArCondicionado(String nome) {
        super(nome);
        this.temperatura = 22;
        this.modo = "REFRIGERAR";
    }

    public void aumentarTemperatura() {
        if (!ligado) {
            System.out.println("[" + nome + "] Dispositivo desligado.");
            return;
        }
        temperatura++;
        System.out.println("[" + nome + "] Temperatura: " + temperatura + "°C");
    }

    public void diminuirTemperatura() {
        if (!ligado) {
            System.out.println("[" + nome + "] Dispositivo desligado.");
            return;
        }
        temperatura--;
        System.out.println("[" + nome + "] Temperatura: " + temperatura + "°C");
    }

    public void setModo(String modo) {
        if (!ligado) {
            System.out.println("[" + nome + "] Dispositivo desligado.");
            return;
        }
        this.modo = modo.toUpperCase();
        System.out.println("[" + nome + "] Modo: " + this.modo);
    }

    @Override
    public void aumentarVolume() {
        System.out.println("[" + nome + "] Ar-condicionado não possui controle de volume.");
    }

    @Override
    public void diminuirVolume() {
        System.out.println("[" + nome + "] Ar-condicionado não possui controle de volume.");
    }

    public int getTemperatura() { return temperatura; }
    public String getModo() { return modo; }

    @Override
    public String toString() {
        return "ArCondicionado{nome='" + nome + "', ligado=" + ligado +
               ", temperatura=" + temperatura + "°C, modo=" + modo + "}";
    }
}
