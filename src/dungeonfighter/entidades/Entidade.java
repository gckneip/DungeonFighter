package dungeonfighter.entidades;

import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class Entidade {

    private final String nome;
    private final ImageIcon icone;

    public Entidade(String nome, ImageIcon icone) {
        this.nome = nome;
        this.icone = icone;
    }

    public Image getImagem() {
        return this.icone.getImage();
    }

    public String getNome() {
        return this.nome;
    }

    public ImageIcon getIcone() {
        return this.icone;
    }
}
