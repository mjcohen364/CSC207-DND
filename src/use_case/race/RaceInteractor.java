package use_case.race;
import data_access.DataAccessObject;
import use_case.dnd_class.ClassOutputBoundary;

public class RaceInteractor implements RaceInputBoundary {
    final DataAccessObject dataAccessObject;
    final RaceOutputBoundary racePresenter;
    public RaceInteractor(DataAccessObject dataAccess, RaceOutputBoundary raceOutputBoundary) {
        this.dataAccessObject = dataAccess;
        racePresenter = raceOutputBoundary;
    }
    @Override
    public void execute() {
        var test = dataAccessObject.getRaces();
        racePresenter.prepareSuccessView(new RaceOutputData(test));
    }
}
