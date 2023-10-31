package interface_adapter;

import interface_adapter.login.LoginState;
import use_case.ItemOutputBoundary;
import use_case.ItemOutputData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ItemPresenter implements ItemOutputBoundary {

    private final ItemViewModel itemViewModel;

    public ItemPresenter(ItemViewModel itemViewModel) {
        this.itemViewModel = itemViewModel;
    }

    @Override
    public void prepareSuccessView(ItemOutputData response) {
        ItemState itemState = itemViewModel.getState();
        itemState.setName(response.getName());
        itemState.setQuantity(response.getQuantity());
        itemViewModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {

    }
}
