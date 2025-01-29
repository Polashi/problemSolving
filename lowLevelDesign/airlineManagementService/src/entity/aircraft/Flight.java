package entity.aircraft;

import entity.seat.Seat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Flight {
    private final String id;
    private final String source;
    private final String destination;
    private final LocalDateTime departureTime;

    public String getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    private final LocalDateTime arrivalTime;
    private final List<Seat> availableSeats;


    public Flight(String id, String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.availableSeats = new ArrayList<>();
    }
}
