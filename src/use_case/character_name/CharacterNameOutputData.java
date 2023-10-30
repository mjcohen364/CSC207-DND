package use_case.character_name;

public class CharacterNameOutputData {

    private final String name;
    private String creationTime;

    private boolean useCaseFailed;

    public CharacterNameOutputData(String name, String creationTime, boolean useCaseFailed) {
        this.name = name;
        this.creationTime = creationTime;
        this.useCaseFailed = useCaseFailed;
    }

    public String getName() {
        return name;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

}
