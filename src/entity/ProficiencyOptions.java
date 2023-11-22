package entity;

import java.util.List;

public class ProficiencyOptions {
    private String desc;
    private int choose;
    private String type;
    private From from;

    public ProficiencyOptions(String desc, int choose, String type, From from) {
        this.desc = desc;
        this.choose = choose;
        this.type = type;
        this.from = from;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getChoose() {
        return choose;
    }

    public void setChoose(int choose) {
        this.choose = choose;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public static class From {
        private String optionSetType;
        private List<Option> options;

        // Getters and setters

        public From(String optionSetType, List<Option> options) {
            this.optionSetType = optionSetType;
            this.options = options;
        }

        public String getOptionSetType() {
            return optionSetType;
        }

        public void setOptionSetType(String optionSetType) {
            this.optionSetType = optionSetType;
        }

        public List<Option> getOptions() {
            return options;
        }

        public void setOptions(List<Option> options) {
            this.options = options;
        }
    }

    public static class Option {
        private String optionType;
        private Item item;

        public Option(String optionType, Item item) {
            this.optionType = optionType;
            this.item = item;
        }

        public String getOptionType() {
            return optionType;
        }

        public void setOptionType(String optionType) {
            this.optionType = optionType;
        }

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }
    }

    public static class Item {
        private String index;
        private String name;
        private String url;

        public Item(String index, String name, String url) {
            this.index = index;
            this.name = name;
            this.url = url;
        }

        public String getIndex() {
            return index;
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}

