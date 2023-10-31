package data_access;

import entity.Item;
import entity.Unit;
import org.json.JSONObject;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DataAccessObject {

    public Item get(String apiCall) {
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
        Item toReturn = new Item();
        toReturn.Name = name;

        JSONObject cost = obj.getJSONObject("cost");

        toReturn.CostQuantity = cost.getInt("quantity");
        //cp, sp, gp, pp
        String unit = cost.getString("unit");
        if (unit.equals("cp")) {
            toReturn.CostUnit = Unit.COPPER;
        }
        if (unit.equals("sp")) {
            toReturn.CostUnit = Unit.SILVER;
        }
        if (unit.equals("gp")) {
            toReturn.CostUnit = Unit.GOLD;
        }
        if (unit.equals("pp")) {
            toReturn.CostUnit = Unit.PLATINUM;
        }

        return toReturn;

    }

}
