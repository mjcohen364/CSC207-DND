package use_case.inventory;

public class InventoryInputData {
    final private String api;

    public InventoryInputData(String api) {
        this.api = api;
    }

    String getApi() {
        return api;
    }
}
