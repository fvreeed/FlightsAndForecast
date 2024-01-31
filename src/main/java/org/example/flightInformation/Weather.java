package org.example.flightInformation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {

    private int time;

    private int wind;

    private int visibility;

    @Override
    public String toString() {
        return "Weather{" +
                "time=" + time +
                ", wind=" + wind +
                ", visibility=" + visibility +
                '}';
    }
}
