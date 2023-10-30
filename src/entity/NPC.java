package entity;

public class NPC implements Character {

    private final String name;

    /**
     * Requires: password is valid.
     * @param name
     */
    Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
