package com.controle;

import com.controle.dispositivo.Televisao;
import com.controle.dispositivo.SomEstereo;
import com.controle.dispositivo.ArCondicionado;
import com.controle.factory.*;
import com.controle.service.DispositivoService;

public class Main {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   SISTEMA DE CONTROLE DE DISPOSITIVOS ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        System.out.println("▶ Controlando a TELEVISÃO");
        System.out.println("─".repeat(40));
        DispositivoService tvService = new DispositivoService(new TelevisaoFactory("Smart TV Samsung"));
        tvService.ligar();
        tvService.aumentarVolume();
        tvService.aumentarVolume();
        tvService.aumentarVolume();
        tvService.diminuirVolume();

        Televisao tv = (Televisao) tvService.getDispositivo();
        tv.mudarCanal(5);
        tv.proximoCanal();

        tvService.desfazerUltimaAcao();
        tvService.exibirHistorico();

        System.out.println("\n▶ Controlando o SOM ESTÉREO");
        System.out.println("─".repeat(40));
        DispositivoService somService = new DispositivoService(new SomEstereoFactory("JBL Bar"));
        somService.ligar();
        somService.aumentarVolume();
        somService.aumentarVolume();

        SomEstereo som = (SomEstereo) somService.getDispositivo();
        som.setEqualizer("ROCK");
        som.setFonte("HDMI");
        somService.desligar();
        somService.exibirHistorico();

        System.out.println("\n▶ Controlando o AR-CONDICIONADO");
        System.out.println("─".repeat(40));
        DispositivoService arService = new DispositivoService(new ArCondicionadoFactory("Daikin Split"));
        arService.ligar();

        ArCondicionado ar = (ArCondicionado) arService.getDispositivo();
        ar.setModo("VENTILADOR");
        ar.aumentarTemperatura();
        ar.diminuirTemperatura();
        ar.diminuirTemperatura();
        arService.desfazerUltimaAcao();
        arService.exibirHistorico();

        System.out.println("\n✔ Demonstração concluída.");
    }
}
