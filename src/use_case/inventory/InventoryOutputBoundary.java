package use_case.inventory;

public interface InventoryOutputBoundary {
    void prepareSuccessView(InventoryOutputData user);

    void prepareFailView(String error);
}