package entity.AllOptions.DndClasses;

import not_implemented.Feature;

import java.util.ArrayList;

public class Paladin extends MyDndClass {
    public Paladin(){
        ArrayList<String> savingThrows = new ArrayList<>();
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        savingThrows.add("wisdom");
        savingThrows.add("charisma");
        weaponProficiency.add("simple");
        weaponProficiency.add("martial");
        armorProficiency.add("light");
        armorProficiency.add("medium");
        armorProficiency.add("shield");
        armorProficiency.add("heavy");
        features.add(new Feature("Skills - Paladin", "Choose 2 from Athletics, Insight, Intimidation, Medicine, Persuasion, and Religion.", "PHB, page 82"));
        features.add(new Feature("Divine Sense", "The presence of strong evil registers on your senses like a noxious odor, and powerful good rings like heavenly music in your ears. As an action, you can open your awareness to detect such forces. Until the end of your next turn, you know the location of any celestial, fiend, or undead within 60 feet of you that is not behind total cover. You know the type (celestial, fiend, or undead) of any being whose presence you sense, but not its identity (the vampire Count Strahd von Zarovich, for instance). Within the same radius, you also detect the presence of any place or object that has been consecrated or desecrated, as with the hallow spell. You can use this feature a number of times equal to 1 + your Charisma modifier. When you finish a long rest, you regain all expended uses.", "PHB, page 82"));
        this.init("paladin", savingThrows, 10, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);

    }

}
