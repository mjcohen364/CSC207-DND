package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entity.AllOptions.Backgrounds.Background;
import entity.AllOptions.Backgrounds.BackgroundTracker;
import entity.AllOptions.DndClasses.ClassTracker;
import entity.AllOptions.DndClasses.MyDndClass;
import entity.AllOptions.Races.Race;
import entity.AllOptions.Races.RaceTracker;
import not_implemented.*;

public class Player2 implements Character2 {
    String name;
    ArrayList<Integer> hitDice = new ArrayList<>();
    int speed;
    String size;
    int level;
    String DndClass;
    String subtype;
    String type;
    String background;
    Proficiency proficiency = new Proficiency(1);
    ArrayList<String> spellsKnown = new ArrayList<>();
    ArrayList<Feature> features = new ArrayList<Feature>();

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getHitDice() {
        return hitDice;
    }
    public int getSpeed(){return speed;}

    public String getSize() {
        return size;
    }


    public String getSubtype() {
        return subtype;
    }

    public String getType() {
        return type;
    }


    public Proficiency getProficiency() {
        return proficiency;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String getBackground() {
        return background;
    }

    @Override
    public Proficiency getProficiencies() {
        return proficiency;
    }


    public ArrayList<String> getSpellsKnown() {
        return spellsKnown;
    }

    @Override
    public ArrayList<Feature> getFeatures() {
        return features;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void addHitDice(int hitDie) {
        this.hitDice.add(hitDie);
    }

    @Override
    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public void setLevel(int Level) {
        this.level = level;
    }

    @Override
    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    @Override
    public void setBackground(String background) {
        this.background = background;
    }
    @Override
    public void addSpell(String newSpell) {
        this.spellsKnown.add(newSpell);
    }
    public void setSpeed(int speed){this.speed = speed;}

    public void setDndClass(String dndClass) {
        DndClass = dndClass;
    }
    public String getDndClass() {
        return DndClass;
    }

    @Override
    public void setType(String type) {this.type = type;}

    @Override
    public void addFeature(Feature newFeature) {
        this.features.add(newFeature);
    }

    public void addFeatures(ArrayList<Feature> features) {
        this.features.addAll(features);
    }
    public void getClass(String name){
        ClassTracker tracker = new ClassTracker();
        MyDndClass choice = tracker.getClass(name);
        this.setDndClass(choice.getName());
        this.proficiency.setSkillProficiencies(choice.getSkillProficiency(), true);
        this.proficiency.addToolProficiencies(choice.getToolProficiency());
        this.proficiency.addWeaponProficiencies(choice.getWeaponProficiency());
        this.proficiency.setArmorProficiencies(choice.getArmorProficiency(), true);
    }
    public void getBackground(String name){
        BackgroundTracker tracker = new BackgroundTracker();
        Background choice = tracker.getBackground(name);
        this.setBackground(choice.getName());
        this.addFeatures(choice.getFeatures());
        this.proficiency.setSkillProficiencies(choice.getSkillProficiency(), true);
        this.proficiency.addToolProficiencies(choice.getToolProficiency());
        this.proficiency.addWeaponProficiencies(choice.getWeaponProficiency());
        this.proficiency.setArmorProficiencies(choice.getArmorProficiency(), true);
    }
    public void getRace(String name){
        RaceTracker tracker = new RaceTracker();
        Race choice = tracker.getRace(name);
        this.setSubtype(choice.getName());
        this.setSize(choice.getSize());
        this.setSpeed(choice.getSpeed());
        this.addFeatures(choice.getFeatures());
        this.proficiency.setSkillProficiencies(choice.getSkillProficiency(), true);
        this.proficiency.addToolProficiencies(choice.getToolProficiency());
        this.proficiency.addWeaponProficiencies(choice.getWeaponProficiency());
        this.proficiency.setArmorProficiencies(choice.getArmorProficiency(), true);
    }
    public Player2(PlayerCreator a) {
        this.setType("Humanoid");
        this.setLevel(1);
        this.setName(a.name);
        this.getClass(a.getdndclass());
        this.getBackground(a.getbackground());
        this.getRace(a.getrace());
    }

}
