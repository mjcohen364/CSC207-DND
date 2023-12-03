package interface_adapter.dnd_class;

import java.util.ArrayList;

public class ClassState {


    public ArrayList<String> classes;
    public String selected;

    public ClassState(ClassState copy) {

        this.classes = copy.classes;
        this.selected = copy.selected;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public ClassState() {
    }


    @Override
    public String toString() {
        return "idk";
    }
}
