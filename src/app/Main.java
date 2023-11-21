package app;

import data_access.DataAccessObject;

import interface_adapter.*;
import interface_adapter.dnd_class.ClassController;
import interface_adapter.dnd_class.ClassPresenter;
import interface_adapter.dnd_class.ClassViewModel;
import interface_adapter.inventory.InventoryController;
import interface_adapter.inventory.InventoryPresenter;
import interface_adapter.inventory.InventoryViewModel;
import interface_adapter.race.RaceController;
import interface_adapter.race.RaceViewModel;
import use_case.dnd_class.ClassInteractor;
import use_case.inventory.InventoryInteractor;
import view.CharacterCreatorView;

import view.ViewManager;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Character Creator");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        InventoryViewModel inventoryViewModel = new InventoryViewModel();
        ClassViewModel classViewModel = new ClassViewModel();



        DataAccessObject dataAccessObject;

        dataAccessObject = new DataAccessObject();
        RaceViewModel raceViewModel = new RaceViewModel();
        RaceController raceController = new RaceController(raceViewModel, dataAccessObject);
        raceController.loadRaces(); // Load the races


        CharacterCreatorView characterCreatorView = new CharacterCreatorView(new InventoryController(new InventoryInteractor(dataAccessObject, new InventoryPresenter(inventoryViewModel))),
                inventoryViewModel,
                new ClassController(new ClassInteractor(dataAccessObject, new ClassPresenter(classViewModel))),
                classViewModel, raceController, raceViewModel);
        //viewManagerModel
        views.add(characterCreatorView, characterCreatorView.viewName);




        viewManagerModel.setActiveView(characterCreatorView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}