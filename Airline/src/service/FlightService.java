package service;

import model.Flight;

import javax.sql.DataSource;
import java.sql.*;

public class FlightService {

    private static final String url = "jdbc:postgresql://localhost:5432/";
    private static final String user = "postgres";
    private static final String password = "123";
    private DataSource dataSource;

    public void addFlight(Flight flight) {
        String insert_query = "INSERT INTO flight (model,departure_time,departure_from,arrival,flight_duration,seats,flight_number) values(?, ? ,? ,? ,? ,? ,?);";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(insert_query);
            preparedStatement.setString(1, flight.getModel());
            preparedStatement.setString(2, flight.getDeparture_time());
            preparedStatement.setString(3, flight.getDeparture_from());
            preparedStatement.setString(4, flight.getArrival());
            preparedStatement.setInt(5, flight.getFlight_duration());
            preparedStatement.setInt(6, flight.getSeats());
            preparedStatement.setString(7, flight.getFlight_number());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }

    public void searchFlight(String flightNumber) {
        String search_query = "select * from flight where flight_number = ?";
        ResultSet rs;


        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(search_query);
            preparedStatement.setString(1, flightNumber);
            rs = preparedStatement.executeQuery();
            if (rs == null) {
                throw new Exception("Рейса с таким номером не существует");
            } else {
                while (rs.next()) {
                    String model = rs.getString(1);
                    String departure_time = rs.getString(2);
                    String departure_from = rs.getString(3);
                    String arrival = rs.getString(4);
                    int flightDuration = rs.getInt(5);
                    int seats = rs.getInt(6);
                    String foundFlightNumber = rs.getString(7);
                    System.out.println("Модель самолета: " + model);
                    System.out.println("Откуда вылет: " + departure_from);
                    System.out.println("Прибытие: " + arrival);
                    System.out.println("Длительность полета в часах: " + flightDuration);
                    System.out.println("Количество мест: " + seats);
                    System.out.println("Номер рейса: " + flightNumber);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }

    public void sortFlight(String departure_from, String arrival) {
        String search_query = "select * from flight where flight_duration between ? and ?;";
        ResultSet rs;

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(search_query);
            preparedStatement.setString(1, departure_from);
            preparedStatement.setString(2, arrival);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String model = rs.getString(1);
                Date departure_time = rs.getDate(2);
                String departure_from1 = rs.getString(3);
                String arrival1 = rs.getString(4);
                int flightDuration = rs.getInt(5);
                int seats = rs.getInt(6);
                String foundFlightNumber = rs.getString(7);
                System.out.println(model);
                System.out.println(departure_time);
                System.out.println(departure_from);
                System.out.println(arrival);
                System.out.println(flightDuration);
                System.out.println(seats);
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }


    public void updateFlight(String flightNumber, String departureFrom) {
        String insert_query = "update flight set departure_from = ?  where flight_number = ?";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(insert_query);
            preparedStatement.setString(1, departureFrom);
            preparedStatement.setString(2, flightNumber);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }

    public void deleteFlight(String flightNumber) {
        String delete_query = "delete from flight where flight_number = ?";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(delete_query);
            preparedStatement.setString(1, flightNumber);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }

    public void ListOfFlight() {
        String list_query = "select * from flight";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet rs;
            rs = statement.executeQuery(list_query);

            while (rs.next()) {
                String model = rs.getString(1);
                String departure_time = rs.getString(2);
                String departure_from = rs.getString(3);
                String arrival = rs.getString(4);
                String flight_duration = rs.getString(5);
                String seats = rs.getString(6);
                String flight_number = rs.getString(7);
                System.out.println("Модель самолета: " + model);
                System.out.println("Откуда вылет: " + departure_from);
                System.out.println("Прибытие: " + arrival);
                System.out.println("Длительность полета в часах: " + flight_duration);
                System.out.println("Количество мест: " + seats);
                System.out.println("Номер рейса: " + flight_number);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }
}
