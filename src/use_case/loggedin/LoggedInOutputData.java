package use_case.loggedin;

public class LoggedInOutputData {

    private final String username;
    private boolean useCaseFailed;

    public LoggedInOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

}
