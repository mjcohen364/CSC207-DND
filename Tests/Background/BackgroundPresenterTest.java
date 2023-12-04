package Background;


import interface_adapter.ViewManagerModel;
import interface_adapter.background.BackgroundPresenter;
import interface_adapter.background.BackgroundViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.background.BackgroundOutputData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BackgroundPresenterTest {

    private BackgroundPresenter backgroundPresenter;
    private ViewManagerModel viewManagerModel;
    private BackgroundViewModel backgroundViewModel;

    @BeforeEach
    void setUp() {
        viewManagerModel = new ViewManagerModel(); // Replace with real or test implementation
        backgroundViewModel = new BackgroundViewModel(); // Replace with real or test implementation
        backgroundPresenter = new BackgroundPresenter(viewManagerModel, backgroundViewModel);
    }

    @Test
    void testPrepareSuccessView() {
        ArrayList<String> backgrounds = new ArrayList<String>();
        BackgroundOutputData response = new BackgroundOutputData(backgrounds, "Acolyte");
        backgroundPresenter.prepareSuccessView(response);

        assertNotNull(backgroundViewModel.getState().backgrounds, "Backgrounds should be set in the view model");
        assertEquals(response.getSelected(), backgroundViewModel.getState().selected, "Selected background should match the response");

        // Additionally, verify if the active view is correctly set in viewManagerModel
        assertEquals(backgroundViewModel.getViewName(), viewManagerModel.getActiveView(), "Active view should be set to background view");
    }

    // Additional tests for prepareFailView or other scenarios...
}
