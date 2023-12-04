package entity.AllOptions.Races;

import not_implemented.Feature;

import java.util.ArrayList;

public class Elf extends Race {
    public Elf(){
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        skillProficiency.add("Perception");
        features.add(new Feature("Darkvision", "Accustomed to life underground, you have superior vision" +
                " in dark and dim conditions. You can see in dim light within 60 feet of you as if it were bright light," +
                " and in darkness as if it were dim light. You can't discern color in darkness, only shades of gray.", "PHB, page 18"));
        features.add(new Feature("Speed", "You have advantage on saving throws against being charmed, and magic can't put you to sleep.", "PHB, page 21"));
        features.add(new Feature("Speed", "Elves don't need to sleep. Instead, they meditate deeply, remaining semiconscious, for 4 hours a day. (The Common word for such meditation is \"trance.\") While meditating, you can dream after a fashion; such dreams are actually mental exercises that have become reflexive through years of practice. After resting in this way, you gain the same benefit that a human does from 8 hours of sleep.", "PHB, page 21"));
        //features.add(new Feature("Speed", ".", "PHB, page 21"));
        this.init("elf", "medium", 30, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);
    }
}
