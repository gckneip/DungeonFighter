package dungeonfighter.entidades.personagens;

import javax.swing.ImageIcon;

public class Bruxo extends Heroi {

    public Bruxo() {
        super(20, 5, 8, "Bruxo", new ImageIcon("assets/bruxo.png"), true);
    }

    @Override
    public int especial(Personagem alvo) {
        int dano = super.getAtaque() * 2;
        alvo.setVida(alvo.getVida() - dano);
        return dano;
    }
}
