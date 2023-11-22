package use_case.race;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import entity.Race;
import entity.Trait;
import org.json.JSONArray;
import org.json.JSONObject;

public class RaceDetailsInteractor {

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public Race getRaceDetails(String raceName) {
        Race race = new Race();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.dnd5eapi.co/api/races/" + raceName))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject raceJson = new JSONObject(response.body());

            race.setName(raceJson.getString("name"));
            race.setSpeed(raceJson.getInt("speed"));
            race.setAge(raceJson.getString("age"));
            race.setAlignment(raceJson.getString("alignment"));
            race.setSize(raceJson.getString("size"));
            race.setSizeDescription(raceJson.getString("size_description"));


            race.setTraits(parseTraits(raceJson.getJSONArray("traits")));




        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            // Handle the error appropriately - perhaps rethrow as a custom checked exception
        }

        return race;
    }

    private List<Trait> parseTraits(JSONArray traitsJson) {
        List<Trait> traits = new ArrayList<>();
        for (int i = 0; i < traitsJson.length(); i++) {
            JSONObject traitJson = traitsJson.getJSONObject(i);
            Trait trait = new Trait();
            trait.setIndex(traitJson.getString("index"));
            trait.setName(traitJson.getString("name"));
            trait.setUrl(traitJson.getString("url"));
            traits.add(trait);
        }
        return traits;
    }
}
