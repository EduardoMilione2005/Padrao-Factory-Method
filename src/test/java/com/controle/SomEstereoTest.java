package com.controle;

import com.controle.dispositivo.SomEstereo;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes - Som Estéreo")
class SomEstereoTest {

    private SomEstereo som;

    @BeforeEach
    void setUp() {
        som = new SomEstereo("JBL Bar");
    }

    @Test
    @DisplayName("Som começa desligado")
    void deveComecarDesligado() {
        assertFalse(som.isLigado());
    }

    @Test
    @DisplayName("Equalizer padrão é NORMAL")
    void equalizerPadraoNormal() {
        assertEquals("NORMAL", som.getModoEqualizer());
    }

    @Test
    @DisplayName("Fonte padrão é BLUETOOTH")
    void fontePadraoBluetooth() {
        assertEquals("BLUETOOTH", som.getFonte());
    }

    @Test
    @DisplayName("Deve ligar e desligar")
    void deveLigarEDesligar() {
        som.ligar();
        assertTrue(som.isLigado());
        som.desligar();
        assertFalse(som.isLigado());
    }

    @Test
    @DisplayName("Deve alterar equalizer quando ligado")
    void deveAlterarEqualizerLigado() {
        som.ligar();
        som.setEqualizer("rock");
        assertEquals("ROCK", som.getModoEqualizer());
    }

    @Test
    @DisplayName("Não deve alterar equalizer quando desligado")
    void naoDeveAlterarEqualizerDesligado() {
        som.setEqualizer("ROCK");
        assertEquals("NORMAL", som.getModoEqualizer());
    }

    @Test
    @DisplayName("Deve alterar fonte quando ligado")
    void deveAlterarFonteLigado() {
        som.ligar();
        som.setFonte("hdmi");
        assertEquals("HDMI", som.getFonte());
    }

    @Test
    @DisplayName("Não deve alterar fonte quando desligado")
    void naoDeveAlterarFonteDesligado() {
        som.setFonte("HDMI");
        assertEquals("BLUETOOTH", som.getFonte());
    }

    @Test
    @DisplayName("Deve aumentar e diminuir volume")
    void deveAjustarVolume() {
        som.ligar();
        int inicial = som.getVolume();
        som.aumentarVolume();
        assertEquals(inicial + 1, som.getVolume());
        som.diminuirVolume();
        assertEquals(inicial, som.getVolume());
    }

    @Test
    @DisplayName("getNome retorna nome correto")
    void deveRetornarNome() {
        assertEquals("JBL Bar", som.getNome());
    }
}
