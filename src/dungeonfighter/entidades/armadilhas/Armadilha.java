package dungeonfighter.entidades.armadilhas;

import dungeonfighter.entidades.Entidade;
import dungeonfighter.entidades.personagens.Heroi;
import javax.swing.ImageIcon;

public abstract class Armadilha extends Entidade {

    public Armadilha(String nome, ImageIcon imagem, boolean visivel) {
        super(nome, imagem, visivel);
    }

    public abstract boolean darDano(Heroi heroi); // retorna um booleano para indicar se o heroi morreu

    public ImageIcon getIcone() {
        return super.getIcone();
    }
}
