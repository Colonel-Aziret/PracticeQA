package service;

import model.Country;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CountryService {

    private static final String url = "jdbc:postgresql://localhost:5432/";
    private static final String user = "postgres";
    private static final String password = "123";
    private DataSource dataSource;

    public void addCountry(Country country) { // Добавление страны
        String insert_query = "INSERT INTO country (code,name) " + "values(?, ?)";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(insert_query);
            preparedStatement.setString(1, country.getCode());
            preparedStatement.setString(2, country.getName());
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }

    public void updateCountry(String oldCode, String newCode) { // Изменение страны
        String insert_query = "update country set code = ?  where code = ?";

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

    public void deleteCountry(String code) { // Удаление страны
        String delete_query = "delete from country where code = ?";

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

    public void searchCountry(String code) {
        String search_query = "select * from country where code = (?)";
        ResultSet rs;


        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(search_query);
            preparedStatement.setString(1, code);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {

                // Position the cursor                  4
                String code1 = rs.getString(1);        // Retrieve the first column value
                String name = rs.getString(2);      // Retrieve the first column value
                System.out.println("Employee number = " + code1 +
                        "Phone number = " + name);
                // Print the column values
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }

    public void ListOfCountry() {
        String list_query = "select * from country";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet rs;
            rs = statement.executeQuery(list_query);

            while (rs.next()) {
                String code = rs.getString(1);
                String name = rs.getString(2);
                System.out.println(code);
                System.out.println(name);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }
}
