public abstract class Inimigo extends Personagem{
    private Item espolio;

    public Inimigo(String nome, int vida, int ataque, int defesa){
        super(nome, vida, ataque, defesa);
        visivel = false;
    }

    public void setEspolio(Item espolio){
        this.espolio = espolio;
    }

    public Item dropEspolio(){
        return espolio;
    }

    public void setVisivel(){
        this.visivel = !this.visivel;
    }

    public void morrer(){
        this.dropEspolio();
        this.setVisivel();
    }
}