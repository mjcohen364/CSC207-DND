package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import entity.AllOptions.Races.Race;
import entity.AllOptions.Races.RaceTracker;
import not_implemented.*;

public class Player2 implements Character2 {
    String name;
    ArrayList<Integer> hitDice = new ArrayList<>();
    int speed;
    String size;
    int level;
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

    @Override
    public void setType(String type) {this.type = type;}

    @Override
    public void addFeature(Feature newFeature) {
        this.features.add(newFeature);
    }

    public void addFeatures(ArrayList<Feature> features) {
        this.features.addAll(features);
    }
    public void getClass(String classname){

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
    }
    public void getBackground(String name){

    }
    public Player2(PlayerCreator a) {
        this.setType("Humanoid");
        this.setName(a.name);
        this.getRace(a.getrace());
    }

}
