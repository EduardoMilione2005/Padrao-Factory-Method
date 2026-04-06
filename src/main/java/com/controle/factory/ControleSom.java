package factory;

import devices.Dispositivo;
import devices.SomEstereo;

public class ControleSom extends ControleRemoto {

    @Override
    protected Dispositivo criarDispositivo(String nome) {
        return new SomEstereo(nome);
    }

    public void trocarModo(SomEstereo som) {
        som.trocarModo();
    }
}
