package use_case.race_desc;
import data_access.DataAccessObject;
import entity.Race;
import entity.Trait;

public class RaceDescInteractor implements RaceDescInputBoundary {
    final RaceDetailsHelper raceDetailsHelper = new RaceDetailsHelper();
    final RaceDescOutputBoundary descPresenter;
    public RaceDescInteractor(RaceDescOutputBoundary raceDescOutputBoundary) {
        descPresenter = raceDescOutputBoundary;
    }
    @Override
    public void execute(RaceDescInputData raceDescInputData) {
        Race race = raceDetailsHelper.getRaceDetails(raceDescInputData.getApi());
        StringBuilder traits = new StringBuilder();
        for (Trait trait : race.getTraits()) {
            traits.append(trait.getName() + ", ");
            traits.deleteCharAt(traits.length()-1);
            traits.deleteCharAt(traits.length()-1);
        }
        String desc = "<html>Name: " + race.getName() +
                "<br/>Speed: " + race.getSpeed() +
                "<br/>Age: " + race.getAge() +
                "<br/>Alignment: " + race.getAlignment() +
                "<br/>Size: " + race.getSize() + ", " + race.getSizeDescription() +
                "<br/>Traits: " + traits +
                "</html>";
        descPresenter.prepareSuccessView(new RaceDescOutputData(desc));
    }
}
