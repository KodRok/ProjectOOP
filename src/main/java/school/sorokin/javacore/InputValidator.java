package school.sorokin.javacore;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputValidator {
    private final Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public int validateInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Нужно ввсети целое число!");
                scanner.next();
                System.out.print(prompt);
            }
        }
    }

    public String validateString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
