package org.example.flightInformation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flight {

    private String no;

    private int departure;

    private String from;

    private String to;

    private int duration;

    @Override
    public String toString() {
        return "Flight{" +
                "no='" + no + '\'' +
                ", departure=" + departure +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", duration=" + duration +
                '}';
    }
}
