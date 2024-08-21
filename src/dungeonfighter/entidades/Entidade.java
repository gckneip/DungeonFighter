package dungeonfighter.entidades;

import javax.swing.ImageIcon;

public abstract class Entidade {

    private final String nome;
    private final ImageIcon icone;
    private boolean visivel;

    public Entidade(String nome, ImageIcon icone, boolean visivel) {
        this.nome = nome;
        this.icone = icone;
        this.visivel = visivel;
    }

    public String getNome() {
        return this.nome;
    }

    public ImageIcon getIcone() {
        return this.icone;
    }

    public boolean getVisivel() {
        return this.visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }
}
