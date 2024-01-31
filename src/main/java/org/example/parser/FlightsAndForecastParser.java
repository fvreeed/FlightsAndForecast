package org.example.parser;

import com.google.gson.Gson;
import org.example.flightInformation.FlightsAndForecast;

import java.io.FileReader;

public class FlightsAndForecastParser {

    public FlightsAndForecast parseFlightsAndForecast(String filePath) {
        Gson gson = new Gson();

        try {
            FileReader reader = new FileReader(filePath);
            FlightsAndForecast fromJson = gson.fromJson(reader, FlightsAndForecast.class);
            return fromJson;
        } catch (Exception e) {
            System.out.println("Parsing error " + e);
        }

        return null;
    }
}
