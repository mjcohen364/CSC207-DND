package entity.AllOptions.DndClasses;

import not_implemented.Feature;

import java.util.ArrayList;

public class Wizard extends MyDndClass {
    public Wizard(){
        ArrayList<String> savingThrows = new ArrayList<>();
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        savingThrows.add("wisdom");
        savingThrows.add("intelligence");
        weaponProficiency.add("dagger");
        weaponProficiency.add("dart");
        weaponProficiency.add("sling");
        weaponProficiency.add("quarterstaff");
        weaponProficiency.add("light crossbow");
        features.add(new Feature("Skills - Wizard", "Choose 2 from Arcana, History, Insight, Investigation, Medicine, and Religion.", "PHB, page 112"));
        features.add(new Feature("Spellcasting - Wizard", "You have learned to regain some of your magical energy by studying your spellbook. Once per day when you finish a short rest, you can choose expended spell slots to recover. The spell slots can have a combined level that is equal to or less than half your wizard level (rounded up), and none of the slots can be 6th level or higher. For example, if you're a 4th-level wizard, you can recover up to two levels worth of spell slots. You can recover either a 2nd-level spell slot or two 1st-level spell slots.", "PHB, page 112"));
        features.add(new Feature("Arcane Recovery", ".", "PHB, page 112"));

        this.init("wizard", savingThrows, 6, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);

    }

}
