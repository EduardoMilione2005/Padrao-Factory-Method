package factory;

import devices.Dispositivo;
import devices.Televisao;

public class ControleTV extends ControleRemoto {

    @Override
    protected Dispositivo criarDispositivo(String nome) {
        return new Televisao(nome);
    }

    public void proximoCanal(Televisao tv) {
        tv.proximoCanal();
    }

    public void canalAnterior(Televisao tv) {
        tv.canalAnterior();
    }
}
