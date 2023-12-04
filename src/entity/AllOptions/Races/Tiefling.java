package entity.AllOptions.Races;

import not_implemented.Feature;

import java.util.ArrayList;

public class Tiefling extends Race {
    public Tiefling(){
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
//features.add(new Feature("", "", "PHB, page 42"));
        features.add(new Feature("Darkvision", "Thanks to your infernal heritage, you have superior vision in dark and dim conditions. You can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You can't discern color in darkness, only shades of gray.", "PHB, page 42"));
        features.add(new Feature("Hellish Resistance", "You have resistance to fire damage.", "PHB, page 42"));
        features.add(new Feature("Infernal Legacy", "You know the thaumaturgy cantrip. Once you reach 3rd level, you can cast the hellish rebuke spell as a 2nd-level spell with this trait; you regain the ability to cast it when you finish a long rest. Once you reach 5th level, you can also cast the darkness spell once per day with this trait; you regain the ability to cast it when you finish a long rest. Charisma is your spellcasting ability for these spells.", "PHB, page 42"));
        this.init("tiefling", "medium", 30, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);
    }
}
