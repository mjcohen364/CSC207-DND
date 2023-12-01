package app;

import data_access.DataAccessObject;

import data_access.FileCharacterDataAccessObject;
import entity.PlayerFactory;
import interface_adapter.*;
import interface_adapter.background.BackgroundController;
import interface_adapter.background.BackgroundPresenter;
import interface_adapter.background.BackgroundViewModel;
import interface_adapter.character_creator.CharacterCreatorController;
import interface_adapter.character_creator.CharacterCreatorPresenter;
import interface_adapter.character_creator.CharacterCreatorViewModel;
import interface_adapter.character_name.CharacterNameController;
import interface_adapter.character_name.CharacterNamePresenter;
import interface_adapter.character_name.CharacterNameViewModel;
import interface_adapter.clear_characters.ClearController;
import interface_adapter.clear_characters.ClearPresenter;
import interface_adapter.clear_characters.ClearViewModel;
import interface_adapter.race_desc.RaceDescController;
import interface_adapter.race_desc.RaceRaceDescPresenter;
import interface_adapter.race_desc.RaceDescViewModel;
import interface_adapter.dnd_class.ClassController;
import interface_adapter.dnd_class.ClassPresenter;
import interface_adapter.dnd_class.ClassViewModel;
import interface_adapter.inventory.InventoryController;
import interface_adapter.inventory.InventoryPresenter;
import interface_adapter.inventory.InventoryViewModel;
import interface_adapter.logged_in.LoggedInController;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.race.RaceController;
import interface_adapter.race.RacePresenter;
import interface_adapter.race.RaceViewModel;
import interface_adapter.return_to_name.ReturnToNameController;
import interface_adapter.return_to_name.ReturnToNamePresenter;
import interface_adapter.return_to_name.ReturnToNameViewModel;
import use_case.character_creator.CharacterCreatorInteractor;
import use_case.character_name.CharacterNameInteractor;
import use_case.clear_users.ClearInteractor;
import use_case.desc.RaceDescInteractor;
import use_case.dnd_class.ClassInteractor;
import use_case.inventory.InventoryInteractor;
import use_case.race.RaceInteractor;
import use_case.background.BackgroundInteractor;
import use_case.return_to_name.ReturnToNameInteractor;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
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
        RaceDescViewModel raceDescViewModel = new RaceDescViewModel();
        ClassViewModel classViewModel = new ClassViewModel();
        RaceViewModel raceViewModel = new RaceViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();
        BackgroundViewModel backgroundViewModel = new BackgroundViewModel();
        CharacterCreatorViewModel characterCreatorViewModel = new CharacterCreatorViewModel();
        CharacterNameViewModel characterNameViewModel = new CharacterNameViewModel();
        ClearViewModel clearViewModel = new ClearViewModel();
        ReturnToNameViewModel returnToNameViewModel = new ReturnToNameViewModel();

        DataAccessObject dataAccessObject;
        dataAccessObject = new DataAccessObject();
        CharacterCreatorController characterCreatorController = new CharacterCreatorController(new CharacterCreatorInteractor(dataAccessObject,
                new CharacterCreatorPresenter(viewManagerModel, characterCreatorViewModel)));
        PlayerFactory playerFactory = new PlayerFactory();
        CharacterNamePresenter characterNamePresenter = new CharacterNamePresenter(viewManagerModel,
                characterNameViewModel, loggedInViewModel);

        FileCharacterDataAccessObject fileCharacterDataAccessObject = new FileCharacterDataAccessObject("characters.csv", playerFactory);
        CharacterNameView characterNameView =
                new CharacterNameView(new CharacterNameController(new CharacterNameInteractor(fileCharacterDataAccessObject,
                        characterNamePresenter, playerFactory)),
                        characterCreatorController, characterNameViewModel,
                        new ClearController(new ClearInteractor(fileCharacterDataAccessObject,
                                new ClearPresenter(viewManagerModel, clearViewModel,
                                        characterNameViewModel), playerFactory)),
                        clearViewModel);
        ChooseBackgroundView chooseBackgroundView =
                new ChooseBackgroundView(characterCreatorController, backgroundViewModel);
        ChooseClassView chooseClassView =
                new ChooseClassView(new InventoryController(new InventoryInteractor(dataAccessObject,
                        new InventoryPresenter(inventoryViewModel))), inventoryViewModel,
                        characterCreatorController, classViewModel);
        ChooseRaceView chooseRaceView =
                new ChooseRaceView(new RaceDescController(new RaceDescInteractor(dataAccessObject,
                new RaceRaceDescPresenter(raceDescViewModel))), raceDescViewModel,
                        characterCreatorController, raceViewModel);


        CharacterCreatorView characterCreatorView = new CharacterCreatorView(new InventoryController(new InventoryInteractor(dataAccessObject, new InventoryPresenter(inventoryViewModel))),
                inventoryViewModel,
                new ClassController(new ClassInteractor(dataAccessObject, new ClassPresenter(viewManagerModel, classViewModel))),
                classViewModel,
                new RaceController(new RaceInteractor(dataAccessObject, new RacePresenter(viewManagerModel, raceViewModel))),
                raceViewModel,
                new LoggedInController(), loggedInViewModel,
                new BackgroundController(new BackgroundInteractor(dataAccessObject, new BackgroundPresenter(viewManagerModel, backgroundViewModel))),
                backgroundViewModel,
                new ReturnToNameController(new ReturnToNameInteractor(new ReturnToNamePresenter(viewManagerModel, returnToNameViewModel))));
        //viewManagerModel
        views.add(characterCreatorView, characterCreatorView.viewName);
        views.add(chooseBackgroundView, chooseBackgroundView.viewName);
        views.add(chooseClassView, chooseClassView.viewName);
        views.add(chooseRaceView, chooseRaceView.viewName);
        views.add(characterNameView, characterNameView.viewName);




        viewManagerModel.setActiveView(characterNameView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}