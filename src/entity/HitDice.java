package entity;

import not_implemented.Feature;
import java.util.ArrayList;

public class HitDice {
    Player player;
    ArrayList<Integer> HitDiceByLevel = new ArrayList<>();
    public void addHitDie(Integer hitdie){
        this.HitDiceByLevel.add(hitdie);
    }/*
    public int calculateMaxHitPoints(){
        int hitpoints = 0;
        int ConstitutionModifier = 0;
        ArrayList<DndAttribute> attributes = player.getAttributes();
        ArrayList<Feature> features = player.getFeatures();
        for (int i = 0; i < attributes.size(); i++) {
            if (attributes.get(i).getName() == AttributeType.CONSTITUTION){
                ConstitutionModifier = attributes.get(i).getModifier();
                break;
            }
        }
        for (int i = 0; i < features.size(); i++) {
            if (features.get(i).getName() == "Tough"){
                ConstitutionModifier += 2;
                break;
            }
        }
        for (int i = 0; i < HitDiceByLevel.size(); i++) {
            hitpoints += HitDiceByLevel.get(i) + ConstitutionModifier;

        }
        return hitpoints;
    }
/*
    public String printHitDie(){
        StringBuilder ret = new StringBuilder();
        ArrayList<Integer> diecount = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            diecount.add(0);

        }
        // d6, d8, d10, d12 respectfully
        for (int i = 0; i < HitDicePerLevel.size(); i++) {
            diecount.get((HitDicePerLevel.get(i) - 4)/2);
        }
        for (int i = 0; i < 4; i++) {
            if (diecount.get(i) == 0) {
                continue;
            }
            if (ret.isEmpty()){
                ret.append(" + ");
            }
            ret.append(toString(diecount.get(i)))
        }

        return ret.toString();
    }
    */
}
