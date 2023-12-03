package use_case.dnd_class;


import data_access.DataAccessObject;

public class ClassInteractor implements ClassInputBoundary {
    final DataAccessObject dataAccessObject;

    final ClassOutputBoundary classPresenter;

    public ClassInteractor(DataAccessObject dataAccessO,
                           ClassOutputBoundary classOutputBoundary) {
        this.dataAccessObject = dataAccessO;
        classPresenter = classOutputBoundary;
    }
    @Override
    public void execute() {
        var test = dataAccessObject.getClasses();
        classPresenter.prepareSuccessView(new ClassOutputData(test, dataAccessObject.player.getdndclass()));

    }

}