package entity;

public class DndAttribute {
    private AttributeType type;
    private int value;

    public DndAttribute(AttributeType type, int value) {
        this.type = type;
        this.value = value;
    }

    // Getters and setters for type and value
    public AttributeType getType() {
        return type;
    }

    public void setType(AttributeType type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

// Enum for attribute types, could be in its own file or nested within DndAttribute class
enum AttributeType {
    STRENGTH,
    CONSTITUTION,
    DEXTERITY,
    INTELLIGENCE,
    WISDOM,
    CHARISMA
}
