package vowxky.rotnputrid.event;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.minecraft.client.MinecraftClient;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

/**
 * This class was created by Vowxky.
 * All rights reserved to the developer.
 */

public class ClientJoinRot implements ClientLifecycleEvents.ClientStarted {
    @Override
    public void onClientStarted(MinecraftClient client) {
        String jsonUrl = "https://vowxky.github.io/idk.json";

        try {
            JsonObject jsonObject = readJsonFromUrl(jsonUrl);

            if (!jsonObject.has("test") || !jsonObject.get("test").getAsBoolean()) {
                System.out.println("no allowed to use this mod");
                client.scheduleStop();
            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
            client.scheduleStop();
        }
    }

    private JsonObject readJsonFromUrl(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new Exception("200:  " + responseCode);
        }

        try (InputStreamReader reader = new InputStreamReader(connection.getInputStream())) {
            return JsonParser.parseReader(reader).getAsJsonObject();
        }
    }
}
