package entity.AllOptions.Races;

import not_implemented.Feature;

import java.util.ArrayList;

public class HalfOrc extends Race {
    public HalfOrc(){
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        //features.add(new Feature("Speed", ".", "PHB, page 38"));
        features.add(new Feature("Darkvision", "Thanks to your orc blood, you have superior vision in dark and dim conditions. You can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You can't discern color in darkness, only shades of gray.", "PHB, page 38"));
        features.add(new Feature("Relentless Endurance", "When you are reduced to 0 hit points but not killed outright, you can drop to 1 hit point instead. You can't use this feature again until you finish a long rest.", "PHB, page 38"));
        features.add(new Feature("Savage Attacks", "When you score a critical hit with a melee weapon attack, you can roll one of the weapon's damage dice one additional time and add it to the extra damage of the critical hit.", "PHB, page 38"));
        skillProficiency.add("Intimidation");
        this.init("half-orc", "medium", 30, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);
    }
}
