package dungeonfighter.entidades.personagens;

import javax.swing.ImageIcon;

public class LetMeDoItForYou extends Boss {

    public LetMeDoItForYou() {
        super(50, 15, 12, "Let Me Do It For You", new ImageIcon("src/dungeonfighter/assets/letMeDoItForYou.jpg"),
                true);
    }

    @Override
    public int especial(Personagem alvo) {
        int dano = super.getAtaque() * 2;
        alvo.setVida(alvo.getVida() - dano);
        return dano;
    }

}
