package Background;

import data_access.DataAccessObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.background.BackgroundInteractor;
import use_case.background.BackgroundOutputBoundary;
import use_case.background.BackgroundOutputData;

import static org.junit.jupiter.api.Assertions.*;

class BackgroundInteractorTest {

    private BackgroundInteractor backgroundInteractor;
    private DataAccessObject dataAccessObject;
    private BackgroundOutputBoundaryStub backgroundPresenter;

    @BeforeEach
    void setUp() {
        dataAccessObject = new DataAccessObject(); // test implementation
        backgroundPresenter = new BackgroundOutputBoundaryStub();
        backgroundInteractor = new BackgroundInteractor(dataAccessObject, backgroundPresenter);
    }

    @Test
    void testExecute() {
        backgroundInteractor.execute();

        assertNotNull(backgroundPresenter.outputData, "Output data should be set in presenter");

    }

    // Stub for ClassOutputBoundary for testing purposes
    static class BackgroundOutputBoundaryStub implements BackgroundOutputBoundary {
        BackgroundOutputData outputData;

        @Override
        public void prepareSuccessView(BackgroundOutputData data) {
            this.outputData = data;
        }

        @Override
        public void prepareFailView(String error) {

        }

    }
}
