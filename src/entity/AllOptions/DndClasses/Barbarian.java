package entity.AllOptions.DndClasses;

import not_implemented.Feature;

import java.util.ArrayList;

public class Barbarian extends DndClass {
    public Barbarian(){
        ArrayList<String> savingThrows = new ArrayList<>();
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        savingThrows.add("strength");
        savingThrows.add("constitution");
        weaponProficiency.add("simple");
        weaponProficiency.add("martial");
        armorProficiency.add("light");
        armorProficiency.add("medium");
        armorProficiency.add("shield");
        features.add(new Feature("Skills - Barbarian", "Choose 2 from Animal Handling, Athletics, Intimidation, Nature, Perception, and Survival.", "PHB, page 46"));
        features.add(new Feature("Rage", "In battle, you fight with primal ferocity. On your turn, you can enter a rage as a bonus action. While raging you gain the following benefits if you aren't wearing heavy armor: -You have advantage on Strength checks and Strength saving throws. -When you make a melee weapon attack using Strength, you gain a +2 bonus to the damage roll. -You have resistance to bludgeoning, piercing, and slashing damage. If you are able to cast spells, you can't cast them or concentrate on them while raging. Your rage lasts for 1 minute. It ends early if you are knocked unconscious or if your turn ends and you haven't attacked a hostile creature since your last turn or taken damage since then. You can also end your rage on your turn as a bonus action. Once you have raged the maximum number of times for your barbarian level, you must finish a long rest before you can rage again. You may rage 2 times at 1st level, 3 at 3rd, 4 at 6th, 5 at 12th, and 6 at 17th.", "PHB, page 46"));
        features.add(new Feature("Unarmored Defense - Barbarian", "While you are not wearing any armor, your Armor Class equals 10 + your Dexterity modifier + your Constitution modifier. You can use a shield and still gain this benefit", "PHB, page 46"));
        this.init("barbarian", savingThrows, 12, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);
//features.add(new Feature("", "", "PHB, page 46"));
    }

}
