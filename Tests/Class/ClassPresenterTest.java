package Class;


import interface_adapter.ViewManagerModel;
import interface_adapter.dnd_class.ClassPresenter;
import interface_adapter.dnd_class.ClassViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.dnd_class.ClassOutputData;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClassPresenterTest {

    private ClassPresenter classPresenter;
    private ViewManagerModel viewManagerModel;
    private ClassViewModel classViewModel;

    @BeforeEach
    void setUp() {
        viewManagerModel = new ViewManagerModel(); // Replace with real or test implementation
        classViewModel = new ClassViewModel(); // Replace with real or test implementation
        classPresenter = new ClassPresenter(viewManagerModel, classViewModel);
    }

    @Test
    void testPrepareSuccessView() {
        ArrayList<String> classes = new ArrayList<String>();
        classes.add("Monk");
        classes.add("Wizard");
        ClassOutputData response = new ClassOutputData(classes, "Wiard");
        classPresenter.prepareSuccessView(response);

        assertNotNull(classViewModel.getState().classes, "Classes should be set in the view model");
        assertEquals(response.getSelected(), classViewModel.getState().selected, "Selected class should match the response");

        // Additionally, verify if the active view is correctly set in viewManagerModel
        assertEquals(classViewModel.getViewName(), viewManagerModel.getActiveView(), "Active view should be set to class view");
    }

    // Additional tests for prepareFailView or other scenarios...
}
