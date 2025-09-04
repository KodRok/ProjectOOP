package school.sorokin.javacore;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final InputValidator validator;
    private final List<Publication> publications;

    public Library(InputValidator validator) {
        this.validator = validator;
        this.publications = new ArrayList<>();
    }

    public void addPublication() {
        Publication newPublication = createPublication();
        if (newPublication != null) {
            this.publications.add(newPublication);
            System.out.printf("В библиотеку добавлен(а) %s %s%n",
                    newPublication.getType(), newPublication.getTitle());
        } else {
            System.out.println("Операция добавления отменена.");
        }
    }

    public void deletePublication() {
        if (publications.isEmpty()) {
            System.out.println("Библиотека пока пуста.");
            return;
        }

        System.out.println("Выберите публикацию для удаления по номеру:");
        for (int i = 0; i < publications.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, publications.get(i).getTitle());
        }

        int indexToDelete = validator.validateInt("Введите номер публикации. Для отмены нажмите 0. ");

        if (indexToDelete > 0 && indexToDelete <= publications.size()) {
            publications.remove(indexToDelete - 1);
            System.out.println("Публикация удалена.");
        } else if (indexToDelete == 0) {
            System.out.println("Операция удаления отменена.");
        } else {
            System.out.println("Некорректный номер.");
        }
    }

    public void searchByAuthor() {
        if (publications.isEmpty()) {
            System.out.println("Библиотека пока пуста.");
            return;
        }
        String author = validator.validateString("Введите фамилию автора: ");
        boolean isFound = false;
        for (Publication p : publications) {
            if (p.getAuthor() != null && p.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(p);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.printf("Публикаций автора %s в библиотеке не найдено.%n", author);
        }
    }

    public void getAllPublications() {
        if (publications.isEmpty()) {
            System.out.println("Библиотека пока пуста.");
        } else {
            System.out.println("Список публикаций в библиотеке:");
            for (Publication p : publications) {
                System.out.println(p);
            }
        }
    }

    public int getPublicationCount() {
        return publications.size();
    }

    private Publication createPublication() {
        printPublicationMenu();
        Publication publication = null;

        int userChoice = validator.validateInt("Введите соответствующую цифру: ");
        if (userChoice < 1 || userChoice > 3) {
            System.out.println("Некорректный выбор.");
            return publication;
        }

        String title = validator.validateString("Введите название: ");
        int year = validator.validateInt("Введите год издания: ");
        String author = validator.validateString("Введите фамилию автора: ");

        switch (userChoice) {
            case 1:
                String isbn = validator.validateString("Введите ISBN: ");
                return new Book(title, author, year, isbn);
            case 2:
                int issueNumber = validator.validateInt("Введите номер выпуска журнала: ");
                return new Magazine(title, author, year, issueNumber);
            case 3:
                String pubDay = validator.validateString("Введите дату публикации газеты: ");
                return new Newspaper(title, author, year, pubDay);
            default:
                return publication;
        }
    }

    private void printPublicationMenu() {
        System.out.println("\nВыберите тип публикации:");
        System.out.println("1. Книга");
        System.out.println("2. Журнал");
        System.out.println("3. Газета");
    }
}