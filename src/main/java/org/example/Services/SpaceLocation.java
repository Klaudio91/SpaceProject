package org.example.Services;

import com.google.gson.Gson;
import com.squareup.okhttp.*;
import org.example.model.IssNowResponse;

public class SpaceLocation {


    private static final String BASE_URL = "http://api.open-notify.org/astros.json";

    public IssNowResponse getPeopleInSpace() {
        try {
            // Create http client
            OkHttpClient client = new OkHttpClient();

            // Set URL and parameters
            HttpUrl.Builder urlBuilder
                    = HttpUrl.parse(BASE_URL).newBuilder();

            String url = urlBuilder.build().toString();
            // Build request and execute
            Request request = new Request.Builder()
                    .url(url)
                    .build();
            Call call = client.newCall(request);
            Response response = call.execute();

            // Convert response to String
            String sResponse = response.body().string();

            // Convert String to our class model
            Gson gson = new Gson();
            IssNowResponse issNowResponse = gson.fromJson(sResponse, IssNowResponse.class);

            // Return class model
            return issNowResponse;
        } catch (Exception e) {
            System.out.println("* Something went wrong while retrieving weather data. *");
        }

        return null;
    }


}
