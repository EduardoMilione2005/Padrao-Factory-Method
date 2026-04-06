package com.controle.factory;

import com.controle.dispositivo.Dispositivo;
import com.controle.dispositivo.ArCondicionado;
import com.controle.comando.*;

public class ArCondicionadoFactory implements ControleRemotoFactory {

    private final String nomeAr;

    public ArCondicionadoFactory(String nomeAr) {
        this.nomeAr = nomeAr;
    }

    @Override
    public Dispositivo criarDispositivo() {
        return new ArCondicionado(nomeAr);
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
