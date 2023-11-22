package entity;

import java.util.List;

public class Race {
    private String index;
    private String name;
    private int speed;
    private List<AbilityBonus> abilityBonuses;
    private String alignment;
    private String age;
    private String size;
    private String sizeDescription;
    private List<Proficiency> startingProficiencies;
    private ProficiencyOptions startingProficiencyOptions;
    private List<Language> languages;
    private String languageDesc;
    private List<Trait> traits;
    private List<Subrace> subraces;
    private String url;

    public Race(String index, String name, int speed, List<AbilityBonus> abilityBonuses, String alignment, String age, String size, String sizeDescription, List<Proficiency> startingProficiencies, ProficiencyOptions startingProficiencyOptions, List<Language> languages, String languageDesc, List<Trait> traits, List<Subrace> subraces, String url) {
        this.index = index;
        this.name = name;
        this.speed = speed;
        this.abilityBonuses = abilityBonuses;
        this.alignment = alignment;
        this.age = age;
        this.size = size;
        this.sizeDescription = sizeDescription;
        this.startingProficiencies = startingProficiencies;
        this.startingProficiencyOptions = startingProficiencyOptions;
        this.languages = languages;
        this.languageDesc = languageDesc;
        this.traits = traits;
        this.subraces = subraces;
        this.url = url;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public List<AbilityBonus> getAbilityBonuses() {
        return abilityBonuses;
    }

    public void setAbilityBonuses(List<AbilityBonus> abilityBonuses) {
        this.abilityBonuses = abilityBonuses;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSizeDescription() {
        return sizeDescription;
    }

    public void setSizeDescription(String sizeDescription) {
        this.sizeDescription = sizeDescription;
    }

    public List<Proficiency> getStartingProficiencies() {
        return startingProficiencies;
    }

    public void setStartingProficiencies(List<Proficiency> startingProficiencies) {
        this.startingProficiencies = startingProficiencies;
    }

    public ProficiencyOptions getStartingProficiencyOptions() {
        return startingProficiencyOptions;
    }

    public void setStartingProficiencyOptions(ProficiencyOptions startingProficiencyOptions) {
        this.startingProficiencyOptions = startingProficiencyOptions;
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

    public List<Trait> getTraits() {
        return traits;
    }

    public void setTraits(List<Trait> traits) {
        this.traits = traits;
    }

    public List<Subrace> getSubraces() {
        return subraces;
    }

    public void setSubraces(List<Subrace> subraces) {
        this.subraces = subraces;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
