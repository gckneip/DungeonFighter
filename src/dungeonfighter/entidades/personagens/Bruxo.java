package dungeonfighter.entidades.personagens;

import javax.swing.ImageIcon;

public class Bruxo extends Heroi {

    public Bruxo() {
        super(20, 5, 8, "Bruxo", new ImageIcon("src/dungeonfighter/assets/bruxo.png"), true);
    }

    @Override
    public void especial(Personagem alvo) {
        int dano = super.getAtaque() * 2;
        alvo.setVida(alvo.getVida() - dano);
    }
}
