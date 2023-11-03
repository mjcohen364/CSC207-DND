package use_case.dnd_class;

public interface ClassOutputBoundary {
    void prepareSuccessView(ClassOutputData user);

    void prepareFailView(String error);
}