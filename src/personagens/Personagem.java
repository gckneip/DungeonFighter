package personagens;

public abstract class Personagem {
    private int saude;
    private int defesa;
    private int ataque;
    private String nome;

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
        int dano = this.ataque - alvo.getDefesa();
        if (dano < 0) {
            dano = 0;
        }
        alvo.setSaude(alvo.getSaude() - dano);
    }
}
