package entity.AllOptions.Races;

import not_implemented.Feature;

import java.util.ArrayList;

public class HalfElf extends Race {
    public HalfElf(){
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        //features.add(new Feature("Speed", ".", "PHB, page 38"));
        features.add(new Feature("Skill Versatility", "You gain proficiency in two skills of your choice.", "PHB, page 38"));
        features.add(new Feature("Darkvision", "Thanks to your elf blood, you have superior vision in dark and dim conditions. You can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You can't discern color in darkness, only shades of gray.", "PHB, page 38"));
        features.add(new Feature("Fey Ancestry", "You have advantage on saving throws against being charmed, and magic can't put you to sleep.", "PHB, page 38"));
        this.init("half-elf", "medium", 30, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);
    }
}
