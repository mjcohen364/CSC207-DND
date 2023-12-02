package entity;

import com.google.gson.Gson;
import not_implemented.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public interface Character2 {
    String getName();
    Map<String, Integer> getAttributes();
    Inventory getInventory();
    ArrayList<Integer> getHitDice();
    int getArmourClass();
    String getSize();
    Map<String, Integer> getClassList();
    String getSubtype();
    String getType();
    String getBackground();
    Proficiency getProficiencies();
    ArrayList<String> getSpellsKnown();
    ArrayList<Feature> getFeatures();
    void setName(String name);
    void setAttribute(String attribute, int value);
    void addItem(Item newItem);
    void addHitDice(int hitDice);
    void setArmourClass(int armourClass);
    void setSize(String size);
    void setLevel(int level);
    void setSubtype(String subtype);
    void addDndClass(String newClass);
    void setBackground(String background);
    void addSpell(String newSpell);
    void addFeature(Feature newFeature);

}