package org.example.flightInformation;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Forecast {

    private List<Weather> moscow;

    private List<Weather> novosibirsk;

    private List<Weather> omsk;

    @Override
    public String toString() {
        return "Forecast{" +
                "moscow=" + moscow +
                ", novosibirsk=" + novosibirsk +
                ", omsk=" + omsk +
                '}';
    }
}
