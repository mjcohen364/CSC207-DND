package entity.AllOptions.Races;

import not_implemented.Feature;

import java.util.ArrayList;

public class Gnome extends Race {
    public Gnome(){
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        features.add(new Feature("Darkvision", "Accustomed to life underground, you have superior vision" +
                " in dark and dim conditions. You can see in dim light within 60 feet of you as if it were bright light," +
                " and in darkness as if it were dim light. You can't discern color in darkness, only shades of gray.", "PHB, page 35"));
        features.add(new Feature("Gnome Cunning", "You have advantage on all Intelligence, Wisdom, and Charisma saving throws against magic.", "PHB, page 35"));
        //features.add(new Feature("Speed", ".", "PHB, page 35"));
        this.init("gnome", "small", 25, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);
    }
}
