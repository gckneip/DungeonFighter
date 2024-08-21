package dungeonfighter.menu;

public enum tipoHeroi {
    BRUXO("Bruxo"),
    GUERREIRO("Guerreiro"),
    ARQUEIRO("Arqueiro");

    private final String name;

    tipoHeroi(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
