package interface_adapter.dnd_class;

import use_case.dnd_class.ClassInputBoundary;

public class ClassController {

    final ClassInputBoundary classUseCaseInteractor;
    public ClassController(ClassInputBoundary classUseCaseInteractor) {
        this.classUseCaseInteractor = classUseCaseInteractor;
    }

    public void execute() {
        classUseCaseInteractor.execute();
    }
}


