package use_case.background;
import data_access.DataAccessObject;

public class BackgroundInteractor implements BackgroundInputBoundary {
    final DataAccessObject dataAccessObject;
    final BackgroundOutputBoundary backgroundPresenter;
    public BackgroundInteractor(DataAccessObject dataAccess, BackgroundOutputBoundary backgroundOutputBoundary) {
        this.dataAccessObject = dataAccess;
        backgroundPresenter = backgroundOutputBoundary;
    }
    @Override
    public void execute() {
        var test = dataAccessObject.getBackgrounds();
        System.out.println(dataAccessObject.player.getbackground());
        backgroundPresenter.prepareSuccessView(new BackgroundOutputData(test, dataAccessObject.player.getbackground()));
    }
}
