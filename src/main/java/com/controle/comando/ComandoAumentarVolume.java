package com.controle.comando;

import com.controle.dispositivo.Dispositivo;

public class ComandoAumentarVolume implements Comando {

    private final Dispositivo dispositivo;

    public ComandoAumentarVolume(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public void executar() {
        dispositivo.aumentarVolume();
    }

    @Override
    public void desfazer() {
        dispositivo.diminuirVolume();
    }

    @Override
    public String getDescricao() {
        return "Aumentar volume de " + dispositivo.getNome();
    }
}
