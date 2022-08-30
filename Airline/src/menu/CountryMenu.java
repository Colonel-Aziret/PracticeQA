package menu;

import service.CountryService;
import model.Country;

import java.util.Scanner;

public class CountryMenu {
    public static void start() {
        CountryService countryService = new CountryService();

        Scanner sc = new Scanner(System.in);
        while (true) {
            int menuItem;
            System.out.println("Меню стран: ");
            System.out.println("1) Добавление страны");
            System.out.println("2) Удаление страны");
            System.out.println("3) Изменение страны");
            System.out.println("4) Поиск страны по коду");
            System.out.println("5) Вывод списка стран");
            System.out.println("0) Выход");

            menuItem = sc.nextInt();
            if (menuItem == 1) {
                // Логика добавления страны

                //Country country = new Country();
                System.out.println("Добавление страны");
                System.out.println("Введите код страны: ");
                String code = sc.next();
                sc.nextLine();
                System.out.println(code);
                System.out.println("Введите название страны: ");
                String name = sc.nextLine();
                System.out.println(name);
                Country country = new Country(name, code);
                countryService.addCountry(country);
            } else if (menuItem == 2) {
                // Логика удаления страны

                System.out.println("Введите код страны для удаления: ");
                String code = sc.nextLine();
                sc.nextLine();
                countryService.deleteCountry(code);
            } else if (menuItem == 3) {
                // Логика изменения страны

                System.out.println("Изменение страны");
                System.out.println("Введите код страны который хотите изменить");
                String oldCode = sc.nextLine();
                sc.nextLine();
                System.out.println("Введите новый код:");
                String newCode = sc.nextLine();
                countryService.updateCountry(oldCode, newCode);

            } else if (menuItem == 4) {
                // Логика поиска страны по коду

                System.out.println("Поиск страны по коду");
                System.out.println("Введите код страны: ");
                String country_code = sc.nextLine();
                sc.nextLine();
                System.out.println(country_code);
                countryService.searchCountry(country_code);
            } else if (menuItem == 5) {
                // Логика вывода списка стран

                System.out.println("Вывод списка стран");
                countryService.ListOfCountry();
            } else if (menuItem == 0) {
                System.out.println("Выход в главное меню...");
                return;
            } else {
                System.out.println("Ошибка! Введите цифру из меню!");
            }
        }
    }
}
