package dungeonfighter.entidades.personagens;

import javax.swing.ImageIcon;

public class Guerreiro extends Heroi {

    public Guerreiro() {
        super(30, 10, 5, "Guerreiro", new ImageIcon("assets/guerreiro.png"), true);
    }

    @Override
    public int especial(Personagem alvo) {
        super.setDefesa((int) (getDefesa() + 2));
        return getDefesa();
    }

}
