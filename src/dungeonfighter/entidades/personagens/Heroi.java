package entidades.personagens;

public abstract class Heroi extends Personagem {

    private Item[] bolsa = new ArrayList<Item>();
    private final int tamanhoBolsa = 5;
    private int vidaMaxima;

    public Heroi(int vida, int defesa, int ataque, String nome) {
        super(vida, defesa, ataque, nome);
        bolsa = new Item[tamanhoBolsa];
        this.vidaMaxima = vida;
    }

    public abstract void especial(Personagem alvo);

    public void curar(int cura) {
        if (super.getSaude() < vidaMaxima) {
            if (super.getSaude() + cura > vidaMaxima) {
                super.setSaude(vidaMaxima);
            } else {
                super.setSaude(super.getSaude() + cura);
            }
        }
    }

    public void aumentarVidaMaxima(int upgrade) {
        this.vidaMaxima += upgrade;
    }

    public void aumentarDefesa(int upgrade) {
        super.setDefesa(super.getDefesa() + upgrade);
    }

    public void aumentarAtaque(int upgrade) {
        super.setAtaque(super.getAtaque() + upgrade);
    }

    public Item[] getBolsa() {
        return this.bolsa;
    }

    public void setBolsa(Item[] item) {
        this.bolsa = item;
    }
}
