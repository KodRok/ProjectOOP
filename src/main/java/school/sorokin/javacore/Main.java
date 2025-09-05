package school.sorokin.javacore;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final InputValidator validator = new InputValidator(scanner);
    private static final Library library = new Library(validator);

    public static void main(String[] args) {
        int userChoice;
        do {
            printMainMenu();
            userChoice = validator.validateInt("Выберите опцию: ");
            switch (userChoice) {
                case 1:
                    library.addPublication();
                    break;
                case 2:
                    library.getAllPublications();
                    break;
                case 3:
                    library.searchByAuthor();
                    break;
                case 4:
                    System.out.println("Общее количество публикаций в библиотеке: "
                            + library.getPublicationCount());
                    break;
                case 5:
                    library.deletePublication();
                    break;
                case 6:
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Введите цифру от 1 до 6.");
            }
        } while (userChoice != 6);
        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("\n--- Меню библиотеки ---");
        System.out.println("1. Добавить новую публикацию");
        System.out.println("2. Вывести список всех публикаций");
        System.out.println("3. Поиск книги по автору");
        System.out.println("4. Вывести общее количество публикаций");
        System.out.println("5. Удалить публикацию");
        System.out.println("6. Выйти из программы");
    }
}