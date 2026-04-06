package com.controle.comando;

import com.controle.dispositivo.Dispositivo;

public class ComandoLigar implements Comando {

    private final Dispositivo dispositivo;

    public ComandoLigar(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public void executar() {
        dispositivo.ligar();
    }

    @Override
    public void desfazer() {
        dispositivo.desligar();
    }

    @Override
    public String getDescricao() {
        return "Ligar " + dispositivo.getNome();
    }
}
