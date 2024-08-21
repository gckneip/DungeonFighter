package entidades.armadilhas;

import javax.swing.ImageIcon;
import entidades.personagens.Heroi;

public abstract class ArmadilhaAleatoria extends Armadilha {

    public ArmadilhaAleatoria(String nome, ImageIcon imagem, boolean visivel) {
        super(nome, imagem, visivel);
    }

    @Override
    public boolean darDano(Heroi heroi) {
        int dano = (int) (Math.random() * 10);
        return heroi.tomarDano(dano);
    }
}
