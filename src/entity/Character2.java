package entity;

import com.google.gson.Gson;
import not_implemented.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public interface Character2 {
    String getName();
    ArrayList<Integer> getHitDice();
    String getSize();
    String getSubtype();
    String getType();
    String getBackground();
    Proficiency getProficiencies();
    ArrayList<Feature> getFeatures();
    void setName(String name);
    void addHitDice(int hitDice);
    void setSize(String size);
    void setLevel(int level);
    void setSubtype(String subtype);
    void setBackground(String background);
    void addSpell(String newSpell);

    void setType(String type);

    void addFeature(Feature newFeature);

}