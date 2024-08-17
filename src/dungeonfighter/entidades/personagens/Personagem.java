package entidades.personagens;

import entidades.Entidade;
import java.util.Random;
import javax.swing.ImageIcon;

public abstract class Personagem extends Entidade {

    private int saude;
    private int defesa;
    private int ataque;
    private String nome;

    public Personagem(int vida, int defesa, int ataque, String nome, ImageIcon imagem, boolean visivel) {
        super(nome, imagem, visivel);
        this.saude = vida;
        this.defesa = defesa;
        this.ataque = ataque;
    }

    public int getSaude() {
        return saude;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getAtaque() {
        return ataque;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    public void setSaude(int vida) {
        this.saude = vida;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void atacar(Personagem alvo) {
        int dano = (this.ataque + new Random().nextInt(10)) - alvo.defender();
        if (dano < 0) {
            tomarDano(-dano);
        } else {
            alvo.tomarDano(dano);
        }
    }

    public int defender() {
        int defesa = this.defesa + new Random().nextInt(5);
        return defesa;
    }

    public boolean tomarDano(int dano) {
        this.saude -= dano;
        if (this.saude <= 0) {
            return false;
        }
        return true;
    }

    public abstract void morrer();
}
