package entity;

import not_implemented.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface Character {
    String getName();
    LocalDateTime getCreationTime();
    ArrayList<DndAttribute> getAttributes();
    Inventory getInventory();
    HitDice getHitDice();
    ArmourClass getArmourClass();
    Size getSize();
    ClassLevel getClassLevel();
    Race getSubtype();
    ArrayList<DndClass> getClasses();
    Background getBackground();
    ArrayList<Proficiency> getSkillProficiencies();
    ArrayList<Proficiency> getEquipmentProficiencies();
    ArrayList<Spell> getSpellsKnown();
    ArrayList<Feature> getFeatures();
    void setName(String name);
    void addAttribute(DndAttribute newAttribute);
    void addItem(Item newItem);
    void setHitDice(HitDice hitDice);
    void setArmourClass(ArmourClass armourClass);
    void setSize(Size size);
    void setClassLevel(ClassLevel classLevel);
    void setSubtype(Race subtype);
    void addDndClass(DndClass newClass);
    void setBackground(Background background);
    void addSkillProficiency(Proficiency newSkillProficiency);
    void addEquipmentProficiency(Proficiency newEquipmentProficiency);
    void addSpell(Spell newSpell);
    void addFeature(Feature newFeature);
}