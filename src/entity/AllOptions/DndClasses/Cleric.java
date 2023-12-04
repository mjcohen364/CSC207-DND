package entity.AllOptions.DndClasses;

import not_implemented.Feature;

import java.util.ArrayList;

public class Cleric extends DndClass {
    public Cleric(){
        ArrayList<String> savingThrows = new ArrayList<>();
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        savingThrows.add("wisdom");
        savingThrows.add("charisma");
        weaponProficiency.add("simple");
        armorProficiency.add("light");
        armorProficiency.add("medium");
        armorProficiency.add("shield");
        features.add(new Feature("Skills - Cleric", "Choose 2 from History, Insight, Medicine, Persuasion, and Religion.", "PHB, page 56"));
        features.add(new Feature("Spellcasting - Cleric", "As a conduit for divine power, you can cast cleric spells. See chapter 10 for the general rules of spellcasting and chapter 11 for a selection of cleric spells.", "PHB, page 56"));
        features.add(new Feature("Divine Domain", "Choose one domain related to your deity from the list of available domains. Each domain is detailed in their own feature, and each one provides examples of gods associated with it. Your choice grants you domain spells and other features when you choose it at 1st level. It also grants you additional ways to use Channel Divinity when you gain that feature at 2nd level, and additional benefits at 6th, 8th, and 17th levels.", "PHB, page 56"));
        this.init("cleric", savingThrows, 8, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);
    }

}
