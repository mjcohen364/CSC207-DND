package entity.AllOptions.DndClasses;

import not_implemented.Feature;

import java.util.ArrayList;

public class Rogue extends DndClass {
    public Rogue(){
        ArrayList<String> savingThrows = new ArrayList<>();
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        savingThrows.add("dexterity");
        savingThrows.add("intelligence");
        weaponProficiency.add("simple");
        weaponProficiency.add("hand crossbow");
        weaponProficiency.add("longsword");
        weaponProficiency.add("rapier");
        weaponProficiency.add("shortsword");
        armorProficiency.add("light");
        features.add(new Feature("Tool Proficiency - Rogue", "Thieves Tool", "PHB, page 51"));
        features.add(new Feature("Skills - Rogue", "Choose 3 Any", "PHB, page 94"));
        features.add(new Feature("Expertise - Rogue", "At 1st level, choose two of your skill proficiencies, or one of your skill proficiencies and your proficiency with thieves' tools. Your proficiency bonus is doubled for any ability check you make that uses either of the chosen proficiencies. At 6th level, you can choose two more of your proficiencies (in skills or with thieves' tools) to gain this benefit.", "PHB, page 94"));
        features.add(new Feature("Sneak Attack", "Beginning at 1st level, you know how to strike subtly and exploit a foe's distraction. Once per turn, you can deal an extra 1d6 damage to one creature you hit with an attack if you have advantage on the attack roll. The attack must use a finesse or a ranged weapon. You don't need advantage on the attack roll if another enemy of the target is within 5 feet of it, that enemy isn't incapacitated, and you don't have disadvantage on the attack roll. The amount of the extra damage increases as you gain levels in this class, as shown in the Sneak Attack column of the Rogue table.", "PHB, page 94"));
        features.add(new Feature("Thieves' Cant", "During your rogue training you learned thieves' cant, a secret mix of dialect, jargon, and code that allows you to hide messages in seemingly normal conversation. Only another creature that knows thieves' cant understands such messages. It takes four times longer to convey such a message than it does to speak the same idea plainly. In addition, you understand a set of secret signs and symbols used to convey short, simple messages, such as whether an area is dangerous or the territory of a thieves' guild, whether loot is nearby, or whether the people in an area are easy marks or will provide a safe house for thieves on the run.", "PHB, page 94"));
        this.init("rogue", savingThrows, 8, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);

    }

}
