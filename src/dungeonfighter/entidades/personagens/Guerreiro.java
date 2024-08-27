package dungeonfighter.entidades.personagens;

import javax.swing.ImageIcon;

public class Guerreiro extends Heroi {

    public Guerreiro() {
        super(30, 10, 5, "Guerreiro", new ImageIcon("src/dungeonfighter/entidades/personagens/guerreiro.jpeg"), true);
    }

    @Override
    public void especial(Personagem alvo) {
        super.setDefesa((int) (getDefesa() + getDefesa() * 0.7));
    }

    public void desfazEspecial() {
        super.setDefesa((int) (getDefesa() - getDefesa() * 0.7));
    }

}
