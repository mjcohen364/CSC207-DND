import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.armour_class.ArmourClassInputData;
import use_case.armour_class.ArmourClassInteractor;
import use_case.armour_class.ArmourClassOutputBoundary;
import use_case.armour_class.ArmourClassOutputData;

import static org.junit.jupiter.api.Assertions.*;

public class ArmourClassInteractorTest {

    private ArmourClassInteractor interactor;
    private StubArmourClassOutputBoundary outputBoundary;

    private static class StubArmourClassOutputBoundary implements ArmourClassOutputBoundary {
        ArmourClassOutputData receivedOutputData;

        @Override
        public void presentArmourClassResult(ArmourClassOutputData outputData) {
            this.receivedOutputData = outputData;
        }
    }

    @BeforeEach
    void setUp() {
        outputBoundary = new StubArmourClassOutputBoundary();
        interactor = new ArmourClassInteractor(outputBoundary);
    }

    @Test
    void testCalculateArmourClass() {
        ArmourClassInputData inputData = new ArmourClassInputData(10, 2);
        interactor.calculateArmourClass(inputData);

        assertNotNull(outputBoundary.receivedOutputData);
        assertEquals(12, outputBoundary.receivedOutputData.getTotalArmourClass());
    }
}
