package entity.AllOptions.Races;

import not_implemented.Feature;

import java.util.ArrayList;

public class Dragonborn extends Race {
    public Dragonborn(){
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        features.add(new Feature("Draconic Ancestry", "You have draconic ancestry. Choose one type" +
                " of dragon from the Draconic Ancestry table. Your breath weapon and damage resistance are determined by" +
                " the dragon type", "PHB, page 32"));
        features.add(new Feature("Breath Weapon", "When you use your breath weapon, each creature in the" +
                " area of the exhalation must make a saving throw, the type of which is determined by your draconic ancestry. " +
                "The DC for this saving throw equals 8 + your Constitution modifier + your proficiency bonus. A creature takes " +
                "2d6 damage on a failed save, and half as much damage on a successful one. The damage increases to 3d6 at 6th level, " +
                "4d6 at 11th level, and 5d6 at 16th level. After you use your breath weapon, you can't use it again until you" +
                " complete a short or long rest.", "PHB, page 32"));
        features.add(new Feature("Damage Resistance", "You have resistance to the damage type associated with your draconic ancestry.", "PHB, page 32"));

        this.init("dragonborn", "medium", 25, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);
    }
}
