package com.controle.comando;

public interface Comando {
    void executar();
    void desfazer();
    String getDescricao();
}
