package interface_adapter.inventory;

import use_case.inventory.InventoryInputBoundary;
import use_case.inventory.InventoryInputData;

public class InventoryController {

    final InventoryInputBoundary inventoryUseCaseInteractor;
    public InventoryController(InventoryInputBoundary inventoryUseCaseInteractor) {
        this.inventoryUseCaseInteractor = inventoryUseCaseInteractor;
    }

    public void execute(String api) {
        InventoryInputData inventoryInputData = new InventoryInputData(api);

        inventoryUseCaseInteractor.execute(inventoryInputData);
    }
}


