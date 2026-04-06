package devices;

public class Televisao extends DispositivoBase {

    private int canal;

    public Televisao(String nome) {
        super(nome);
        this.canal = 1;
    }

    public void proximoCanal() {
        if (!ligado) { System.out.println("[" + nome + "] TV desligada."); return; }
        canal++;
        System.out.println("[" + nome + "] Canal: " + canal);
    }

    public void canalAnterior() {
        if (!ligado) { System.out.println("[" + nome + "] TV desligada."); return; }
        if (canal > 1) canal--;
        System.out.println("[" + nome + "] Canal: " + canal);
    }

    public int getCanal() { return canal; }

    @Override
    public String getStatus() {
        return String.format("TV '%s' | %s | Canal: %d | Volume: %d | Brilho: %d",
                nome, ligado ? "LIGADA" : "DESLIGADA", canal, volume, brilho);
    }
}
