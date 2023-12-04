package entity.AllOptions;

import not_implemented.Feature;

import java.util.ArrayList;

public class Option {
    String name;
    ArrayList<String> skillProficiency = new ArrayList<String>();
    ArrayList<String> weaponProficiency = new ArrayList<String>();
    ArrayList<String> toolProficiency = new ArrayList<String>();
    ArrayList<String> armorProficiency = new ArrayList<String>();
    ArrayList<Feature> features = new ArrayList<Feature>();
    public void init(String name, ArrayList<String> skills, ArrayList<String> weapons, ArrayList<String> tools, ArrayList<String> armor, ArrayList<Feature> features){
        this.setName(name);
        this.setFeatures(features);
        this.setSkillProficiency(skills);
        this.setToolProficiency(tools);
        this.setWeaponProficiency(weapons);
        this.setArmorProficiency(armor);
    }
    public void setName(String name){this.name = name;}

    public void setSkillProficiency(ArrayList<String> skillProficiency) {
        this.skillProficiency = skillProficiency;
    }

    public void setToolProficiency(ArrayList<String> toolProficiency) {
        this.toolProficiency = toolProficiency;
    }

    public void setFeatures(ArrayList<Feature> features) {
        this.features = features;
    }

    public void setWeaponProficiency(ArrayList<String> weaponProficiency) {
        this.weaponProficiency = weaponProficiency;
    }
    public void setArmorProficiency(ArrayList<String> armorProficiency) {
        this.armorProficiency = armorProficiency;
    }
    public String getName(){
        return this.name;
    }

    public ArrayList<String> getSkillProficiency() {
        return skillProficiency;
    }

    public ArrayList<String> getToolProficiency() {
        return toolProficiency;
    }

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public ArrayList<String> getWeaponProficiency() {
        return weaponProficiency;
    }
}
