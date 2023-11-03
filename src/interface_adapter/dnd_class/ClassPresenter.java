package interface_adapter.dnd_class;

import use_case.dnd_class.ClassOutputBoundary;
import use_case.dnd_class.ClassOutputData;

public class ClassPresenter implements ClassOutputBoundary {

    private final ClassViewModel classViewModel;

    public ClassPresenter(ClassViewModel classViewModel) {
        this.classViewModel = classViewModel;
    }

    @Override
    public void prepareSuccessView(ClassOutputData response) {
        ClassState classState = classViewModel.getState();
        classState.classes = response.getClasses();
        classViewModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {

    }
}
