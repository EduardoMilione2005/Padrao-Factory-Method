package com.controle;

import com.controle.dispositivo.Televisao;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes - Televisão")
class TelevisaoTest {

    private Televisao tv;

    @BeforeEach
    void setUp() {
        tv = new Televisao("TV Teste");
    }

    @Test
    @DisplayName("TV começa desligada")
    void deveComecarDesligada() {
        assertFalse(tv.isLigado());
    }

    @Test
    @DisplayName("Deve ligar corretamente")
    void deveLigar() {
        tv.ligar();
        assertTrue(tv.isLigado());
    }

    @Test
    @DisplayName("Deve desligar corretamente")
    void deveDesligar() {
        tv.ligar();
        tv.desligar();
        assertFalse(tv.isLigado());
    }

    @Test
    @DisplayName("Ligar duas vezes mantém ligado")
    void ligarDuasVezesMantémLigado() {
        tv.ligar();
        tv.ligar();
        assertTrue(tv.isLigado());
    }

    @Test
    @DisplayName("Deve aumentar volume quando ligada")
    void deveAumentarVolume() {
        tv.ligar();
        int volumeInicial = tv.getVolume();
        tv.aumentarVolume();
        assertEquals(volumeInicial + 1, tv.getVolume());
    }

    @Test
    @DisplayName("Não deve alterar volume quando desligada")
    void naoDeveAlterarVolumeDesligada() {
        int volumeInicial = tv.getVolume();
        tv.aumentarVolume();
        assertEquals(volumeInicial, tv.getVolume());
    }

    @Test
    @DisplayName("Volume não ultrapassa 100")
    void volumeNaoUltrapassaMaximo() {
        tv.ligar();
        for (int i = 0; i < 110; i++) tv.aumentarVolume();
        assertEquals(100, tv.getVolume());
    }

    @Test
    @DisplayName("Volume não vai abaixo de 0")
    void volumeNaoVaiAbaixoMinimo() {
        tv.ligar();
        for (int i = 0; i < 20; i++) tv.diminuirVolume();
        assertEquals(0, tv.getVolume());
    }

    @Test
    @DisplayName("Deve mudar canal quando ligada")
    void deveMudarCanal() {
        tv.ligar();
        tv.mudarCanal(10);
        assertEquals(10, tv.getCanal());
    }

    @Test
    @DisplayName("Não deve mudar canal quando desligada")
    void naoDeveMudarCanalDesligada() {
        int canalInicial = tv.getCanal();
        tv.mudarCanal(5);
        assertEquals(canalInicial, tv.getCanal());
    }

    @Test
    @DisplayName("Próximo canal incrementa corretamente")
    void proximoCanalIncrementa() {
        tv.ligar();
        tv.mudarCanal(3);
        tv.proximoCanal();
        assertEquals(4, tv.getCanal());
    }

    @Test
    @DisplayName("Canal anterior decrementa corretamente")
    void canalAnteriorDecrementa() {
        tv.ligar();
        tv.mudarCanal(5);
        tv.canalAnterior();
        assertEquals(4, tv.getCanal());
    }

    @Test
    @DisplayName("getNome retorna nome correto")
    void deveRetornarNome() {
        assertEquals("TV Teste", tv.getNome());
    }
}
