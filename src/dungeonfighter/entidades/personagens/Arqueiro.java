package dungeonfighter.entidades.personagens;

import javax.swing.ImageIcon;

public class Arqueiro extends Heroi {

    public Arqueiro() {
        super(25, 3, 6, "Arqueiro", new ImageIcon("assets/arqueiro.jpg"));
    }

    @Override
    public int especial(Personagem alvo) {
        int dano = super.getAtaque() * 3;
        alvo.setVida(alvo.getVida() - dano);
        return dano;
    }
}
