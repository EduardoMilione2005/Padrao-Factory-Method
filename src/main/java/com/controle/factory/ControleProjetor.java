package factory;

import devices.Dispositivo;
import devices.Projetor;

public class ControleProjetor extends ControleRemoto {

    @Override
    protected Dispositivo criarDispositivo(String nome) {
        return new Projetor(nome);
    }

    public void trocarResolucao(Projetor projetor) {
        projetor.trocarResolucao();
    }
}
