package Class;

import data_access.DataAccessObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.dnd_class.ClassInteractor;
import use_case.dnd_class.ClassOutputBoundary;
import use_case.dnd_class.ClassOutputData;

import static org.junit.jupiter.api.Assertions.*;

class ClassInteractorTest {

    private ClassInteractor classInteractor;
    private DataAccessObject dataAccessObject;
    private ClassOutputBoundaryStub classPresenter;

    @BeforeEach
    void setUp() {
        dataAccessObject = new DataAccessObject(); // test implementation
        classPresenter = new ClassOutputBoundaryStub();
        classInteractor = new ClassInteractor(dataAccessObject, classPresenter);
    }

    @Test
    void testExecute() {
        classInteractor.execute();

        assertNotNull(classPresenter.outputData, "Output data should be set in presenter");

    }

    // Stub for ClassOutputBoundary for testing purposes
    static class ClassOutputBoundaryStub implements ClassOutputBoundary {
        ClassOutputData outputData;

        @Override
        public void prepareSuccessView(ClassOutputData data) {
            this.outputData = data;
        }

        @Override
        public void prepareFailView(String error) {

        }

    }
}