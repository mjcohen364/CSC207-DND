package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;

public class Proficiency {
    Dictionary<String, Boolean> Skills = new Hashtable<>();
    Dictionary<String, Boolean> Tools = new Hashtable<>();
    //no init for Tools, they have added new tools before
    Dictionary<String, Boolean> Armor = new Hashtable<>();
    Dictionary<String, Boolean> Weapons = new Hashtable<>();
    Dictionary<String, Boolean> Specific = new Hashtable<>();
    //Use for marking down specific weapon proficiency, fuse with Tools?

    public void init() {
        ArrayList<String> skilllist = new ArrayList<String>(Arrays.asList("Athletics", "Acrobatics", "Sleight of Hand",
                "Stealth", "Arcana", "History", "Investigation", "Nature", "Religion", "Animal Handling", "Insight",
                "Medicine", "Perception", "Survival", "Deception", "Intimidation", "Performance", "Persuasion"));
        //18 skills, verify later
        for (int i = 0; i < 18; i++) {
            this.Skills.put(skilllist.get(i), false);
        }
        ArrayList<String> armorlist = new ArrayList<String>(Arrays.asList("Light", "Medium", "Heavy"));
        for (int i = 0; i < 3; i++) {
            this.Armor.put(armorlist.get(i), false);
        }
        ArrayList<String> weplist = new ArrayList<String>(Arrays.asList("Simple", "Martial"));
        //Maybe better with every weapon? they generally don't add new kinds of weapons
        for (int i = 0; i < 3; i++) {
            this.Weapons.put(weplist.get(i), false);
        }
    }
    //    "Athletics","Acrobatics","Sleight of Hand","Stealth","Arcana","History","Investigation","Nature","Religion","Animal Handling","Insight","Medicine","Perception","Survival","Deception","Intimidation","Performance","Persuasion",
}