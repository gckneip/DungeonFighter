package dungeonfighter.entidades.armadilhas;

import dungeonfighter.entidades.personagens.Heroi;
import javax.swing.ImageIcon;
import java.util.Random;

public abstract class ArmadilhaAleatoria extends Armadilha {
    private int dano;

    public ArmadilhaAleatoria(String nome, ImageIcon imagem) {
        super(nome, imagem);
    }

    @Override
    public boolean darDano(Heroi heroi) {
        Random random = new Random();
        this.dano = random.nextInt(5) + 2;
        return heroi.tomarDano(this.dano);
    }

    public int getDano() {
        return dano;
    }
}
