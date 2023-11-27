package use_case.desc;
import data_access.DataAccessObject;

public class DescInteractor implements DescInputBoundary {
    final DataAccessObject dataAccessObject;
    final DescOutputBoundary descPresenter;
    public DescInteractor(DataAccessObject dataAccessObject, DescOutputBoundary descOutputBoundary) {
        this.dataAccessObject = dataAccessObject;
        descPresenter = descOutputBoundary;
    }
    @Override
    public void execute(DescInputData descInputData) {
        String desc = dataAccessObject.getDescription(descInputData.getApi());
        descPresenter.prepareSuccessView(new DescOutputData(desc));
    }
}
