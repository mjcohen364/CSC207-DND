package entity.AllOptions.DndClasses;

import not_implemented.Feature;

import java.util.ArrayList;

public class Fighter extends DndClass {
    public Fighter(){
        ArrayList<String> savingThrows = new ArrayList<>();
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        savingThrows.add("strength");
        savingThrows.add("dexterity");
        weaponProficiency.add("simple");
        weaponProficiency.add("martial");
        armorProficiency.add("light");
        armorProficiency.add("medium");
        armorProficiency.add("shield");
        armorProficiency.add("heavy");
        features.add(new Feature("Skills - Fighter", "Choose 2 from Acrobatics, Animal Handling, Athletics, History, Insight, Intimidation, Perception, and Survival.", "PHB, page 72"));
        features.add(new Feature("Fighting Style - Fighter", "You adopt a particular style of fighting as your specialty. Choose a fighting style available to fighters, at PHB p72. You can't take the same Fighting Style option more than once, even if you get to choose again.", "PHB, page 72"));
        features.add(new Feature("", "", "PHB, page 72"));
        this.init("fighter", savingThrows, 10, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);

    }

}
