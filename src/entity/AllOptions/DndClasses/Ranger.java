package entity.AllOptions.DndClasses;

import not_implemented.Feature;

import java.util.ArrayList;

public class Ranger extends MyDndClass {
    public Ranger(){
        ArrayList<String> savingThrows = new ArrayList<>();
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        savingThrows.add("strength");
        savingThrows.add("dexterity");
        weaponProficiency.add("simple");
        weaponProficiency.add("martial");
        armorProficiency.add("light");
        armorProficiency.add("medium");
        armorProficiency.add("shield");
        armorProficiency.add("heavy");
        features.add(new Feature("Skills - Ranger", "Choose 3 from Animal Handling, Athletics, Insight, Investigation, Nature, Perception, Stealth, and Survival.", "PHB, page 89"));
        features.add(new Feature("Favored Enemy", "Beginning at 1st level, you have significant experience studying, tracking, hunting, and even talking to a certain type of enemy. Choose a type of favored enemy: aberrations, beasts, celestials, constructs, dragons, elementals, fey, fiends, giants, monstrosities, oozes, plants, or undead. Alternatively, you can select two races of humanoid (such as gnolls and orcs) as favored enemies. You have advantage on Wisdom (Survival) checks to track your favored enemies, as well as on Intelligence checks to recall information about them. When you gain this feature, you also learn one language of your choice that is spoken by your favored enemies, if they speak one at all. You choose one additional favored enemy, as well as an associated language, at 6th and 14th level. As you gain levels, your choices should reflect the types of monsters you have encountered on your adventures.", "PHB, page 89"));
        features.add(new Feature("Natural Explorer", "You are particularly familiar with one type of natural environment and are adept at traveling and surviving in such regions. Choose one type of favored terrain: arctic, coast, desert, forest, grassland, mountain, swamp, or the Underdark. When you make an Intelligence or Wisdom check related to your favored terrain, your proficiency bonus is doubled if you are using a skill that you're proficient in. While traveling for an hour or more in your favored terrain, you gain the following benefits: - Difficult terrain doesn't slow your group's travel. - Your group can't become lost except by magical means. - Even when you are engaged in another activity while traveling (such as foraging, navigating, or tracking), you remain alert to danger. - If you are traveling alone, you can move stealthily at a normal pace. - When you forage, you find twice as much food as you normally would. - While tracking other creatures, you also learn their exact number, their sizes, and how long ago they passed through the area. You choose additional favored terrain types at 6th and 10th level", "PHB, page 89"));
        this.init("ranger", savingThrows, 10, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);

    }

}
