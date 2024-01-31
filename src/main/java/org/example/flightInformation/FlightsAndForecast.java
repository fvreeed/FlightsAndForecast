package org.example.flightInformation;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FlightsAndForecast {

    private List<Flight> flights;

    private Forecast forecast;
}
