package com.controle;

import com.controle.dispositivo.Televisao;
import com.controle.comando.*;
import com.controle.service.ControleRemoto;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes - ControleRemoto (Invoker)")
class ControleRemotoTest {

    private ControleRemoto controle;
    private Televisao tv;

    @BeforeEach
    void setUp() {
        controle = new ControleRemoto();
        tv = new Televisao("TV JUnit");
    }

    @Test
    @DisplayName("Histórico começa vazio")
    void historicoComeçaVazio() {
        assertTrue(controle.historicoVazio());
        assertEquals(0, controle.getTamanhoHistorico());
    }

    @Test
    @DisplayName("Pressionar comando executa e registra no histórico")
    void pressionarRegistraHistorico() {
        controle.pressionar(new ComandoLigar(tv));
        assertEquals(1, controle.getTamanhoHistorico());
        assertTrue(tv.isLigado());
    }

    @Test
    @DisplayName("Desfazer reverte o último comando")
    void desfazerReverteUltimoComando() {
        controle.pressionar(new ComandoLigar(tv));
        assertTrue(tv.isLigado());
        controle.desfazer();
        assertFalse(tv.isLigado());
    }

    @Test
    @DisplayName("Desfazer remove do histórico")
    void desfazerRemoveDoHistorico() {
        controle.pressionar(new ComandoLigar(tv));
        controle.desfazer();
        assertEquals(0, controle.getTamanhoHistorico());
    }

    @Test
    @DisplayName("Desfazer sem histórico não lança exceção")
    void desfazerSemHistoricoNaoLancaExcecao() {
        assertDoesNotThrow(() -> controle.desfazer());
    }

    @Test
    @DisplayName("Múltiplos comandos são empilhados corretamente")
    void multiplosComandosSaoEmpilhados() {
        controle.pressionar(new ComandoLigar(tv));
        controle.pressionar(new ComandoAumentarVolume(tv));
        controle.pressionar(new ComandoAumentarVolume(tv));
        assertEquals(3, controle.getTamanhoHistorico());
    }

    @Test
    @DisplayName("Desfazer na ordem LIFO")
    void desfazerOrdemLIFO() {
        tv.ligar();
        int volInicial = tv.getVolume();
        controle.pressionar(new ComandoAumentarVolume(tv));
        controle.pressionar(new ComandoAumentarVolume(tv));
        controle.desfazer();
        assertEquals(volInicial + 1, tv.getVolume());
    }

    @Test
    @DisplayName("Limite do histórico é respeitado")
    void limiteHistoricoRespeitado() {
        ControleRemoto controleComLimite = new ControleRemoto(3);
        tv.ligar();
        controleComLimite.pressionar(new ComandoAumentarVolume(tv));
        controleComLimite.pressionar(new ComandoAumentarVolume(tv));
        controleComLimite.pressionar(new ComandoAumentarVolume(tv));
        controleComLimite.pressionar(new ComandoAumentarVolume(tv));
        assertEquals(3, controleComLimite.getTamanhoHistorico());
    }

    @Test
    @DisplayName("ComandoLigar: executar liga, desfazer desliga")
    void comandoLigarExecutarEDesfazer() {
        Comando cmd = new ComandoLigar(tv);
        cmd.executar();
        assertTrue(tv.isLigado());
        cmd.desfazer();
        assertFalse(tv.isLigado());
    }

    @Test
    @DisplayName("ComandoDesligar: executar desliga, desfazer liga")
    void comandoDesligarExecutarEDesfazer() {
        tv.ligar();
        Comando cmd = new ComandoDesligar(tv);
        cmd.executar();
        assertFalse(tv.isLigado());
        cmd.desfazer();
        assertTrue(tv.isLigado());
    }

    @Test
    @DisplayName("getDescricao retorna texto não-nulo")
    void getDescricaoNaoNulo() {
        Comando cmd = new ComandoLigar(tv);
        assertNotNull(cmd.getDescricao());
        assertFalse(cmd.getDescricao().isBlank());
    }
}
