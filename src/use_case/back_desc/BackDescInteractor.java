package use_case.back_desc;

import entity.Background;

public class BackDescInteractor implements BackDescInputBoundary {
    final BackDetailsHelper backDetailsHelper = new BackDetailsHelper();
    final BackDescOutputBoundary backDescPresenter;
    public BackDescInteractor(BackDescOutputBoundary backDescOutputBoundary) {
        backDescPresenter = backDescOutputBoundary;
    }
    @Override
    public void execute(BackDescInputData backDescInputData) {
        Background back = backDetailsHelper.getBackDetails(backDescInputData.getApi());
        String desc = "<html>Name: " + back.getName() +
                "<br/>Feature: " + back.getFeature().get("name") + ". " +
                back.getFeature().get("desc").toString().substring(1, back.getFeature().get(
                        "desc").toString().length()-1).replace(
                                "\"", "").replace(".,", ".");
        backDescPresenter.prepareSuccessView(new BackDescOutputData(desc));
    }
}

