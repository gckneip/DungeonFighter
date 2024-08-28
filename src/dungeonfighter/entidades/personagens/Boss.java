package dungeonfighter.entidades.personagens;

import javax.swing.ImageIcon;

public abstract class Boss extends Inimigo {

    public Boss(int vida, int defesa, int ataque, String nome, ImageIcon imagem, boolean visivel) {
        super(nome, vida, ataque, defesa, imagem, visivel, null);
    }

    public abstract int especial(Personagem alvo);

}
