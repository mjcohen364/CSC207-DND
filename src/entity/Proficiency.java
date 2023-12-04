package entity;

import not_implemented.Feature;

import java.util.*;

public class Proficiency {
    int bonus;
    Map<String, Boolean> Skills = new HashMap<>();
    ArrayList<String> Tools = new ArrayList<>();
    Map<String, Boolean> Armor = new HashMap<>();
    Map<String, Boolean> SavingThrows = new HashMap<>();
    ArrayList<String> Weapon = new ArrayList<>();

    public Proficiency(int level) {
        bonus = Math.floorDiv(level - 1, 4) + 2;
        ArrayList<String> skilllist = new ArrayList<String>(Arrays.asList("Athletics", "Acrobatics", "Sleight of Hand",
                "Stealth", "Arcana", "History", "Investigation", "Nature", "Religion", "Animal Handling", "Insight",
                "Medicine", "Perception", "Survival", "Deception", "Intimidation", "Performance", "Persuasion"));
        //18 skills, verify later
        for (int i = 0; i < 18; i++) {
            this.Skills.put(skilllist.get(i), false);
        }
        ArrayList<String> armorlist = new ArrayList<String>(Arrays.asList("light", "medium", "heavy", "shield"));
        for (int i = 0; i < 3; i++) {
            this.Armor.put(armorlist.get(i), false);
        }
        ArrayList<String> saves = new ArrayList<String>(Arrays.asList("strength", "dexterity", "constitution", "intelligence", "wisdom", "charisma"));

        for (int i = 0; i < 6; i++) {
            this.SavingThrows.put(saves.get(i), false);
        }
    }

    public void setSkillProficiency(String skill, boolean value) {
        this.Skills.put(skill, value);
    }

    public void setArmorProficiency(String armor, boolean value) {
        this.Armor.put(armor, value);
    }
    public void setSavingThrow(String armor, boolean value) {
        this.SavingThrows.put(armor, value);
    }
    public void setSkillProficiencies(ArrayList<String> skills, boolean value) {
        for (int i = 0; i < skills.size(); i++){
            setSkillProficiency(skills.get(i), value);
        }
    }
    public void setArmorProficiencies(ArrayList<String> armors, boolean value) {
        for (int i = 0; i < armors.size(); i++){
            setArmorProficiency(armors.get(i), value);
        }
    }
    public void setSavingThrows(ArrayList<String> armors, boolean value) {
        for (int i = 0; i < armors.size(); i++){
            setSavingThrow(armors.get(i), value);
        }
    }
    public void addWeaponProficiency(String weapon){
        Weapon.add(weapon);
    }
    public void addWeaponProficiencies(ArrayList<String> weapons) {
        for (int i = 0; i < weapons.size(); i++){
            if(!Weapon.contains(weapons.get(i))){
                this.addWeaponProficiency(weapons.get(i));
            }
        }
    }
    public void addToolProficiency(String tool){
        Tools.add(tool);
    }
    public void addToolProficiencies(ArrayList<String> tools) {
        for (int i = 0; i < tools.size(); i++){
            if(!Tools.contains(tools.get(i))){
                this.addToolProficiency(tools.get(i));
            }
        }
    }

    public int getProficiencyBonus() {
        return bonus;
    }

    public boolean checkSkillProficiency(String skill) {
        if (this.Skills.get(skill)) {
            return true;
        }
        return false;
    }
    public Map<String, Boolean> getSkills(){
        return Skills;
    }

}