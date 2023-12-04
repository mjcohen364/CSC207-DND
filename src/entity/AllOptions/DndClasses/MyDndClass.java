package entity.AllOptions.DndClasses;

import entity.AllOptions.Option;
import not_implemented.Feature;

import java.util.ArrayList;

public class MyDndClass extends Option {
    int hitdie;
    ArrayList<String> savingThrows = new ArrayList<>();
    public void init(String name, ArrayList<String> savingThrows, int hitdie, ArrayList<String> skills, ArrayList<String> weapons, ArrayList<String> tools, ArrayList<String> armors, ArrayList<Feature> features){
        this.setName(name);
        this.setFeatures(features);
        this.setHitdie(hitdie);
        this.setSkillProficiency(skills);
        this.setToolProficiency(tools);
        this.setWeaponProficiency(weapons);
        this.setArmorProficiency(armors);
        this.setSavingThrows(savingThrows);
    }

    public void setHitdie(int hitdie) {
        this.hitdie = hitdie;
    }

    public void setSavingThrows(ArrayList<String> savingThrows) {
        this.savingThrows = savingThrows;
    }
}
