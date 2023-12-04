package entity.AllOptions.Backgrounds;

import not_implemented.Feature;

import java.util.ArrayList;

public class Acolyte extends Background {
    public Acolyte(){
        ArrayList<Feature> features = new ArrayList<>();
        ArrayList<String> skillProficiency = new ArrayList<String>();
        ArrayList<String> weaponProficiency = new ArrayList<String>();
        ArrayList<String> toolProficiency = new ArrayList<String>();
        ArrayList<String> armorProficiency = new ArrayList<String>();
        features.add(new Feature("Shelter of the Faithful", "As an acolyte, you command the respect of those who share your faith, and you can perform the religious ceremonies of your deity. You and your adventuring companions can expect to receive free healing and care at a temple, shrine, or other established presence of your faith, though you must provide any material components needed for spells. Those who share your religion will support you (but only you) at a modest lifestyle. You might also have ties to a specific temple dedicated to your chosen deity or pantheon, and you have a residence there. This could be the temple where you used to serve, if you remain on good terms with it, or a temple where you have found a new home. While near your temple, you can call upon the priests for assistance, provided the assistance you ask for is not hazardous and you remain in good standing with your temple.", "PHB, page 127"));
        skillProficiency.add("Insight");
        skillProficiency.add("Religion");
        this.init("acolyte", skillProficiency, weaponProficiency, toolProficiency, armorProficiency, features);
    }
}
