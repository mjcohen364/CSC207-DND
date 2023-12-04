package entity.AllOptions.DndClasses;

import not_implemented.Feature;

import java.util.ArrayList;

public class Sorcerer extends DndClass {
    public Sorcerer(){
        ArrayList<String> savingThrows = new ArrayList<>();
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        savingThrows.add("constitution");
        savingThrows.add("charisma");
        weaponProficiency.add("dagger");
        weaponProficiency.add("dart");
        weaponProficiency.add("sling");
        weaponProficiency.add("quarterstaff");
        weaponProficiency.add("light crossbow");
        features.add(new Feature("Skills - Sorcerer", "Choose 2 from Arcana, Deception, Insight, Intimidation, Persuasion, and Religion.", "PHB, page 99"));
        features.add(new Feature("Spelllcasting - Sorcerer", "An event in your past, or in the life of a parent or ancestor, left an indelible mark on you, infusing you with arcane magic. This font of magic, whatever its origin, fuels your spells. See chapter 10 for the general rules of spellcasting and chapter 11 for the sorcerer spell list.", "PHB, page 99"));
        features.add(new Feature("Sorcerous Origin", "Choose a sorcerous origin, which describes the source of your innate magical power, from the list of available origins. Your choice grants you features when you choose it at 1st level and again at 6th, 14th, and 18th level.", "PHB, page 99"));

        this.init("sorcerer", savingThrows, 6, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);

    }

}
