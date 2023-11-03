package use_case.dnd_class;

import java.util.ArrayList;

public class ClassOutputData {
    private final ArrayList<String> classes = new ArrayList<>();

    public ClassOutputData(ArrayList<String> classes) {
        this.classes.addAll(classes);
    }

    public ArrayList<String> getClasses() {
        return classes;
    }
}
