package interface_adapter;

import use_case.ItemInputBoundary;
import use_case.ItemInputData;

public class ItemController {

    final ItemInputBoundary itemUseCaseInteractor;
    public ItemController(ItemInputBoundary itemUseCaseInteractor) {
        this.itemUseCaseInteractor = itemUseCaseInteractor;
    }

    public void execute(String api) {
        ItemInputData itemInputData = new ItemInputData(api);

        itemUseCaseInteractor.execute(itemInputData);
    }
}


