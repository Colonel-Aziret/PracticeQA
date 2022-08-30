package service;

import model.Clients;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClientsService {

    private static final String url = "jdbc:postgresql://localhost:5432/";
    private static final String user = "postgres";
    private static final String password = "123";
    private DataSource dataSource;

    public void addClients(Clients clients) {
        String insert_query = "INSERT INTO clients (inn,id,fio,gender,country) " + "values(?, ? ,? ,?, ?)";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(insert_query);
            preparedStatement.setString(1, clients.getInn());
            preparedStatement.setInt(2, clients.getId());
            preparedStatement.setString(3, clients.getFio());
            preparedStatement.setString(4, clients.getGender());
            preparedStatement.setString(5, clients.getCountry());
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }

    public void updateClients(int newId, int oldId) {
        String insert_query = "update clients set id = ?  where id = ?";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(insert_query);
            preparedStatement.setInt(1, newId);
            preparedStatement.setInt(2, oldId);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }

    public void deleteClients(int id) {
        String delete_query = "delete from clients where id = ?";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(delete_query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }

    public void searchClients(int id) {
        String search_query = "select * from clients where id = (?)";
        ResultSet rs;


        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(search_query);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {

                String inn = rs.getString(1);
                int found_id = rs.getInt(2);
                String fio = rs.getString(3);
                String gender = rs.getString(4);
                String country = rs.getString(5);
                System.out.println(inn);
                System.out.println(id);
                System.out.println(fio);
                System.out.println(gender);
                System.out.println(country);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }

    public void ListOfClients() {
        String list_query = "select * from clients";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement statement = connection.createStatement();
            ResultSet rs;
            rs = statement.executeQuery(list_query);

            while (rs.next()) {
                String inn = rs.getString(1);
                int found_id = rs.getInt(2);
                String fio = rs.getString(3);
                String gender = rs.getString(4);
                String country = rs.getString(5);
                System.out.println(inn);
                System.out.println(found_id);
                System.out.println(fio);
                System.out.println(gender);
                System.out.println(country);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            System.out.println("Ошибка соединения");
        }
    }
}
