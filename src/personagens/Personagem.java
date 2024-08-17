import java.util.Random;

package personagens;

public abstract class Personagem {
    private int saude;
    private int defesa;
    private int ataque;
    private String nome;
    private bool visivel;

    public Personagem(int vida, int defesa, int ataque, String nome) {
        this.saude = vida;
        this.defesa = defesa;
        this.ataque = ataque;
        this.nome = nome;
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

    public String getNome() {
        return nome;
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
        }
        else {
            alvo.tomarDano(dano);
        }
    }

    public int defender() {
        int defesa = this.defesa + new Random().nextInt(5);
        return defesa;
    } 

    public boolean tomarDano(int dano) {
        this.saude -= dano;
        if this.saude <= 0 {
            return false;
        }
        return true;
    }

    public abstract void morrer();
}
