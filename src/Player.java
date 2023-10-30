public class Player implements Character{
    String name;
    List<Attribute> attributes;
    Inventory inventory;
    HitDice hitDice;
    ArmourClass armourClass;
    Size size;
    ClassLevel classLevel;
    Race race;
    DndClass dndClass;
    Background background;
    List<Proficiency> skillProficiencies;
    List<Proficiency> equipmentProficiencies;
    List<Spell> spellsKnown;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public HitDice getHitDice() {
        return hitDice;
    }

    @Override
    public ArmourClass getArmourClass() {
        return armourClass;
    }

    @Override
    public Size getSize() {
        return size;
    }

    @Override
    public ClassLevel getClassLevel() {
        return classLevel;
    }

    @Override
    public Race getRace() {
        return race;
    }

    @Override
    public DndClass getDndClass() {
        return dndClass;
    }

    @Override
    public Background getBackground() {
        return background;
    }

    @Override
    public List<Proficiency> getSkillProficiencies() {
        return skillProficiencies;
    }

    @Override
    public List<Proficiency> getEquipmentProficiencies() {
        return equipmentProficiencies;
    }

    @Override
    public List<Spell> getSpellsKnown() {
        return spellsKnown;
    }
}
