package entity;

public class DndAttribute {
    String name;
    int value;
    int modifier;
    public void init(String name, int value){
        this.name = name;
        this.value = value;
        this.modifier = (int) ((value-10)/2);
    }
    public void update(int value){
        this.value = value;
        this.modifier = (int) ((value-10)/2);
    }
    public String getName(){
        return this.name;
    }
    public int getModifier(){
        return this.modifier;
    }
}
