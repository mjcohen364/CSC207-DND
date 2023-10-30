import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class Item {

    public void asdf(String apiCall) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.dnd5eapi.co/api/" + apiCall))
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String jsonString = response.body().toString(); //assign your JSON String here

        JSONObject obj = new JSONObject(jsonString);
        String name = obj.getString("name");
        this.Name = name;

        JSONObject cost = obj.getJSONObject("cost");

        this.CostQuantity = cost.getInt("quantity");
        //cp, sp, gp, pp
        String unit = cost.getString("unit");
        if (unit.equals("cp")) {
            this.CostUnit = Unit.COPPER;
        }
        if (unit.equals("sp")) {
            this.CostUnit = Unit.SILVER;
        }
        if (unit.equals("gp")) {
            this.CostUnit = Unit.GOLD;
        }
        if (unit.equals("pp")) {
            this.CostUnit = Unit.PLATINUM;
        }

    }
    String Name;

    int CostQuantity;
    Unit CostUnit;

    float Weight;

    ArrayList<String> Desc;

    ArrayList<ItemProperty> Properties;
}

enum Unit {
    COPPER,
    SILVER,
    GOLD,
    PLATINUM
}