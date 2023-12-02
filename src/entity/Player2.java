package entity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import not_implemented.*;

public class Player2 implements Character2 {
    String name;
    Map<String, Integer> attributes = new HashMap<>();
    Inventory inventory;
    ArrayList<Integer> hitDice = new ArrayList<>();
    int hitPoints;
    int armourClass;
    String size;
    int level;
    Map<String, Integer> classList = new HashMap<>();
    String subtype;
    String type;
    String background;
    Proficiency proficiency;
    ArrayList<String> spellsKnown = new ArrayList<>();
    ArrayList<Feature> features = new ArrayList<Feature>();

    public String getName() {
        return name;
    }

    public Map<String, Integer> getAttributes() {
        return attributes;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ArrayList<Integer> getHitDice() {
        return hitDice;
    }

    public int getArmourClass() {
        return armourClass;
    }

    public String getSize() {
        return size;
    }

    public Map<String, Integer> getClassList() {
        return classList;
    }

    public String getSubtype() {
        return subtype;
    }

    public String getType() {
        return type;
    }

    public int getHitPoints() {
        return hitPoints;
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

    @Override
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
    public void setAttribute(String attribute, int value) {this.attributes.put(attribute, value);}

    @Override
    public void addItem(Item newItem) {
        this.inventory.add(newItem);
    }
    @Override
    public void addHitDice(int hitDie) {
        this.hitDice.add(hitDie);
    }
    @Override
    public void setArmourClass(int armourClass) {
        this.armourClass = armourClass;
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
    public void addDndClass(String newClass) {
        Map<String, Integer> a = this.classList;
        if (a.containsKey(newClass)) {
            this.classList.put(newClass, this.classList.get(newClass) + 1);
        }
        else {this.classList.put(newClass, 1);}
    }
    @Override
    public void setBackground(String background) {
        this.background = background;
    }
    @Override
    public void addSpell(String newSpell) {
        this.spellsKnown.add(newSpell);
    }

    @Override
    public void addFeature(Feature newFeature) {
        this.features.add(newFeature);
    }
    public void generatejson() throws IOException {
        Gson g = new Gson();
        //File myObj = new File(this.name + ".txt");
        FileWriter myWriter = new FileWriter(this.name + ".txt");
        myWriter.write(g.toJson(this));
        myWriter.close();
    }

    public void initFromjson(String path) {

    }
}