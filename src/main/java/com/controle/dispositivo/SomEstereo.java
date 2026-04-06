package com.controle.dispositivo;

public class SomEstereo extends DispositivoBase {

    private String modoEqualizer;
    private String fonte;

    public SomEstereo(String nome) {
        super(nome);
        this.modoEqualizer = "NORMAL";
        this.fonte = "BLUETOOTH";
    }

    public void setEqualizer(String modo) {
        if (!ligado) {
            System.out.println("[" + nome + "] Não é possível ajustar equalizer: som desligado.");
            return;
        }
        this.modoEqualizer = modo.toUpperCase();
        System.out.println("[" + nome + "] Equalizer: " + modoEqualizer);
    }

    public void setFonte(String fonte) {
        if (!ligado) {
            System.out.println("[" + nome + "] Não é possível trocar fonte: som desligado.");
            return;
        }
        this.fonte = fonte.toUpperCase();
        System.out.println("[" + nome + "] Fonte: " + this.fonte);
    }

    public String getModoEqualizer() { return modoEqualizer; }
    public String getFonte() { return fonte; }

    @Override
    public String toString() {
        return "SomEstereo{nome='" + nome + "', ligado=" + ligado +
               ", volume=" + volume + ", equalizer=" + modoEqualizer +
               ", fonte=" + fonte + "}";
    }
}
