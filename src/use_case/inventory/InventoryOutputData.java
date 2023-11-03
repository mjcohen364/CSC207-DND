package use_case.inventory;

import java.util.ArrayList;

public class InventoryOutputData {

    private final ArrayList<String> items;

    public InventoryOutputData(ArrayList<String> items) {
        this.items = items;
    }

    public ArrayList<String> getItems() {
        return items;
    }
}
