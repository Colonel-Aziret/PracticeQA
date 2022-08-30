package menu;

import service.AirportService;
import model.Airport;

import java.util.Scanner;

public class AirportMenu {
    public static void start() {
        AirportService airportService = new AirportService();

        Scanner sc = new Scanner(System.in);
        while (true) {
            int menuItem;
            System.out.println("Меню аэропортов: ");
            System.out.println("1) Добавление аэропорта");
            System.out.println("2) Удаление аэропорта");
            System.out.println("3) Изменение аэропорта");
            System.out.println("4) Поиск аэропорта по коду");
            System.out.println("5) Вывод списка аэропортов");
            /*
            В выводе списка аэропортов должны быть также
            выводы с фильтрами (можно сделать меню)
             */
            System.out.println("0) Выход");
            menuItem = sc.nextInt();
            if (menuItem == 1) {
                // Логика добавления аэропорта

                System.out.println("Добавление аэропорта");
                System.out.println("Введите код: ");
                String code = sc.next();
                sc.nextLine();
                System.out.println(code);
                System.out.println("Введите город: ");
                String city = sc.next();
                sc.nextLine();
                System.out.println(city);
                System.out.println("Введите код страны: ");
                String countryCode = sc.nextLine();
                System.out.println(countryCode);
                Airport airport = new Airport(code, city, countryCode);
                airportService.addAirport(airport);
            } else if (menuItem == 2) {
                // Логика удаления аэропрта

                System.out.println("Введите код: ");
                String code = sc.nextLine();
                sc.nextLine();
                airportService.deleteAirport(code);
            } else if (menuItem == 3) {
                // Логика изменения аэропорта

                System.out.println("Изменение аэропорта");
                System.out.println("Введите код: ");
                String oldCode = sc.nextLine();
                sc.nextLine();
                System.out.println("Введите новый код:");
                String newCode = sc.nextLine();
                airportService.updateAirport(oldCode, newCode);
            } else if (menuItem == 4) {
                // Логика поиска аэропорта по коду

                System.out.println("Поиск аэропорта по коду");
                airportService.ListOfAirport();
            } else if (menuItem == 5) {
                // Логика вывода спика аэропортов

                System.out.println("Вывод списка аэропортов");
                airportService.ListOfAirport();
            } else if (menuItem == 0) {
                System.out.println("Выход в главное меню...");
                return;
            } else {
                System.out.println("Ошибка! Введите цифру из меню!");
            }
        }
    }
}
