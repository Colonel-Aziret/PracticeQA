package service;

import model.Airport;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AirportService {

    private static final String url = "jdbc:postgresql://localhost:5432/";
    private static final String user = "postgres";
    private static final String password = "123";
    private DataSource dataSource;

    public void addAirport(Airport airport) {
        String insert_query = "INSERT INTO airport (code,city,country_code) values(?, ? ,?);";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(insert_query);
            preparedStatement.setString(1, airport.getCode());
            preparedStatement.setString(2, airport.getCity());
            preparedStatement.setString(3, airport.getCountry_code());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }

    public void updateAirport(String newCode, String oldCode) {
        String insert_query = "update airport set code = ?  where code = ?";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(insert_query);
            preparedStatement.setString(1, newCode);
            preparedStatement.setString(2, oldCode);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }

    public void deleteAirport(String code) {
        String delete_query = "delete from airport where country_code = ?";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(delete_query);
            preparedStatement.setString(1, code);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }


    public void ListOfAirport() {
        String list_query = "select * from airport";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet rs;
            rs = statement.executeQuery(list_query);

            while (rs.next()) {
                String code = rs.getString(1);
                String city = rs.getString(2);
                String country_code = rs.getString(3);
                System.out.println(code);
                System.out.println(city);
                System.out.println(country_code);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }
}
