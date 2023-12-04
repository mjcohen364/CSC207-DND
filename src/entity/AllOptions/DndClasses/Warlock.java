package entity.AllOptions.DndClasses;

import not_implemented.Feature;

import java.util.ArrayList;

public class Warlock extends MyDndClass {
    public Warlock(){
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
        features.add(new Feature("Skills - Warlock", "Choose 2 from Arcana, Deception, History, Intimidation, Investigation, Nature, and Religion.", "PHB, page 105"));
        features.add(new Feature("Pact Magic", "Your arcane research and the magic bestowed on you by your patron have given you facility with spells. See chapter 10 for the general rules of spellcasting and chapter 11 for the warlock spell list.", "PHB, page 105"));
        features.add(new Feature("Otherworldly Patron", "At 1st level, you have struck a bargain with an otherworldly being chosen from the list of available patrons. Your choice grants you features at 1st level and again at 6th, 10th, and 14th level.", "PHB, page 105"));

        this.init("warlock", savingThrows, 8, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);

    }

}
