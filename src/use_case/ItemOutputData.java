package use_case;

public class ItemOutputData {

    private final String name;
    private final int quantity;

    public ItemOutputData(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
}
