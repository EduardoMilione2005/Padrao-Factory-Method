package com.controle;

import com.controle.dispositivo.ArCondicionado;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes - Ar-Condicionado")
class ArCondicionadoTest {

    private ArCondicionado ar;

    @BeforeEach
    void setUp() {
        ar = new ArCondicionado("Daikin Split");
    }

    @Test
    @DisplayName("Ar começa desligado")
    void deveComecarDesligado() {
        assertFalse(ar.isLigado());
    }

    @Test
    @DisplayName("Temperatura padrão é 22°C")
    void temperaturaPadraoVinteDois() {
        assertEquals(22, ar.getTemperatura());
    }

    @Test
    @DisplayName("Modo padrão é REFRIGERAR")
    void modoPadraoRefrigerar() {
        assertEquals("REFRIGERAR", ar.getModo());
    }

    @Test
    @DisplayName("Deve aumentar temperatura quando ligado")
    void deveAumentarTemperaturaLigado() {
        ar.ligar();
        int tempInicial = ar.getTemperatura();
        ar.aumentarTemperatura();
        assertEquals(tempInicial + 1, ar.getTemperatura());
    }

    @Test
    @DisplayName("Deve diminuir temperatura quando ligado")
    void deveDiminuirTemperaturaLigado() {
        ar.ligar();
        int tempInicial = ar.getTemperatura();
        ar.diminuirTemperatura();
        assertEquals(tempInicial - 1, ar.getTemperatura());
    }

    @Test
    @DisplayName("Não deve alterar temperatura quando desligado")
    void naoDeveAlterarTemperaturaDesligado() {
        int temp = ar.getTemperatura();
        ar.aumentarTemperatura();
        assertEquals(temp, ar.getTemperatura());
    }

    @Test
    @DisplayName("Deve alterar modo quando ligado")
    void deveAlterarModoLigado() {
        ar.ligar();
        ar.setModo("ventilador");
        assertEquals("VENTILADOR", ar.getModo());
    }

    @Test
    @DisplayName("Não deve alterar modo quando desligado")
    void naoDeveAlterarModoDesligado() {
        ar.setModo("VENTILADOR");
        assertEquals("REFRIGERAR", ar.getModo());
    }

    @Test
    @DisplayName("Volume não é aplicável ao ar-condicionado")
    void volumeNaoAplicavel() {
        ar.ligar();
        int vol = ar.getVolume();
        ar.aumentarVolume();
        ar.diminuirVolume();
        assertEquals(vol, ar.getVolume());
    }

    @Test
    @DisplayName("getNome retorna nome correto")
    void deveRetornarNome() {
        assertEquals("Daikin Split", ar.getNome());
    }
}
