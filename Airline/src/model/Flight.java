package model;


public class Flight {
    private String model;
    private String departure_time;
    private String departure_from;
    private String arrival;
    private int flight_duration;
    private int seats;
    private String flight_number;

    public Flight(String model, String departure_time, String departure_from, String arrival, int flight_duration, int seats, String flight_number) {
        this.model = model;
        this.departure_time = departure_time;
        this.departure_from = departure_from;
        this.arrival = arrival;
        this.flight_duration = flight_duration;
        this.seats = seats;
        this.flight_number = flight_number;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getDeparture_from() {
        return departure_from;
    }

    public void setDeparture_from(String departure_from) {
        this.departure_from = departure_from;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getFlight_duration() {
        return flight_duration;
    }

    public void setFlight_duration(int flight_duration) {
        this.flight_duration = flight_duration;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }
}
