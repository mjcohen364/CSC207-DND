package interface_adapter.inventory;

import java.util.ArrayList;

public class InventoryState {


    public ArrayList<String> items;
    public String classApi;

    public InventoryState(InventoryState copy) {
        this.items = copy.items;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public InventoryState() {
    }

    @Override
    public String toString() {
        return "";
    }
}
