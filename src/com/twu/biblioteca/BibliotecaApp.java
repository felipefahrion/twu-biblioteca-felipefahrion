package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidOptionException;
import com.twu.biblioteca.interfaces.Option;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.options.CheckoutBook;
import com.twu.biblioteca.options.ListOfBooks;
import com.twu.biblioteca.options.ReturnBook;

import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        WelcomeMessage welcomeMessage = new WelcomeMessage();
        System.out.println(welcomeMessage.initilize() + "\n");

        Menu menuOptions = new Menu(options(bookList()));

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println(menuOptions.showMenu());

            try {
                menuOptions.chooseOption(in.nextLine());
            } catch (InvalidOptionException ex) {
                System.out.println(ex.getMessage());
            }

            System.out.print("\n");
        }
    }

    private static List<Book> bookList() {
        return new ArrayList<Book>(Arrays.asList(
                new Book("The Godfather", "Francis Ford Coppola", "1972"),
                new Book("Pulp Fiction", "Quentin Tarantino", "1994"),
                new Book("Schindlers List", "Steven Spielberg", "1994"),
                new Book("The Dark Knight", "Christopher Nolan", "2008"),
                new Book("The Lord of the Rings: The Return of the King", "Peter Jackson", "2003", true),
                new Book("Star Wars", "George Lucas", "1977"),
                new Book("The Matrix", "The Wachowski Brothers", "1999"),
                new Book("Forrest Gump", "Robert Zemeckis", "1994"),
                new Book("Monty Python and the Holy Grail", " Terry Gilliam & Terry Jones", "1975"),
                new Book("2001: A Space Odyssey", "Stanley Kubrick", "1968"),
                new Book("Back to the Future", "Robert Zemeckis", "1989"),
                new Book("Monsters Inc", "Pete Docter & David Silverman", "2001"),
                new Book("Jurassic Park", "Steven Spielberg", "1993"),
                new Book("The Empire Strikes Back", "Irvin Kershner", "1980", true),
                new Book("Return of the Jedi", "Richard Marquand", "1983"),
                new Book("GoldenEye", "Martin Campbell", "1995"),
                new Book("The World Is Not Enough", "Michael Apted", "1999"),
                new Book("Die Another Day", "Lee Tamahori", "2003"),
                new Book("Tomorrow Never Dies", "Roger Spottiswoode", "1998"),
                new Book("Skyfall", "Sam Mendes", "2012", true),
                new Book("Casino Royale", "Martin Campbell", "2006"))
        );
    }

    private static LinkedHashMap<String, Option> options(List<Book> books){
        LinkedHashMap<String, Option> options = new LinkedHashMap<String, Option>();

        options.put("1", new ListOfBooks(books));
        options.put("2", new CheckoutBook(books));
        options.put("3", new ReturnBook(books));

        return options;
    }
}