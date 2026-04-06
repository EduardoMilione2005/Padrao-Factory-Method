package com.controle.factory;

import com.controle.dispositivo.Dispositivo;
import com.controle.comando.Comando;

public interface ControleRemotoFactory {

    Dispositivo criarDispositivo();

    Comando criarComandoLigar(Dispositivo dispositivo);

    Comando criarComandoDesligar(Dispositivo dispositivo);

    Comando criarComandoAumentarVolume(Dispositivo dispositivo);

    Comando criarComandoDiminuirVolume(Dispositivo dispositivo);
}
