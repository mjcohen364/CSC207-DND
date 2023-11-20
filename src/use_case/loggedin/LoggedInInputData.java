package use_case.loggedin;

public class LoggedInInputData {

    final private String username;
    final private String password;

    public LoggedInInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

}
