package menu;

import service.ClientsService;
import model.Clients;

import java.util.Scanner;

public class ClientsMenu {
    public static void start() {
        ClientsService clientsService = new ClientsService();

        Scanner sc = new Scanner(System.in);
        while (true) {
            int menuItem;
            System.out.println("Меню клиентов: ");
            System.out.println("1) Добавление клиента");
            System.out.println("2) Удаление клиента");
            System.out.println("3) Изменение клиента");
            System.out.println("4) Поиск клиента по номеру паспорта");
            System.out.println("5) Вывод списка клиентов");
            System.out.println("0) Выход");

            menuItem = sc.nextInt();
            if (menuItem == 1) {
                // Логика добавления клиента
                System.out.println("Добавление клиента");
                System.out.println("Введите ИНН: ");
                String inn = sc.next();
                sc.nextLine();
                System.out.println(inn);
                System.out.println("Введите айди: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println(id);
                System.out.println("Введите ФИО: ");
                String fio = sc.next();
                sc.nextLine();
                System.out.println(fio);
                System.out.println("Введите пол: ");
                String gender = sc.next();
                sc.nextLine();
                System.out.println(gender);
                System.out.println("Введите страну: ");
                String country = sc.nextLine();
                System.out.println(country);
                Clients clients = new Clients(inn, id, fio, gender, country);
                clientsService.addClients(clients);
            } else if (menuItem == 2) {
                // Логика удаления клиента
                System.out.println("Удаление клиента");
                System.out.println("Введите номер паспорта: ");
                int passport_id = sc.nextInt();
                sc.nextInt();
                System.out.println(passport_id);
                clientsService.deleteClients(passport_id);

            } else if (menuItem == 3) {
                // Логика изменения клиента
                System.out.println("Изменение клиента");
                System.out.println("Введите номер паспорта который хотите изменить: ");
                int oldPassportID = sc.nextInt();
                sc.nextInt();
                System.out.println(oldPassportID);
                System.out.println("Введите новый номер паспорта: ");
                int newPassportID = sc.nextInt();
                sc.nextInt();
                System.out.println(newPassportID);
                clientsService.updateClients(newPassportID, oldPassportID);
            } else if (menuItem == 4) {
                // Логика поиска клиента по номеру паспорта
                System.out.println("Поиск клиента по номеру паспорта");
                System.out.println("Введите номер паспорта который хотите найти: ");
                int searchID = sc.nextInt();
                sc.nextInt();
                System.out.println(searchID);
                clientsService.searchClients(searchID);
            } else if (menuItem == 5) {
                // Логика вывода списка клиентов
                System.out.println("Вывод списка клиентов");
                clientsService.ListOfClients();
            } else if (menuItem == 0) {
                System.out.println("Выход в главное меню...");
                return;
            } else {
                System.out.println("Ошибка! Введите цифру из меню!");
            }
        }
    }
}
