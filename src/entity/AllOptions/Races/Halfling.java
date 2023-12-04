package entity.AllOptions.Races;

import not_implemented.Feature;

import java.util.ArrayList;

public class Halfling extends Race {
    public Halfling(){
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
//features.add(new Feature("Speed", ".", "PHB, page 26"));
        features.add(new Feature("Lucky", "When you roll a 1 on an attack roll, ability check, or saving throw, you can reroll the die and must use the new roll.", "PHB, page 26"));
        features.add(new Feature("Brave", "You have advantage on saving throws against being frightened.", "PHB, page 26"));
        features.add(new Feature("Halfling Nimbleness", "You can move through the space of any creature that is of a size larger than yours.", "PHB, page 26"));
        this.init("halfling", "small", 25, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);
    }
}
