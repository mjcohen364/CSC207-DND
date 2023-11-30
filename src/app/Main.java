package app;

import data_access.DataAccessObject;

import interface_adapter.*;
import interface_adapter.background.BackgroundController;
import interface_adapter.background.BackgroundPresenter;
import interface_adapter.background.BackgroundViewModel;
import interface_adapter.character_creator.CharacterCreatorController;
import interface_adapter.character_creator.CharacterCreatorPresenter;
import interface_adapter.character_creator.CharacterCreatorViewModel;
import interface_adapter.desc.DescController;
import interface_adapter.desc.DescPresenter;
import interface_adapter.desc.DescViewModel;
import interface_adapter.dnd_class.ClassController;
import interface_adapter.dnd_class.ClassPresenter;
import interface_adapter.dnd_class.ClassViewModel;
import interface_adapter.inventory.InventoryController;
import interface_adapter.inventory.InventoryPresenter;
import interface_adapter.inventory.InventoryViewModel;
import interface_adapter.race.RaceController;
import interface_adapter.race.RacePresenter;
import interface_adapter.race.RaceViewModel;
import use_case.character_creator.CharacterCreatorInteractor;
import use_case.desc.DescInteractor;
import use_case.dnd_class.ClassInteractor;
import use_case.inventory.InventoryInteractor;
import use_case.race.RaceInteractor;
import use_case.background.BackgroundInteractor;
import view.*;

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
        DescViewModel descViewModel = new DescViewModel();
        ClassViewModel classViewModel = new ClassViewModel();
        RaceViewModel raceViewModel = new RaceViewModel();
        BackgroundViewModel backgroundViewModel = new BackgroundViewModel();
        CharacterCreatorViewModel characterCreatorViewModel = new CharacterCreatorViewModel();

        DataAccessObject dataAccessObject;

        dataAccessObject = new DataAccessObject();
        ChooseBackgroundView chooseBackgroundView =
                new ChooseBackgroundView(new CharacterCreatorController(new CharacterCreatorInteractor(dataAccessObject,
                        new CharacterCreatorPresenter(viewManagerModel, characterCreatorViewModel))), backgroundViewModel);
        ChooseClassView chooseClassView =
                new ChooseClassView(new InventoryController(new InventoryInteractor(dataAccessObject,
                        new InventoryPresenter(inventoryViewModel))), inventoryViewModel,
                        new CharacterCreatorController(new CharacterCreatorInteractor(dataAccessObject,
                        new CharacterCreatorPresenter(viewManagerModel, characterCreatorViewModel))), classViewModel);
        ChooseRaceView chooseRaceView =
                new ChooseRaceView(new DescController(new DescInteractor(dataAccessObject,
                        new DescPresenter(descViewModel))), descViewModel,
                        new CharacterCreatorController(new CharacterCreatorInteractor(dataAccessObject,
                        new CharacterCreatorPresenter(viewManagerModel, characterCreatorViewModel))), raceViewModel);


        CharacterCreatorView characterCreatorView = new CharacterCreatorView(new InventoryController(new InventoryInteractor(dataAccessObject, new InventoryPresenter(inventoryViewModel))),
                inventoryViewModel,
                new ClassController(new ClassInteractor(dataAccessObject, new ClassPresenter(viewManagerModel, classViewModel))),
                classViewModel,
                new RaceController(new RaceInteractor(dataAccessObject, new RacePresenter(viewManagerModel, raceViewModel))),
                raceViewModel,
                new BackgroundController(new BackgroundInteractor(dataAccessObject, new BackgroundPresenter(viewManagerModel, backgroundViewModel))),
                backgroundViewModel);
        //viewManagerModel
        views.add(characterCreatorView, characterCreatorView.viewName);
        views.add(chooseBackgroundView, chooseBackgroundView.viewName);
        views.add(chooseClassView, chooseClassView.viewName);
        views.add(chooseRaceView, chooseRaceView.viewName);




        viewManagerModel.setActiveView(characterCreatorView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}