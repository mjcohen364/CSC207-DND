package entity.AllOptions.Races;

import not_implemented.Feature;

import java.util.ArrayList;

public class Human extends Race {
    public Human(){
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
//features.add(new Feature("Speed", ".", "PHB, page 38"));
        this.init("human", "medium", 30, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);
    }
}
