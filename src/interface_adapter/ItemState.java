package interface_adapter;

public class ItemState {
    private String api = "";
    private String apiError = null;

    private String name;
    private int quantity;

    public ItemState(ItemState copy) {
        api = copy.api;
        apiError = copy.apiError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public ItemState() {
    }

    public String getApi() {
        return api;
    }
    public String getName() {
        return name;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getApiError() {
        return apiError;
    }


    public void setApi(String api) {
        this.api = api;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void setApiError(String apiError) {
        this.apiError = apiError;
    }

    @Override
    public String toString() {
        return "ItemState{" +
                "api='" + api + '\'' + '}';
    }
}
