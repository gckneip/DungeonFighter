package dungeonfighter.entidades.personagens;

import javax.swing.ImageIcon;
import dungeonfighter.entidades.itens.Item;
import java.util.ArrayList;

public abstract class Heroi extends Personagem {

    private ArrayList<Item> bolsa;
    private final int tamanhoBolsa = 5;
    private int vidaMaxima;

    public Heroi(int vida, int defesa, int ataque, String nome, ImageIcon imagem, boolean visivel) {
        super(vida, defesa, ataque, nome, imagem, visivel);
        bolsa = new ArrayList<Item>(tamanhoBolsa);
        this.vidaMaxima = vida;
    }

    public abstract int especial(Personagem alvo);

    public void curar(int cura) {
        if (super.getVida() < vidaMaxima) {
            if (super.getVida() + cura > vidaMaxima) {
                super.setVida(vidaMaxima);
            } else {
                super.setVida(super.getVida() + cura);
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

    public ArrayList<Item> getBolsa() {
        return this.bolsa;
    }

    public void setBolsa(ArrayList<Item> item) {
        this.bolsa = item;
    }

    public void morrer() {
        super.setVida(0);
    }

    public ImageIcon getIcone() {
        return super.getIcone();
    }
}
