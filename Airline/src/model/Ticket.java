package model;

import java.sql.Date;

public class Ticket {
    private int client_id;
    private String flight_number;
    private String ticket_pick_time;
    private String ticket_number;

    public Ticket(int client_id, String flight_number, String ticket_pick_time, String ticket_number) {
        this.client_id = client_id;
        this.flight_number = flight_number;
        this.ticket_pick_time = ticket_pick_time;
        this.ticket_number = ticket_number;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getTicket_pick_time() {
        return ticket_pick_time;
    }

    public void setTicket_pick_time(String ticket_pick_time) {
        this.ticket_pick_time = ticket_pick_time;
    }

    public String getTicket_number() {
        return ticket_number;
    }

    public void setTicket_number(String ticket_number) {
        this.ticket_number = ticket_number;
    }
}
