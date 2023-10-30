import java.awt.dnd.DnDConstants;

public interface Character {
    String getName();
    List<Attribute> getAttributes();
    Inventory getInventory();
    HitDice getHitDice();
    ArmourClass getArmourClass();
    Size getSize();
    ClassLevel getClassLevel();
    Race getRace();
    List<DndClass> getClasses();
    Background getBackground();
    List<Proficiency> getSkillProficiencies();
    List<Proficiency> getEquipmentProficiencies();
    List<Spell> getSpellsKnown();
    List<Feature> getFeatures();
    void setName();
    void addAttribute();
    void addItem();
    void setHitDice();
    void setArmourClass();
    void setSize();
    void setClassLevel();
    void setRace();
    void setDndClass();
    void setBackground();
    void addSkillProficiency();
    void addEquipmentProficiency();
    void addSpell();
    void addFeature();
}