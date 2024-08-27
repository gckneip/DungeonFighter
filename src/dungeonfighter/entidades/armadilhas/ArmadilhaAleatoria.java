package dungeonfighter.entidades.armadilhas;

import dungeonfighter.entidades.personagens.Heroi;
import javax.swing.ImageIcon;
import java.util.Random;

public abstract class ArmadilhaAleatoria extends Armadilha {

    public ArmadilhaAleatoria(String nome, ImageIcon imagem, boolean visivel) {
        super(nome, imagem, visivel);
    }

    @Override
    public boolean darDano(Heroi heroi) {
        Random random = new Random();
        int dano = random.nextInt(4) + 2;
        return heroi.tomarDano(dano);
    }
}
