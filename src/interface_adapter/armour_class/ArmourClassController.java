package interface_adapter.armour_class;

import use_case.armour_class.ArmourClassInputBoundary;
import use_case.armour_class.ArmourClassInputData;

public class ArmourClassController {
    private final ArmourClassInputBoundary interactor;
    private final ArmourClassViewModel viewModel;

    public ArmourClassController(ArmourClassInputBoundary interactor, ArmourClassViewModel viewModel) {
        this.interactor = interactor;
        this.viewModel = viewModel;
    }

    public void calculateTotalArmourClass(int baseArmourClass, int additionalModifiers) {
        ArmourClassInputData inputData = new ArmourClassInputData(baseArmourClass, additionalModifiers);
        interactor.calculateArmourClass(inputData);
    }
}

