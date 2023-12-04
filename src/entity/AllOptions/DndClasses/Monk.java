package entity.AllOptions.DndClasses;

import not_implemented.Feature;

import java.util.ArrayList;

public class Monk extends DndClass {
    public Monk(){
        ArrayList<String> savingThrows = new ArrayList<>();
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        savingThrows.add("wisdom");
        savingThrows.add("strength");
        weaponProficiency.add("simple");
        weaponProficiency.add("shortsword");
        features.add(new Feature("Tool Proficiency - Monk", "any one type of artisan's tools or any one musical instrument of your choice", "PHB, page 76"));
        features.add(new Feature("Skills - Monk", "Choose 2 from Acrobatics, Athletics, History, Insight, Religion, and Stealth.", "PHB, page 76"));
        features.add(new Feature("Unarmored Defense - Monk", "Beginning at 1st level, while you are wearing no armor and not wielding a shield, your AC equals 10 + your Dexterity modifier + your Wisdom modifier.", "PHB, page 76"));
        features.add(new Feature("Martial Arts", "Your practice of martial arts gives you mastery of combat styles that use unarmed strikes and monk weapons, which are shortswords and any simple melee weapons that don't have the two-handed or heavy property. You gain the following benefits while you are unarmed or wielding only monk weapons and you aren't wearing armor or wielding a shield: -You can use Dexterity instead of Strength for the attack and damage rolls of your unarmed strikes and monk weapons. - You can roll a d4 in place of the normal damage of your unarmed strike or monk weapon. This die changes as you gain monk levels, as shown in the Martial Arts column of the Monk table. - When you use the Attack action with an unarmed strike or a monk weapon on your turn, you can make one unarmed strike as a bonus action. For example, if you take the Attack action and attack with a quarterstaff, you can also make an unarmed strike as a bonus action, assuming you haven't already taken a bonus action this turn. Certain monasteries use specialized forms of the monk weapons. For example, you might use a club that is two lengths of wood connected by a short chain (called a nunchaku) or a sickle with a shorter, straighter blade (called a kama).", "PHB, page 76"));

        this.init("monk", savingThrows, 8, skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);

    }

}
