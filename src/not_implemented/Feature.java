package not_implemented;

public class Feature {
    String name;
    String description;
    String source;

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public Feature(String name, String description, String source) {
        this.setName(name);
        this.setDescription(description);
        this.setSource(source);
    }
}
