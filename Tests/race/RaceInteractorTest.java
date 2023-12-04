package race;

import data_access.DataAccessObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.race.RaceInteractor;
import use_case.race.RaceOutputBoundary;
import use_case.race.RaceOutputData;

import static org.junit.jupiter.api.Assertions.*;

class RaceInteractorTest {

    private RaceInteractor raceInteractor;
    private DataAccessObject dataAccessObject;
    private RaceOutputBoundaryStub racePresenter;

    @BeforeEach
    void setUp() {
        dataAccessObject = new DataAccessObject(); // test implementation
        racePresenter = new RaceOutputBoundaryStub();
        raceInteractor = new RaceInteractor(dataAccessObject, racePresenter);
    }

    @Test
    void testExecute() {
        raceInteractor.execute();

        assertNotNull(racePresenter.outputData, "Output data should be set in presenter");

    }

    // Stub for RaceOutputBoundary for testing purposes
    static class RaceOutputBoundaryStub implements RaceOutputBoundary {
        RaceOutputData outputData;

        @Override
        public void prepareSuccessView(RaceOutputData data) {
            this.outputData = data;
        }

        @Override
        public void prepareFailView(String error) {

        }

    }
}
