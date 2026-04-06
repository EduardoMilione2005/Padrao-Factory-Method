package com.controle.dispositivo;

public abstract class DispositivoBase implements Dispositivo {

    protected String nome;
    protected boolean ligado;
    protected int volume;
    protected static final int VOLUME_MIN = 0;
    protected static final int VOLUME_MAX = 100;

    public DispositivoBase(String nome) {
        this.nome = nome;
        this.ligado = false;
        this.volume = 10;
    }

    @Override
    public void ligar() {
        if (!ligado) {
            ligado = true;
            System.out.println("[" + nome + "] Ligado.");
        } else {
            System.out.println("[" + nome + "] Já está ligado.");
        }
    }

    @Override
    public void desligar() {
        if (ligado) {
            ligado = false;
            System.out.println("[" + nome + "] Desligado.");
        } else {
            System.out.println("[" + nome + "] Já está desligado.");
        }
    }

    @Override
    public void aumentarVolume() {
        if (!ligado) {
            System.out.println("[" + nome + "] Não é possível ajustar volume: dispositivo desligado.");
            return;
        }
        if (volume < VOLUME_MAX) {
            volume++;
            System.out.println("[" + nome + "] Volume: " + volume);
        } else {
            System.out.println("[" + nome + "] Volume já está no máximo (" + VOLUME_MAX + ").");
        }
    }

    @Override
    public void diminuirVolume() {
        if (!ligado) {
            System.out.println("[" + nome + "] Não é possível ajustar volume: dispositivo desligado.");
            return;
        }
        if (volume > VOLUME_MIN) {
            volume--;
            System.out.println("[" + nome + "] Volume: " + volume);
        } else {
            System.out.println("[" + nome + "] Volume já está no mínimo (" + VOLUME_MIN + ").");
        }
    }

    @Override
    public String getNome() { return nome; }

    @Override
    public boolean isLigado() { return ligado; }

    @Override
    public int getVolume() { return volume; }
}
