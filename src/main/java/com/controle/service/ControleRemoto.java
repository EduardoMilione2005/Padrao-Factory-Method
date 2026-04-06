package com.controle.service;

import com.controle.comando.Comando;
import java.util.ArrayDeque;
import java.util.Deque;

public class ControleRemoto {

    private final Deque<Comando> historico = new ArrayDeque<>();
    private final int limiteHistorico;

    public ControleRemoto() {
        this.limiteHistorico = 10;
    }

    public ControleRemoto(int limiteHistorico) {
        this.limiteHistorico = limiteHistorico;
    }

    public void pressionar(Comando comando) {
        if (historico.size() >= limiteHistorico) {
            historico.removeLast();
        }
        comando.executar();
        historico.push(comando);
        System.out.println("  [Histórico] → " + comando.getDescricao());
    }

    public void desfazer() {
        if (historico.isEmpty()) {
            System.out.println("Nenhum comando para desfazer.");
            return;
        }
        Comando ultimo = historico.pop();
        System.out.println("  [Desfazendo] → " + ultimo.getDescricao());
        ultimo.desfazer();
    }

    public void exibirHistorico() {
        if (historico.isEmpty()) {
            System.out.println("Histórico vazio.");
            return;
        }
        System.out.println("=== Histórico de Comandos ===");
        historico.forEach(c -> System.out.println("  - " + c.getDescricao()));
    }

    public int getTamanhoHistorico() {
        return historico.size();
    }

    public boolean historicoVazio() {
        return historico.isEmpty();
    }
}
