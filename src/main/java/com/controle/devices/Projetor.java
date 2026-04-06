package devices;

public class Projetor extends DispositivoBase {

    private String resolucao;

    public Projetor(String nome) {
        super(nome);
        this.resolucao = "1080p";
    }

    public void trocarResolucao() {
        if (!ligado) { System.out.println("[" + nome + "] Projetor desligado."); return; }
        switch (resolucao) {
            case "720p":  resolucao = "1080p"; break;
            case "1080p": resolucao = "4K";    break;
            default:      resolucao = "720p";  break;
        }
        System.out.println("[" + nome + "] Resolução: " + resolucao);
    }

    public String getResolucao() { return resolucao; }

    @Override
    public String getStatus() {
        return String.format("Projetor '%s' | %s | Resolução: %s | Volume: %d | Brilho: %d",
                nome, ligado ? "LIGADO" : "DESLIGADO", resolucao, volume, brilho);
    }
}
