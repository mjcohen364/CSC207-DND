package use_case.clear_users;

// TODO Complete me seems good

import entity.UserFactory;

import java.time.LocalDateTime;
import java.util.Set;


public class ClearInteractor implements ClearInputBoundary{
    final ClearUserDataAccessInterface clearUserDataAccessObject;
    final ClearOutputBoundary userPresenter;
    final UserFactory userFactory;

    public ClearInteractor(ClearUserDataAccessInterface clearUserDataAccessObject,
                            ClearOutputBoundary clearOutputBoundary,
                            UserFactory userFactory) {
        this.clearUserDataAccessObject = clearUserDataAccessObject;
        this.userPresenter = clearOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(ClearInputData clearInputData) {
        LocalDateTime now = LocalDateTime.now();

        Set usernames = clearUserDataAccessObject.clear();

        ClearOutputData clearOutputData = new ClearOutputData(usernames, now.toString(), false);
        userPresenter.prepareSuccessView(clearOutputData);
    }
}
