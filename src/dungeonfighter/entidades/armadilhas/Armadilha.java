package entidades.armadilhas;

import entidades.Entidade;
import entidades.personagens.Heroi;

import javax.swing.ImageIcon;

public abstract class Armadilha extends Entidade {

    public Armadilha(String nome, ImageIcon imagem, boolean visivel) {
        super(nome, imagem, visivel);
    }

    public abstract boolean darDano(Heroi heroi); // retorna um booleano para indicar se o heroi morreu
}
