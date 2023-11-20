package interface_adapter.logged_in;

public class LoggedInState {
    private String name = "";

    public LoggedInState(LoggedInState copy) {
        name = copy.name;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {}

    public String getName() {
        return name;
    }
    public void setUsername(String username) {
        this.name = name;
    }
}
