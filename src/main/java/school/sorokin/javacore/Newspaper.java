package school.sorokin.javacore;

import java.util.Objects;

public class Newspaper extends Publication {
    private String publicationDay;

    public Newspaper(String title, int year, String publicationDay) {
        super(title, year);
        this.publicationDay = publicationDay;
    }

    @Override
    public String getType() {
        return "Газета";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Newspaper newspaper = (Newspaper) o;
        return Objects.equals(publicationDay, newspaper.publicationDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publicationDay);
    }

    public String getPublicationDay() {
        return publicationDay;
    }

    public void setPublicationDay(String publicationDay) {
        this.publicationDay = publicationDay;
    }

    @Override
    public String toString() {
        return getType() + super.toString() +
                ", Дата выхода - " + publicationDay;
    }

    @Override
    public void printDetails() {
        System.out.printf("\n%s: название - \"%s\", год выпуска - %d, день выпуска - %s",
                getType(), getTitle(), getYear(), getPublicationDay());
    }
}
