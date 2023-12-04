package race;



import interface_adapter.ViewManagerModel;
import interface_adapter.race.RacePresenter;
import interface_adapter.race.RaceViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.race.RaceOutputData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RacePresenterTest {

    private RacePresenter racePresenter;
    private ViewManagerModel viewManagerModel;
    private RaceViewModel raceViewModel;

    @BeforeEach
    void setUp() {
        viewManagerModel = new ViewManagerModel(); // Replace with real or test implementation
        raceViewModel = new RaceViewModel(); // Replace with real or test implementation
        racePresenter = new RacePresenter(viewManagerModel, raceViewModel);
    }

    @Test
    void testPrepareSuccessView() {
        ArrayList<String> races = new ArrayList<String>();
        races.add("Human");
        races.add("Tiefling");
        RaceOutputData response = new RaceOutputData(races, "Human");
        racePresenter.prepareSuccessView(response);

        assertNotNull(raceViewModel.getState().races, "Races should be set in the view model");
        assertEquals(response.getSelected(), raceViewModel.getState().selected, "Selected race should match the response");

        // Additionally, verify if the active view is correctly set in viewManagerModel
        assertEquals(raceViewModel.getViewName(), viewManagerModel.getActiveView(), "Active view should be set to race view");
    }

    // Additional tests for prepareFailView or other scenarios...
}
