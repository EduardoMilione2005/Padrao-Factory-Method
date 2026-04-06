package com.controle;

import com.controle.dispositivo.*;
import com.controle.factory.*;
import com.controle.comando.Comando;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes - Abstract Factory")
class AbstractFactoryTest {

    @Test
    @DisplayName("TelevisaoFactory cria instância de Televisao")
    void televisaoFactoryCriaTV() {
        ControleRemotoFactory factory = new TelevisaoFactory("TV Factory");
        Dispositivo d = factory.criarDispositivo();
        assertInstanceOf(Televisao.class, d);
    }

    @Test
    @DisplayName("SomEstereoFactory cria instância de SomEstereo")
    void somFactoriaCriaSom() {
        ControleRemotoFactory factory = new SomEstereoFactory("Som Factory");
        Dispositivo d = factory.criarDispositivo();
        assertInstanceOf(SomEstereo.class, d);
    }

    @Test
    @DisplayName("ArCondicionadoFactory cria instância de ArCondicionado")
    void arFactoriaCriaAr() {
        ControleRemotoFactory factory = new ArCondicionadoFactory("Ar Factory");
        Dispositivo d = factory.criarDispositivo();
        assertInstanceOf(ArCondicionado.class, d);
    }

    @Test
    @DisplayName("Factory cria comando de ligar não-nulo")
    void factoryCriaComandoLigar() {
        ControleRemotoFactory factory = new TelevisaoFactory("TV");
        Dispositivo d = factory.criarDispositivo();
        Comando cmd = factory.criarComandoLigar(d);
        assertNotNull(cmd);
    }

    @Test
    @DisplayName("Factory cria comando de desligar não-nulo")
    void factoryCriaComandoDesligar() {
        ControleRemotoFactory factory = new TelevisaoFactory("TV");
        Dispositivo d = factory.criarDispositivo();
        Comando cmd = factory.criarComandoDesligar(d);
        assertNotNull(cmd);
    }

    @Test
    @DisplayName("Factory cria comando de aumentar volume não-nulo")
    void factoryCriaComandoAumentarVolume() {
        ControleRemotoFactory factory = new SomEstereoFactory("Som");
        Dispositivo d = factory.criarDispositivo();
        Comando cmd = factory.criarComandoAumentarVolume(d);
        assertNotNull(cmd);
    }

    @Test
    @DisplayName("Factory cria comando de diminuir volume não-nulo")
    void factoryCriaComandoDiminuirVolume() {
        ControleRemotoFactory factory = new SomEstereoFactory("Som");
        Dispositivo d = factory.criarDispositivo();
        Comando cmd = factory.criarComandoDiminuirVolume(d);
        assertNotNull(cmd);
    }

    @Test
    @DisplayName("Comando ligar da factory funciona corretamente")
    void comandoLigarDaFactoryFunciona() {
        ControleRemotoFactory factory = new TelevisaoFactory("TV");
        Dispositivo d = factory.criarDispositivo();
        assertFalse(d.isLigado());
        factory.criarComandoLigar(d).executar();
        assertTrue(d.isLigado());
    }

    @Test
    @DisplayName("Fábricas diferentes produzem dispositivos independentes")
    void fabricasDiferentesProduzemDispositivosIndependentes() {
        Dispositivo tv = new TelevisaoFactory("TV").criarDispositivo();
        Dispositivo som = new SomEstereoFactory("Som").criarDispositivo();
        tv.ligar();
        assertFalse(som.isLigado());
    }
}
