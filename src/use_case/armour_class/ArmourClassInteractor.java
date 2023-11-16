package use_case.armour_class;

public class ArmourClassInteractor implements ArmourClassInputBoundary{
    private ArmourClassOutputBoundary outputBoundary;

    public ArmourClassInteractor(ArmourClassOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void calculateArmourClass(ArmourClassInputData inputData) {
        int baseArmourClass = inputData.getBaseArmourClass();
        int additionalModifiers = inputData.getAdditionalModifiers();
        int totalArmourClass = baseArmourClass + additionalModifiers; // Business logic for calculating total armour class

        ArmourClassOutputData outputData = new ArmourClassOutputData(totalArmourClass);
        outputBoundary.presentArmourClassResult(outputData);
    }
}
