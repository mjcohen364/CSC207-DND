package entity.AllOptions.DndClasses;

import not_implemented.Feature;

import java.util.ArrayList;

public class Bard extends MyDndClass {
    public Bard(){
        ArrayList<String> savingThrows = new ArrayList<>();
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        savingThrows.add("dexterity");
        savingThrows.add("charisma");
        weaponProficiency.add("simple");
        weaponProficiency.add("hand crossbow");
        weaponProficiency.add("longsword");
        weaponProficiency.add("rapier");
        weaponProficiency.add("shortsword");
        armorProficiency.add("light");
        features.add(new Feature("Tool Proficiency - Bard", "Choose 3 musical instruments of your choice.", "PHB, page 51"));
        features.add(new Feature("Skills - Bard", "Choose 3 Any", "PHB, page 51"));
        features.add(new Feature("Bardic Inspiration", "You can inspire others through stirring words or music. To do so, you use a bonus action on your turn to choose one creature other than yourself within 60 feet of you who can hear you. That creature gains one Bardic Inspiration die, a d6. Once within the next 10 minutes, the creature can roll the die and add the number rolled to one ability check, attack roll, or saving throw it makes. The creature can wait until after it rolls the d20 before deciding to use the Bardic Inspiration die, but must decide before the DM says whether the roll succeeds or fails. Once the Bardic Inspiration die is rolled, it is lost. A creature can have only one Bardic Inspiration die at a time. You can use this feature a number of times equal to your Charisma modifier (a minimum of once). You regain any expended uses when you finish a long rest. Your Bardic Inspiration die changes when you reach certain levels in this class. The die becomes a d8 at 5th level, a d10 at 10th level, and a d12 at 15th level.", "PHB, page 51"));
        features.add(new Feature("Spellcasting - Bard", "You have learned to untangle and reshape the fabric of reality in harmony with your wishes and music. Your spells are part of your vast repertoire, magic that you can tune to different situations. See chapter 10 for the general rules of spellcasting and chapter 11 for the bard spell list.", "PHB, page 51"));
        this.init("bard", savingThrows, 8, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);
//features.add(new Feature("", "", "PHB, page 51"));
    }

}
