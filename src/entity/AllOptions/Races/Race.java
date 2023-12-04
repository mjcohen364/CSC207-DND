package entity.AllOptions.Races;

import entity.AllOptions.Option;
import not_implemented.Feature;

import java.util.ArrayList;

public class Race extends Option {
    String size;
    int speed;
    public void init(String name, String size, int speed, ArrayList<String> skills, ArrayList<String> weapons, ArrayList<String> tools, ArrayList<String> armors, ArrayList<Feature> features){
        this.setName(name);
        this.setFeatures(features);
        this.setSize(size);
        this.setSkillProficiency(skills);
        this.setToolProficiency(tools);
        this.setWeaponProficiency(weapons);
        this.setArmorProficiency(armors);
        this.setSpeed(speed);
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public String getSize(){
        return this.size;
    }
    public int getSpeed() {
        return speed;
    }


}
