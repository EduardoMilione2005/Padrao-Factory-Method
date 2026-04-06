package com.controle.comando;

import com.controle.dispositivo.Dispositivo;

public class ComandoDiminuirVolume implements Comando {

    private final Dispositivo dispositivo;

    public ComandoDiminuirVolume(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public void executar() {
        dispositivo.diminuirVolume();
    }

    @Override
    public void desfazer() {
        dispositivo.aumentarVolume();
    }

    @Override
    public String getDescricao() {
        return "Diminuir volume de " + dispositivo.getNome();
    }
}
