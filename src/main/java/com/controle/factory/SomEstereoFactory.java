package com.controle.factory;

import com.controle.dispositivo.Dispositivo;
import com.controle.dispositivo.SomEstereo;
import com.controle.comando.*;

public class SomEstereoFactory implements ControleRemotoFactory {

    private final String nomeSom;

    public SomEstereoFactory(String nomeSom) {
        this.nomeSom = nomeSom;
    }

    @Override
    public Dispositivo criarDispositivo() {
        return new SomEstereo(nomeSom);
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
