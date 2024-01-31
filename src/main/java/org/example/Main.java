package org.example;

import org.example.flightInformation.Flight;
import org.example.flightInformation.FlightsAndForecast;
import org.example.flightInformation.Forecast;
import org.example.flightInformation.Weather;
import org.example.parser.FlightsAndForecastParser;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        FlightsAndForecastParser flightsAndForecastParser = new FlightsAndForecastParser();
        FlightsAndForecast flightsAndForecast = flightsAndForecastParser.parseFlightsAndForecast(
                "src/main/resources/FlightsAndForecastJson/flights_and_forecast.json"
        );

        for (Flight flight : flightsAndForecast.getFlights()) {
            System.out.println(flight.getNo() +
                    " | " + flight.getFrom() +
                    " -> " + flight.getTo() +
                    " | " + checkingFlightStatus(flight, flightsAndForecast.getForecast()));
        }
    }

    private static String checkingFlightStatus(Flight flight, Forecast forecast) {

        if (goodWeather(findWeatherFrom(flight.getFrom(), flight.getDeparture(), forecast),
                Objects.requireNonNull(findWeatherTo(flight, forecast)))) {
            return "по расписанию";
        }

        return "отменен";
    }

    private static boolean goodWeather(Weather weatherFrom, Weather weatherTo) {

        return (weatherFrom.getWind() <= 30) && (weatherTo.getWind() <= 30) &&
                (weatherFrom.getVisibility() >= 200) && (weatherTo.getVisibility() >= 200);
    }

    private static Weather findWeatherFrom(String city, int time, Forecast forecast) {

        return switch (city) {
            case "moscow" -> forecast.getMoscow().get(time);
            case "novosibirsk" -> forecast.getNovosibirsk().get(time);
            case "omsk" -> forecast.getOmsk().get(time);
            default -> null;
        };
    }

    private static Weather findWeatherTo(Flight flight, Forecast forecast) {

        switch (flight.getTo()) {
            case "moscow":
                switch (flight.getFrom()) {
                    case "novosibirsk":
                        return forecast.getMoscow().get(time(flight.getDeparture(), flight.getDuration(), -4));
                    case "omsk":
                        return forecast.getMoscow().get(time(flight.getDeparture(), flight.getDuration(), -3));
                }
                break;
            case "novosibirsk":
                switch (flight.getFrom()) {
                    case "moscow":
                        return forecast.getNovosibirsk().get(time(flight.getDeparture(), flight.getDuration(), 4));
                    case "omsk":
                        return forecast.getNovosibirsk().get(time(flight.getDeparture(), flight.getDuration(), 1));
                }
                break;
            case "omsk":
                switch (flight.getFrom()) {
                    case "moscow":
                        return forecast.getOmsk().get(time(flight.getDeparture(), flight.getDuration(), 3));
                    case "novosibirsk":
                        return forecast.getOmsk().get(time(flight.getDeparture(), flight.getDuration(), -1));
                }
                break;
        }
        return null;
    }

    private static int time(int departure, int duration, int diff) {

        int time = departure + duration + diff;
        if (time > 24) {
            time = time - 24;
        }

        return time;
    }
}