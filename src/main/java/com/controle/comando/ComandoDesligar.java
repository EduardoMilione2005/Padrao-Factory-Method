package com.controle.comando;

import com.controle.dispositivo.Dispositivo;

public class ComandoDesligar implements Comando {

    private final Dispositivo dispositivo;

    public ComandoDesligar(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public void executar() {
        dispositivo.desligar();
    }

    @Override
    public void desfazer() {
        dispositivo.ligar();
    }

    @Override
    public String getDescricao() {
        return "Desligar " + dispositivo.getNome();
    }
}
