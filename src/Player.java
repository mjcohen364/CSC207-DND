import java.util.ArrayList;

public class Player implements Character{
    String name;
    ArrayList<DndAttribute> attributes = new ArrayList<DndAttribute>();
    Inventory inventory;
    HitDice hitDice;
    ArmourClass armourClass;
    Size size;
    ClassLevel classLevel;
    Race race;
    ArrayList<DndClass> classes = new ArrayList<DndClass>();
    Background background;
    ArrayList<Proficiency> skillProficiencies = new ArrayList<Proficiency>();
    ArrayList<Proficiency> equipmentProficiencies = new ArrayList<Proficiency>();
    ArrayList<Spell> spellsKnown = new ArrayList<Spell>();
    ArrayList<Feature> features = new ArrayList<Feature>();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ArrayList<DndAttribute> getAttributes() {
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
    public ArrayList<DndClass> getClasses() {
        return classes;
    }

    @Override
    public Background getBackground() {
        return background;
    }

    @Override
    public ArrayList<Proficiency> getSkillProficiencies() {
        return skillProficiencies;
    }

    @Override
    public ArrayList<Proficiency> getEquipmentProficiencies() {
        return equipmentProficiencies;
    }

    @Override
    public ArrayList<Spell> getSpellsKnown() {
        return spellsKnown;
    }

    @Override
    public ArrayList<Feature> getFeatures() {
        return features;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void addAttribute(DndAttribute newAttribute) {
        this.attributes.add(newAttribute);
    }

    @Override
    public void addItem(Item newItem) {
        this.inventory.add(newItem);
    }

    @Override
    public void setHitDice(HitDice hitDice) {
        this.HitDice = hitDice;
    }

    @Override
    public void setArmourClass(ArmourClass armourClass) {
        this.armourClass = armourClass;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public void setClassLevel(ClassLevel classLevel) {
        this.classLevel = classLevel;
    }

    @Override
    public void setRace(Race race) {
        this.race = race;
    }

    @Override
    public void addDndClass(DndClass newClass) {
        this.classes.add(newClass);
    }

    @Override
    public void setBackground(Background background) {
        this.background = background;
    }

    @Override
    public void addSkillProficiency(Proficiency newSkillProficiency) {
        this.skillProficiencies.add(newSkillProficiency);
    }

    @Override
    public void addEquipmentProficiency(Proficiency newEquipmentProficiency) {
        this.equipmentProficiencies.add(newEquipmentProficiency);
    }

    @Override
    public void addSpell(Spell newSpell) {
        this.spellsKnown.add(newSpell);
    }

    @Override
    public void addFeature(Feature newFeature) {
        this.features.add(newFeature);
    }
}
