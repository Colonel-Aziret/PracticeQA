package service;

import model.Ticket;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TicketService {

    private static final String url = "jdbc:postgresql://localhost:5432/";
    private static final String user = "postgres";
    private static final String password = "123";
    private DataSource dataSource;

    public void addTicket(Ticket ticket) {
        String insert_query = "INSERT INTO ticket (client_id,flight_number,ticket_pickup_time,ticket_number) " + "values(?, ? ,? ,?)";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(insert_query);
            preparedStatement.setInt(1, ticket.getClient_id());
            preparedStatement.setString(2, ticket.getFlight_number());
            preparedStatement.setString(3, ticket.getTicket_pick_time());
            preparedStatement.setString(4, ticket.getTicket_number());
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }

    public void updateTicket(String oldTickedNumber, String newTicketNumber) {
        String insert_query = "update ticket set ticket_number = ?  where ticket_number = ?";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(insert_query);
            preparedStatement.setString(1, newTicketNumber);
            preparedStatement.setString(2, oldTickedNumber);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }

    public void deleteTicket(String ticketNumber) {
        String delete_query = "delete from ticket where ticket_number = ?";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(delete_query);
            preparedStatement.setString(1, ticketNumber);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }

    public void searchTicket(String ticket_number) {
        String search_query = "select * from ticket where ticket_number = ?";
        ResultSet rs;


        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(search_query);
            preparedStatement.setString(1, ticket_number);
            rs = preparedStatement.executeQuery();
            if (rs == null) {
                throw new Exception("Билета с таким номером не существует!");
            } else {
                while (rs.next()) {
                    ticket_number = rs.getString(1);
                    System.out.println("Найден билет: " + ticket_number);
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }


    public void ListOfTicket() {
        String list_query = "select * from Ticket";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            statement.executeQuery(list_query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }
}
