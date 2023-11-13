package interface_adapter.race;
import use_case.race.RaceInputBoundary;

public class RaceController {
    final RaceInputBoundary raceUseCaseInteractor;
    public RaceController(RaceInputBoundary raceUseCaseInteractor) {
        this.raceUseCaseInteractor = raceUseCaseInteractor;
    }
    public void execute() {
        raceUseCaseInteractor.execute();
    }
}
