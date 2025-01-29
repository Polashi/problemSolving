package entity.aircraft;

public class Aircraft {
    private final Airline id;
    private final String model;
    private final int totalSeats;

    public Aircraft(Airline number, String model, int totalSeats) {
        this.id = number;
        this.model = model;
        this.totalSeats = totalSeats;
    }
}
