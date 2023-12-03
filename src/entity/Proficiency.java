package entity;

import not_implemented.Feature;

import java.util.*;

public class Proficiency {
    int bonus;
    Map<String, Boolean> Skills = new HashMap<>();
    ArrayList<String> Tools = new ArrayList<>();
    Map<String, Boolean> Armor = new HashMap<>();
    Map<String, Boolean> Weapon = new HashMap<>();
    ArrayList<String> specificWeapons = new ArrayList<>();

    public void init(int level) {
        bonus = Math.floorDiv(level - 1, 4) + 2;
        ArrayList<String> skilllist = new ArrayList<String>(Arrays.asList("Athletics", "Acrobatics", "Sleight of Hand",
                "Stealth", "Arcana", "History", "Investigation", "Nature", "Religion", "Animal Handling", "Insight",
                "Medicine", "Perception", "Survival", "Deception", "Intimidation", "Performance", "Persuasion"));
        //18 skills, verify later
        for (int i = 0; i < 18; i++) {
            this.Skills.put(skilllist.get(i), false);
        }
        ArrayList<String> armorlist = new ArrayList<String>(Arrays.asList("Light", "Medium", "Heavy"));
        for (int i = 0; i < 3; i++) {
            this.Armor.put(armorlist.get(i), false);
        }
        ArrayList<String> weplist = new ArrayList<String>(Arrays.asList("Simple", "Martial"));
        //Maybe better with every weapon? they generally don't add new kinds of weapons
        for (int i = 0; i < 2; i++) {
            this.Weapon.put(weplist.get(i), false);
        }
    }

    public void forceSetBonus(int a) {
        this.bonus = a;
    }

    public void setSkillProficiency(String skill, boolean value) {
        this.Skills.put(skill, value);
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
    public int getTotalBonusSkill(Player2 player, String attribute, String skill) {
        int totalBonus = 0;
        ArrayList<Feature> b = player.getFeatures();
        totalBonus += Math.floorDiv((player.getAttributes().get(attribute))-10, 2);
        if (checkSkillProficiency(skill)) {
            totalBonus += this.getProficiencyBonus();
            for (int i = 0; i < b.size(); i++) {
                if (b.get(i).getName() == "Expertise: " + skill) {
                    totalBonus += this.getProficiencyBonus();
                    break;
                }
            }

        }
        return totalBonus;
    }
}