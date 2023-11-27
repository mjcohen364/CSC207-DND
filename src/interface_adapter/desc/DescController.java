package interface_adapter.desc;
import use_case.desc.DescInputBoundary;
import use_case.desc.DescInputData;

public class DescController {
    final DescInputBoundary descUseCaseInteractor;
    public DescController(DescInputBoundary descUseCaseInteractor) {
        this.descUseCaseInteractor = descUseCaseInteractor;
    }
    public void execute(String api) {
        DescInputData descInputData = new DescInputData(api);

        descUseCaseInteractor.execute(descInputData);
    }
}
