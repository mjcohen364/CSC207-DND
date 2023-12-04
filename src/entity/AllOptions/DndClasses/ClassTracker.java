package entity.AllOptions.DndClasses;

import java.util.HashMap;
import java.util.Map;

public class ClassTracker {
    Map<String, MyDndClass> allClasses = new HashMap<>();
    public ClassTracker(){
        allClasses.put("barbarian", new Barbarian());
        allClasses.put("bard", new Bard());
        allClasses.put("cleric", new Cleric());
        allClasses.put("druid", new Druid());
        allClasses.put("fighter", new Fighter());
        allClasses.put("monk", new Monk());
        allClasses.put("paladin", new Paladin());
        allClasses.put("ranger", new Ranger());
        allClasses.put("rogue", new Rogue());
        allClasses.put("sorcerer", new Sorcerer());
        allClasses.put("warlock", new Warlock());
        allClasses.put("wizard", new Wizard());
    }
    public MyDndClass getClass(String name){
        if(allClasses.containsKey(name)){
            return allClasses.get(name);
        }
        else {
            return allClasses.get("barbarian");
        }
    }
}
