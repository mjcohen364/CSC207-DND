package use_case.dnd_class;

import java.util.ArrayList;

public class ClassOutputData {
    private final ArrayList<String> classes = new ArrayList<>();
    private String selected;

    public ClassOutputData(ArrayList<String> classes, String selected) {
        this.selected = selected;
        this.classes.addAll(classes);
    }

    public ArrayList<String> getClasses() {
        return classes;
    }
    public String getSelected() {return selected;}
}
