package com.controle.service;

import com.controle.dispositivo.Dispositivo;
import com.controle.factory.ControleRemotoFactory;
import com.controle.comando.Comando;

public class DispositivoService {

    private final Dispositivo dispositivo;
    private final ControleRemoto controle;
    private final ControleRemotoFactory factory;

    public DispositivoService(ControleRemotoFactory factory) {
        this.factory = factory;
        this.dispositivo = factory.criarDispositivo();
        this.controle = new ControleRemoto();
    }

    public void ligar() {
        Comando cmd = factory.criarComandoLigar(dispositivo);
        controle.pressionar(cmd);
    }

    public void desligar() {
        Comando cmd = factory.criarComandoDesligar(dispositivo);
        controle.pressionar(cmd);
    }

    public void aumentarVolume() {
        Comando cmd = factory.criarComandoAumentarVolume(dispositivo);
        controle.pressionar(cmd);
    }

    public void diminuirVolume() {
        Comando cmd = factory.criarComandoDiminuirVolume(dispositivo);
        controle.pressionar(cmd);
    }

    public void desfazerUltimaAcao() {
        controle.desfazer();
    }

    public void exibirHistorico() {
        controle.exibirHistorico();
    }

    public Dispositivo getDispositivo() { return dispositivo; }
    public ControleRemoto getControle() { return controle; }
}
