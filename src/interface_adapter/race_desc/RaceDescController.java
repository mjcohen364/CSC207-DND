package interface_adapter.race_desc;
import use_case.race_desc.RaceDescInputBoundary;
import use_case.race_desc.RaceDescInputData;

public class RaceDescController {
    final RaceDescInputBoundary descUseCaseInteractor;
    public RaceDescController(RaceDescInputBoundary descUseCaseInteractor) {
        this.descUseCaseInteractor = descUseCaseInteractor;
    }
    public void execute(String api) {
        RaceDescInputData raceDescInputData = new RaceDescInputData(api);

        descUseCaseInteractor.execute(raceDescInputData);
    }
}
