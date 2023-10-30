package use_case.clear_users;

// TODO Complete me seems good

import java.util.Set;

public class ClearOutputData {
    private Set usernames;

    private String creationTime;

    private boolean useCaseFailed;

    public ClearOutputData(Set usernames, String creationTime, boolean useCaseFailed) {
        this.usernames = usernames;
        this.creationTime = creationTime;
        this.useCaseFailed = useCaseFailed;
    }

    public Set getUsernames() {
        return usernames;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

}
