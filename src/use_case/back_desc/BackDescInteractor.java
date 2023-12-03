package use_case.back_desc;

import data_access.DataAccessObject;
import entity.Background;

public class BackDescInteractor implements BackDescInputBoundary {
    DataAccessObject dataAccessObject;
    final BackDetailsHelper backDetailsHelper = new BackDetailsHelper();
    final BackDescOutputBoundary backDescPresenter;
    public BackDescInteractor(BackDescOutputBoundary backDescOutputBoundary, DataAccessObject dataAccessObject) {
        backDescPresenter = backDescOutputBoundary;
        this.dataAccessObject = dataAccessObject;
    }
    @Override
    public void execute(BackDescInputData backDescInputData) {
        dataAccessObject.player.setbackground(backDescInputData.getApi());
        dataAccessObject.player.generatejson();
        Background back = backDetailsHelper.getBackDetails(backDescInputData.getApi());
        String desc = "<html>Name: " + back.getName() +
                "<br/>Feature: " + back.getFeature().get("name") + ". " +
                back.getFeature().get("desc").toString().substring(1, back.getFeature().get(
                        "desc").toString().length()-1).replace(
                                "\"", "").replace(".,", ".");
        backDescPresenter.prepareSuccessView(new BackDescOutputData(desc));
    }
}

