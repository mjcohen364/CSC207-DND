package use_case;

public interface ItemOutputBoundary {
    void prepareSuccessView(ItemOutputData user);

    void prepareFailView(String error);
}