package use_case.back_desc;

import entity.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BackDetailsHelper {
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public Background getBackDetails(String backgroundName) {
        Background back = new Background();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.dnd5eapi.co/api/backgrounds/" + backgroundName))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject backJson = new JSONObject(response.body());
            JSONObject backFeatureJson = backJson.getJSONObject("feature");
            HashMap<String, Object> featureMap = new HashMap<>();

            back.setName(backJson.getString("name"));
            for (String key: backFeatureJson.keySet()) {
                featureMap.put(key, backFeatureJson.get(key));
            }
            back.setFeature(featureMap);




        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            // Handle the error appropriately - perhaps rethrow as a custom checked exception
        }

        return back;
    }

    private ArrayList<Item> parseEquipment(JSONArray equipmentJson) {
        ArrayList<Item> equipment = new ArrayList<>();
        for (int i = 0; i < equipmentJson.length(); i++) {
            JSONObject equipJson = equipmentJson.getJSONObject(i);
            Item equip = new Item();
            equip.Name = equipJson.getString("name");
            equip.CostQuantity = equipJson.getInt("quantity");
            equipment.add(equip);
        }
        return equipment;
    }
//    private HashMap<String, String> parseFeature(JSONArray featureJson) {
//        HashMap<String, String> feature = new HashMap<>();
//        for (int i = 0; i < featureJson.length(); i++) {
//            String key = featureJson.getString(i);
//            feature.put()
//        }
//    }
}
