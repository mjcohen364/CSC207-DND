package use_case.clear_users;

import entity.CharacterFactory;
import view.CharacterNameView;

import java.time.LocalDateTime;
import java.util.Set;


public class ClearInteractor implements ClearInputBoundary{
    final ClearUserDataAccessInterface clearUserDataAccessObject;
    final ClearOutputBoundary userPresenter;
    final CharacterFactory characterFactory;

    public ClearInteractor(ClearUserDataAccessInterface clearUserDataAccessObject,
                            ClearOutputBoundary clearOutputBoundary,
                            CharacterFactory characterFactory) {
        this.clearUserDataAccessObject = clearUserDataAccessObject;
        this.userPresenter = clearOutputBoundary;
        this.characterFactory = characterFactory;
    }

    @Override
    public void execute(ClearInputData clearInputData) {
        LocalDateTime now = LocalDateTime.now();

        Set usernames = clearUserDataAccessObject.clear();

        ClearOutputData clearOutputData = new ClearOutputData(usernames, now.toString(), false);
        userPresenter.prepareSuccessView(clearOutputData);
    }
}
