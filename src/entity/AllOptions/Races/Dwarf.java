package entity.AllOptions.Races;

import not_implemented.Feature;

import java.util.ArrayList;

public class Dwarf extends Race {
    public Dwarf(){
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        toolProficiency.add("smith's tools");
        weaponProficiency.add("battleaxe");
        weaponProficiency.add("handaxe");
        weaponProficiency.add("light hammer");
        weaponProficiency.add("warhammer");
        features.add(new Feature("Speed", "Your speed is not reduced by wearing heavy armor.", "PHB, page 18"));
        features.add(new Feature("Darkvision", "Accustomed to life underground, you have superior vision" +
                " in dark and dim conditions. You can see in dim light within 60 feet of you as if it were bright light," +
                " and in darkness as if it were dim light. You can't discern color in darkness, only shades of gray.", "PHB, page 18"));
        features.add(new Feature("Dwarven Resilience", "You have advantage on saving throws against poison," +
                " and you have resistance against poison damage.", "PHB, page 18"));
        features.add(new Feature("Stonecunning", "Whenever you make an Intelligence (History) check related to the origin of stonework, you are considered proficient in the History skill and add double your proficiency bonus to the check, instead of your normal proficiency bonus.", "PHB, page 18"));

        this.init("dwarf", "medium", 25, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);
    }
}
