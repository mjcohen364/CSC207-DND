package data_access;

import entity.Item;
import entity.Player;
import entity.PlayerCreator;
import entity.Unit;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class DataAccessObject {
    public PlayerCreator player = new PlayerCreator();
    public ArrayList<Item> itemsFromClass = new ArrayList<>();
    public ArrayList<Item> itemsFromClassOptions = new ArrayList<>();
//    TODO REPLACE PLACEHOLDERNAME WITH CODE THAT RETRIEVES CURRENT SELECTED CHARACTER'S NAME
    public String getCharacterName() {return "PLACEHOLDERNAME";}

    public ArrayList<String> getClasses() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.dnd5eapi.co/api/classes"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String jsonString = response.body().toString();

        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("results");
        ArrayList<String> toReturn = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            toReturn.add(arr.getJSONObject(i).getString("name"));
        }

        return toReturn;
    }

    public void chooseClass(String apiCall) {
        player.setdndclass(apiCall.substring(13));
        player.generatejson();
        itemsFromClass.clear();
        itemsFromClassOptions.clear();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.dnd5eapi.co" + apiCall))
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String jsonString = response.body().toString();

        JSONObject obj = new JSONObject(jsonString);
        var equips = obj.getJSONArray("starting_equipment");

        for (int i = 0; i < equips.length(); i++) {
            var equip1 = equips.getJSONObject(i);
            var equip = equip1.getJSONObject("equipment");
            Item newItem = get(equip.getString("url"));
            itemsFromClass.add(newItem);
        }
    }
    public ArrayList<String> getRaces() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.dnd5eapi.co/api/races"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String jsonString = response.body().toString();

        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("results");
        ArrayList<String> toReturn = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            toReturn.add(arr.getJSONObject(i).getString("name"));
        }

        return toReturn;
    }
    public String getDescription(String api) {
//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.dnd5eapi.co/" + api)).build();
//        HttpResponse<String> response = null;
//        try {
//            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        String jsonString = response.body().toString();
//        JSONObject obj = new JSONObject(jsonString);
//        JSONArray arr = obj.getJSONArray("results");
//        StringBuilder toReturn = new StringBuilder();
//        for (int i = 0; i < arr.length(); i++) {
//            toReturn.append(arr.getJSONObject(i).getString());
//        }

        return "PLACEHOLDER_DESCRIPTION";
    }
    public ArrayList<String> getBackgrounds() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.dnd5eapi.co/api/backgrounds"))
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String jsonString = response.body().toString();

        JSONObject obj = new JSONObject(jsonString);
        JSONArray arr = obj.getJSONArray("results");
        ArrayList<String> toReturn = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            toReturn.add(arr.getJSONObject(i).getString("name"));
        }

        return toReturn;
    }

    private Item get(String apiCall) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.dnd5eapi.co" + apiCall))
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String jsonString = response.body().toString();

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
