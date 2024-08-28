package dungeonfighter.entidades.armadilhas;

import dungeonfighter.entidades.personagens.Heroi;
import javax.swing.ImageIcon;

public abstract class ArmadilhaFixa extends Armadilha {

    private final int dano = 1;

    public ArmadilhaFixa(String nome, ImageIcon imagem, boolean visivel) {
        super(nome, imagem, visivel);
    }

    @Override
    public boolean darDano(Heroi heroi) {
        return heroi.tomarDano(this.dano);
    }

    public int getDano() {
        return dano;
    }

}
