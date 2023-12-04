package entity.AllOptions.Backgrounds;


import java.util.HashMap;
import java.util.Map;

public class BackgroundTracker {
    Map<String, Background> allBackground = new HashMap<>();
    public BackgroundTracker(){
        allBackground.put("acolyte", new Acolyte());
    }
    public Background getBackground(String name){
        if(allBackground.containsKey(name)){
            return allBackground.get(name);
        }
        else {
            return allBackground.get("acolyte");
        }
    }
}
