package use_case;


import data_access.DataAccessObject;
import entity.Item;

public class ItemInteractor implements ItemInputBoundary {
    final DataAccessObject dataAccessObject;

    final ItemOutputBoundary itemPresenter;

    public ItemInteractor(DataAccessObject dataAccessO,
                          ItemOutputBoundary itemOutputBoundary) {
        this.dataAccessObject = dataAccessO;
        itemPresenter = itemOutputBoundary;
    }
    @Override
    public void execute(ItemInputData itemInputData) {
        Item test = dataAccessObject.get(itemInputData.getApi());

        itemPresenter.prepareSuccessView(new ItemOutputData(test.Name, test.CostQuantity));

    }

}