package devices;

public class SomEstereo extends DispositivoBase {

    private String modo;

    public SomEstereo(String nome) {
        super(nome);
        this.modo = "FM";
    }

    public void trocarModo() {
        if (!ligado) { System.out.println("[" + nome + "] Som desligado."); return; }
        switch (modo) {
            case "FM":        modo = "AM";        break;
            case "AM":        modo = "Bluetooth"; break;
            case "Bluetooth": modo = "AUX";       break;
            default:          modo = "FM";        break;
        }
        System.out.println("[" + nome + "] Modo: " + modo);
    }

    public String getModo() { return modo; }

    @Override
    public String getStatus() {
        return String.format("Som '%s' | %s | Modo: %s | Volume: %d | Brilho: %d",
                nome, ligado ? "LIGADO" : "DESLIGADO", modo, volume, brilho);
    }
}
