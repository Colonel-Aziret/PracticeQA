package menu;

import service.FlightService;
import model.Flight;


import java.text.ParseException;
import java.util.Scanner;

public class FlightMenu {
    public static void start() throws ParseException {
        FlightService flightService = new FlightService();

        Scanner sc = new Scanner(System.in);
        while (true) {
            int menuItem;
            System.out.println("Меню рейсов: ");
            System.out.println("1) Добавление рейса");
            System.out.println("2) Удаление рейса");
            System.out.println("3) Изменение рейса");
            System.out.println("4) Поиск рейса по номеру");
            System.out.println("5) Вывод списка рейсов");
            /*
            В выводе списка рейсов должны быть также
            выводы с фильтрами (можно сделать меню)
             */
            System.out.println("0) Выход");
            menuItem = sc.nextInt();
            if (menuItem == 1) {
                // Логика добавления рейса

                System.out.println("Добавление рейса");
                System.out.println("Введите модель самолета: ");
                String model = sc.next();
                sc.nextLine();
                System.out.println(model);
                System.out.println("Введите время вылета: (dd/MM/yyyy) ");
                String departure_time = sc.next();
                sc.nextLine();
                System.out.println(departure_time);
                System.out.println("Откуда вылет: ");
                String departure_from = sc.next();
                sc.nextLine();
                System.out.println(departure_from);
                System.out.println("Прибытие: ");
                String arrival = sc.next();
                sc.nextLine();
                System.out.println(arrival);
                System.out.println("Время полета (в часах): ");
                int flight_duration = sc.nextInt();
                sc.nextInt();
                System.out.println(flight_duration);
                System.out.println("Количество мест: ");
                int seats = sc.nextInt();
                sc.nextInt();
                System.out.println(seats);
                System.out.println("Номер рейса: ");
                String flight_number = sc.next();
                sc.nextLine();
                System.out.println(flight_number);
                Flight flight = new Flight(model, departure_time, departure_from, arrival, flight_duration, seats, flight_number);
                flightService.addFlight(flight);
            } else if (menuItem == 2) {
                // Логика удаления рейса

                System.out.println("Удаление рейса");
                System.out.println("Введите номер рейса: ");
                String flight_number = sc.next();
                sc.nextLine();
                System.out.println(flight_number);
                flightService.deleteFlight(flight_number);
            } else if (menuItem == 3) {
                // Логика изменения рейса

                System.out.println("Изменение рейса");
                System.out.println("Введите номер рейса: ");
                String flightNumber = sc.next();
                sc.nextLine();
                System.out.println(flightNumber);
                System.out.println("Откуда вылет (новый) :");
                String newDepartureFrom = sc.next();
                sc.nextLine();
                System.out.println(newDepartureFrom);
                flightService.updateFlight(flightNumber, newDepartureFrom);
            } else if (menuItem == 4) {
                // Логика поиска рейса по номеру

                System.out.println("Поиск рейса по номеру");
                System.out.println("Введите номер рейса, который хотите найти: ");
                String flight_number = sc.next();
                sc.nextLine();
                System.out.println(flight_number);
                flightService.searchFlight(flight_number);
            } else if (menuItem == 5) {
                // Логика вывода списка рейсов
                System.out.println("Вывод списка рейсов");
                flightService.ListOfFlight();
            } else if (menuItem == 0) {
                System.out.println("Выход в главное меню...");
                return;
            } else {
                System.out.println("Ошибка! Введите цифру из меню!");
            }
        }
    }
}
