package com.controle.factory;

import com.controle.dispositivo.Dispositivo;
import com.controle.dispositivo.Televisao;
import com.controle.comando.*;

public class TelevisaoFactory implements ControleRemotoFactory {

    private final String nomeTV;

    public TelevisaoFactory(String nomeTV) {
        this.nomeTV = nomeTV;
    }

    @Override
    public Dispositivo criarDispositivo() {
        return new Televisao(nomeTV);
    }

    @Override
    public Comando criarComandoLigar(Dispositivo dispositivo) {
        return new ComandoLigar(dispositivo);
    }

    @Override
    public Comando criarComandoDesligar(Dispositivo dispositivo) {
        return new ComandoDesligar(dispositivo);
    }

    @Override
    public Comando criarComandoAumentarVolume(Dispositivo dispositivo) {
        return new ComandoAumentarVolume(dispositivo);
    }

    @Override
    public Comando criarComandoDiminuirVolume(Dispositivo dispositivo) {
        return new ComandoDiminuirVolume(dispositivo);
    }
}
