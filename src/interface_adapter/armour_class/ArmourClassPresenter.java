package interface_adapter.armour_class;

import use_case.armour_class.ArmourClassOutputBoundary;
import use_case.armour_class.ArmourClassOutputData;

public class ArmourClassPresenter implements ArmourClassOutputBoundary {
    private final ArmourClassViewModel viewModel;

    public ArmourClassPresenter(ArmourClassViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void presentArmourClassResult(ArmourClassOutputData outputData) {
        viewModel.setTotalArmourClass(outputData.getTotalArmourClass());
    }
}
