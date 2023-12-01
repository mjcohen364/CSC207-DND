package entity;

import entity.Item;
import entity.Language;
import entity.Proficiency;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Background {
    private String index;
    private String name;
    private List<Proficiency> startingProficiencies;
    private List<Language> languages;
    private String languageDesc;
    ArrayList<Item> backgroundEquipment = new ArrayList<Item>();
    private HashMap<String, Object> feature = new HashMap<String, Object>();
    private HashMap<String, Object> personalityTraits = new HashMap<String, Object>();
    private HashMap<String, Object> ideals = new HashMap<String, Object>();
    private HashMap<String, Object> bonds = new HashMap<String, Object>();
    private HashMap<String, Object> flaws = new HashMap<String, Object>();
    public Background() {

    }
    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Proficiency> getStartingProficiencies() {
        return startingProficiencies;
    }

    public void setStartingProficiencies(List<Proficiency> startingProficiencies) {
        this.startingProficiencies = startingProficiencies;
    }
    public List<Language> getLanguages() {
        return languages;
    }
    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }
    public String getLanguageDesc() {
        return languageDesc;
    }
    public void setLanguageDesc(String languageDesc) {
        this.languageDesc = languageDesc;
    }

    public ArrayList<Item> getBackgroundEquipment() {
        return backgroundEquipment;
    }

    public void setBackgroundEquipment(ArrayList<Item> backgroundEquipment) {
        this.backgroundEquipment = backgroundEquipment;
    }

    public HashMap<String, Object> getFeature() {
        return feature;
    }

    public void setFeature(HashMap<String, Object> feature) {
        this.feature = feature;
    }

    public HashMap<String, Object> getPersonalityTraits() {
        return personalityTraits;
    }

    public void setPersonalityTraits(HashMap<String, Object> personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    public HashMap<String, Object> getIdeals() {
        return ideals;
    }

    public void setIdeals(HashMap<String, Object> ideals) {
        this.ideals = ideals;
    }

    public HashMap<String, Object> getBonds() {
        return bonds;
    }

    public void setBonds(HashMap<String, Object> bonds) {
        this.bonds = bonds;
    }

    public HashMap<String, Object> getFlaws() {
        return flaws;
    }

    public void setFlaws(HashMap<String, Object> flaws) {
        this.flaws = flaws;
    }
}
