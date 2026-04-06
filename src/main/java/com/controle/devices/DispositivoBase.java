package devices;

public abstract class DispositivoBase implements Dispositivo {

    protected String nome;
    protected boolean ligado;
    protected int volume;
    protected int brilho;

    protected static final int VOLUME_MIN = 0;
    protected static final int VOLUME_MAX = 100;
    protected static final int BRILHO_MIN = 0;
    protected static final int BRILHO_MAX = 100;

    public DispositivoBase(String nome) {
        this.nome = nome;
        this.ligado = false;
        this.volume = 50;
        this.brilho = 50;
    }

    @Override
    public void ligar() {
        this.ligado = true;
        System.out.println("[" + nome + "] Dispositivo LIGADO.");
    }

    @Override
    public void desligar() {
        this.ligado = false;
        System.out.println("[" + nome + "] Dispositivo DESLIGADO.");
    }

    @Override
    public void aumentarVolume() {
        if (!ligado) { System.out.println("[" + nome + "] Dispositivo desligado."); return; }
        if (volume < VOLUME_MAX) volume += 5;
        System.out.println("[" + nome + "] Volume: " + volume);
    }

    @Override
    public void diminuirVolume() {
        if (!ligado) { System.out.println("[" + nome + "] Dispositivo desligado."); return; }
        if (volume > VOLUME_MIN) volume -= 5;
        System.out.println("[" + nome + "] Volume: " + volume);
    }

    @Override
    public void aumentarBrilho() {
        if (!ligado) { System.out.println("[" + nome + "] Dispositivo desligado."); return; }
        if (brilho < BRILHO_MAX) brilho += 10;
        System.out.println("[" + nome + "] Brilho: " + brilho);
    }

    @Override
    public void diminuirBrilho() {
        if (!ligado) { System.out.println("[" + nome + "] Dispositivo desligado."); return; }
        if (brilho > BRILHO_MIN) brilho -= 10;
        System.out.println("[" + nome + "] Brilho: " + brilho);
    }

    @Override
    public String getNome() { return nome; }

    public boolean isLigado() { return ligado; }
    public int getVolume() { return volume; }
    public int getBrilho() { return brilho; }
}
