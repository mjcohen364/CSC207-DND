package use_case.desc;
import data_access.DataAccessObject;
import entity.Race;
import use_case.race.RaceDetailsInteractor;

public class RaceDescInteractor implements RaceDescInputBoundary {
    final RaceDetailsInteractor raceDetailsInteractor = new RaceDetailsInteractor();
    final RaceDescOutputBoundary descPresenter;
    public RaceDescInteractor(DataAccessObject dataAccessObject, RaceDescOutputBoundary raceDescOutputBoundary) {
        descPresenter = raceDescOutputBoundary;
    }
    @Override
    public void execute(RaceDescInputData raceDescInputData) {
        Race race = raceDetailsInteractor.getRaceDetails(raceDescInputData.getApi());
        String desc = "<html>Name: " + race.getName() +
                "<br/>Speed: " + race.getSpeed() +
                "<br/>Age: " + race.getAge() +
                "<br/>Alignment: " + race.getAlignment() +
                "<br/>Size :" + race.getSize() + ", " + race.getSizeDescription() +
                "</html>";
        descPresenter.prepareSuccessView(new RaceDescOutputData(desc));
    }
}
