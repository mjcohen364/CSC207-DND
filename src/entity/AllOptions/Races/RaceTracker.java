package entity.AllOptions.Races;

import java.util.HashMap;
import java.util.Map;

public class RaceTracker {
    Map<String, Race> allRaces = new HashMap<>();
    public RaceTracker(){
        allRaces.put("dragonborn", new Dragonborn());
        allRaces.put("dwarf", new Dwarf());
        allRaces.put("elf", new Elf());
        allRaces.put("gnome", new Gnome());
        allRaces.put("half-elf", new HalfElf());
        allRaces.put("half-orc", new HalfOrc());
        allRaces.put("halfling", new Halfling());
        allRaces.put("human", new Human());
        allRaces.put("tiefling", new Tiefling());
    }
    public Race getRace(String name){
        if(allRaces.containsKey(name)){
            return allRaces.get(name);
        }
        else {
            return allRaces.get("dragonborn");
        }
    }
}
