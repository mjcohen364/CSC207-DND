public class Player implements Character{
    String name;
    List<Attribute> attributes;
    Inventory inventory;
    HitDice hitDice;
    ArmourClass armourClass;
    Size size;
    ClassLevel classLevel;
    Race race;
    List<DndClass> classes;
    Background background;
    List<Proficiency> skillProficiencies;
    List<Proficiency> equipmentProficiencies;
    List<Spell> spellsKnown;
    List<Feature> features;

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
    public List<DndClass> getClasses() {
        return classes;
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

    @Override
    public List<Feature> getFeatures() {
        return features;
    }
}
