package dungeonfighter.menu;

import dungeonfighter.DungeonFighter;
import dungeonfighter.entidades.personagens.*;
import java.awt.*;
import javax.swing.*;

public class CriarHeroiMenu extends JPanel {
    private final EscolhaPersonagemMenu escolhaPersonagemMenu;
    private final AtributosMenu atributosMenu;
    private final JLabel titulo;
    private final JButton botaoComecar;
    private final JTextField nomeField;

    public CriarHeroiMenu() {
        setLayout(new BorderLayout());

        titulo = new JLabel("Escolha seu Personagem", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));

        botaoComecar = new JButton("Confirmar");
        botaoComecar.setPreferredSize(new Dimension(120, 50));
        botaoComecar.setMinimumSize(new Dimension(120, 50));
        botaoComecar.setMaximumSize(new Dimension(120, 50));

        botaoComecar.addActionListener(e -> {
            comecarJogo();
        });

        nomeField = new JTextField(20);
        nomeField.setPreferredSize(new Dimension(200, 30));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 300, 10, 300));

        JLabel nomeLabel = new JLabel("Nome do Herói:");
        nomeLabel.setForeground(Color.WHITE);
        nomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nomeField.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoComecar.setAlignmentX(Component.CENTER_ALIGNMENT);

        inputPanel.add(nomeLabel);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        inputPanel.add(nomeField);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        inputPanel.add(botaoComecar);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        escolhaPersonagemMenu = new EscolhaPersonagemMenu();
        atributosMenu = new AtributosMenu();

        escolhaPersonagemMenu.addEscolhidoChangeListener(evt -> {
            tipoHeroi novoEscolhido = escolhaPersonagemMenu.getEscolhido();
            atributosMenu.setEscolhido(novoEscolhido);
        });

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.5;
        contentPanel.add(escolhaPersonagemMenu, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.5;
        contentPanel.add(atributosMenu, gbc);

        add(titulo, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }

    public String getNomeInput() {
        return nomeField.getText();
    }

    public void comecarJogo() {
        try {
            DungeonFighter jogo = DungeonFighter.getInstanceDungeonFighter();
            tipoHeroi escolhido = escolhaPersonagemMenu.getEscolhido();
            String nome = getNomeInput();
            int ataque = atributosMenu.getAtaque();
            int defesa = atributosMenu.getDefesa();
            int vida = atributosMenu.getVida();

            if (nome.isEmpty() || escolhido == null || ataque == 0 || defesa == 0 || vida == 0) {
                throw new IllegalArgumentException("Todos os campos devem ser preenchidos.");
            }

            Heroi heroi = null;

            switch (escolhido) {
                case BRUXO -> heroi = new Bruxo();
                case GUERREIRO -> heroi = new Guerreiro();
                case ARQUEIRO -> heroi = new Arqueiro();
            }

            if (heroi != null) {
                heroi.setAtaque(heroi.getAtaque() + (ataque - heroi.getAtaque()));
                heroi.setDefesa(heroi.getDefesa() + (defesa - heroi.getDefesa()));
                heroi.setVida(heroi.getVida() + (vida - heroi.getVida()));

                jogo.setHeroi(heroi);
                jogo.iniciarJogo();
            }
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro inesperado: " + ex.getMessage(), "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
