package com.controle.dispositivo;

public class Televisao extends DispositivoBase {

    private int canal;

    public Televisao(String nome) {
        super(nome);
        this.canal = 1;
    }

    public void mudarCanal(int canal) {
        if (!ligado) {
            System.out.println("[" + nome + "] Não é possível mudar canal: TV desligada.");
            return;
        }
        if (canal < 1) {
            System.out.println("[" + nome + "] Canal inválido.");
            return;
        }
        this.canal = canal;
        System.out.println("[" + nome + "] Canal: " + canal);
    }

    public void proximoCanal() {
        mudarCanal(canal + 1);
    }

    public void canalAnterior() {
        if (canal > 1) mudarCanal(canal - 1);
    }

    public int getCanal() { return canal; }

    @Override
    public String toString() {
        return "Televisao{nome='" + nome + "', ligado=" + ligado +
               ", volume=" + volume + ", canal=" + canal + "}";
    }
}
