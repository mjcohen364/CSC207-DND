package use_case.inventory;


import data_access.DataAccessObject;

import java.util.ArrayList;

public class InventoryInteractor implements InventoryInputBoundary {
    final DataAccessObject dataAccessObject;

    final InventoryOutputBoundary itemPresenter;

    public InventoryInteractor(DataAccessObject dataAccessO,
                               InventoryOutputBoundary inventoryOutputBoundary) {
        this.dataAccessObject = dataAccessO;
        itemPresenter = inventoryOutputBoundary;
    }
    @Override
    public void execute(InventoryInputData inventoryInputData) {
        dataAccessObject.chooseClass(inventoryInputData.getApi());

        ArrayList<String> items = new ArrayList<>();
        for (var item: dataAccessObject.itemsFromClass) {
            items.add(item.Name);
        }

        itemPresenter.prepareSuccessView(new InventoryOutputData(items));

    }

}