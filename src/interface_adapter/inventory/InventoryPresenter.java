package interface_adapter.inventory;

import use_case.inventory.InventoryOutputBoundary;
import use_case.inventory.InventoryOutputData;

public class InventoryPresenter implements InventoryOutputBoundary {

    private final InventoryViewModel inventoryViewModel;

    public InventoryPresenter(InventoryViewModel inventoryViewModel) {
        this.inventoryViewModel = inventoryViewModel;
    }

    @Override
    public void prepareSuccessView(InventoryOutputData response) {
        InventoryState inventoryState = inventoryViewModel.getState();
        inventoryState.items = response.getItems();
        inventoryViewModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {

    }
}
