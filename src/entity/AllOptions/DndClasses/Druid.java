package entity.AllOptions.DndClasses;

import not_implemented.Feature;

import java.util.ArrayList;

public class Druid extends MyDndClass {
    public Druid(){
        ArrayList<String> savingThrows = new ArrayList<>();
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        savingThrows.add("wisdom");
        savingThrows.add("intelligence");
        weaponProficiency.add("club");
        weaponProficiency.add("dagger");
        weaponProficiency.add("dart");
        weaponProficiency.add("javelin");
        weaponProficiency.add("mace");
        weaponProficiency.add("quarterstaff");
        weaponProficiency.add("schimitar");
        weaponProficiency.add("sickle");
        weaponProficiency.add("sling");
        weaponProficiency.add("spear");
        armorProficiency.add("light");
        armorProficiency.add("medium");
        armorProficiency.add("shield");
        features.add(new Feature("Skills - Druid", "Choose 2 from Arcana, Animal Handling, Insight, Medicine, Nature, Perception, Religion, and Survival.", "PHB, page 64"));
        features.add(new Feature("Spellcasting - Druid", "Drawing on the divine essence of nature itself, you can cast spells to shape that essence to your will. See chapter 10 for the general rules of spellcasting and chapter 11 for the druid spell list.", "PHB, page 64"));
        features.add(new Feature("Druidic", "You know Druidic, the secret language of druids. You can speak the language and use it to leave hidden messages. You and others who know this language automatically spot such a message. Others spot the message's presence with a successful DC 15 Wisdom (Perception) check but can't decipher it without magic.", "PHB, page 64"));
        this.init("druid", savingThrows, 8, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);

    }

}
