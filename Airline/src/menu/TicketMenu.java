package menu;

import service.TicketService;
import model.Ticket;

import java.util.Scanner;

public class TicketMenu {
    public static void start() {
        TicketService ticketService = new TicketService();

        Scanner sc = new Scanner(System.in);
        while (true) {
            int menuItem;
            System.out.println("Меню билетов: ");
            System.out.println("1) Добавление билета");
            System.out.println("2) Удаление билета");
            System.out.println("3) Изменение билета");
            System.out.println("4) Поиск билета по номеру");
            System.out.println("5) Вывод списка билетов");
            /*
            В выводе списка билетов должны быть также
            выводы с фильтрами (можно сделать меню)
             */
            System.out.println("0) Выход");
            menuItem = sc.nextInt();
            if (menuItem == 1) {
                // Логика добавление билета

                System.out.println("Добавление билета");
                System.out.println("Введите номер свой айди: ");
                int client_id = sc.nextInt();
                sc.nextLine();
                System.out.println(client_id);
                System.out.println("Введите номер рейса: ");
                String flight_number = sc.next();
                sc.nextLine();
                System.out.println(flight_number);
                System.out.println("Время получения билета в (dd/MM/yyyy/): ");
                String ticket_pickup_time = sc.next();
                sc.nextLine();
                System.out.println(ticket_pickup_time);
                System.out.println("Введите номер билета: ");
                String ticket_number = sc.next();
                sc.nextLine();
                System.out.println(ticket_number);
                Ticket ticket = new Ticket(client_id, flight_number, ticket_pickup_time, ticket_number);
                ticketService.addTicket(ticket);
            } else if (menuItem == 2) {
                // Логика удаления билета

                System.out.println("Логика удаления клиента: ");
                System.out.println("Введите номер билета: ");
                String ticket_number = sc.next();
                sc.nextLine();
                System.out.println(ticket_number);
                ticketService.deleteTicket(ticket_number);
            } else if (menuItem == 3) {
                // Логика изменения билета

                System.out.println("Изменение билета");
                System.out.println("Введите номер билета: ");
                String ticket_number = sc.next();
                sc.nextLine();
                System.out.println(ticket_number);
                System.out.println("Введите новый номер билета: ");
                String new_ticket_number = sc.next();
                sc.nextLine();
                System.out.println(ticket_number);
                ticketService.updateTicket(ticket_number, new_ticket_number);
            } else if (menuItem == 4) {
                // Логика поиска билета по номеру

                System.out.println("Поиск билета по номеру");
                System.out.println("Введите номер билета: ");
                String ticket_number = sc.next();
                sc.nextLine();
                System.out.println(ticket_number);
                ticketService.searchTicket(ticket_number);
            } else if (menuItem == 5) {
                // Логика вывода списка билетов
                System.out.println("Вывод списка билетов");
                ticketService.ListOfTicket();
            } else if (menuItem == 0) {
                System.out.println("Выход в главное меню...");
                return;
            } else {
                System.out.println("Ошибка! Введите цифру из меню!");
            }
        }
    }
}
