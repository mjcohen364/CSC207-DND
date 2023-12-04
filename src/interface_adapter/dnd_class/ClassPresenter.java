package interface_adapter.dnd_class;

import interface_adapter.ViewManagerModel;
import use_case.dnd_class.ClassOutputBoundary;
import use_case.dnd_class.ClassOutputData;

public class ClassPresenter implements ClassOutputBoundary {

    private final ClassViewModel classViewModel;
    private final ViewManagerModel viewManagerModel;

    public ClassPresenter(ViewManagerModel viewManagerModel,
                          ClassViewModel classViewModel) {
        this.classViewModel = classViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ClassOutputData response) {
        ClassState classState = classViewModel.getState();
        classState.classes = response.getClasses();
        classState.selected = response.getSelected();
        this.classViewModel.setState(classState);
        classViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(classViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}
