import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {
    public static void main(String[] args) throws Exception {
        boolean y = true;
        int x;
        ArrayList<Book> allBooks = new ArrayList<Book>();

        Scanner scan = new Scanner(System.in);
        while (y){
            System.out.println("0 - Выход, 1 - Добавление книги, 2 - Просмотр каталога книг, 3 - Поиск книг");
            x = scan.nextInt();
            switch (x) {
                case 0:
                    scan.close();
                    y = false;
                    break;
                case 1:
                    scan.nextLine();
                    System.out.print("Введите название книги: ");
                    String name = scan.nextLine();
                    System.out.print("Введите автора: ");
                    String author = scan.nextLine();
                    System.out.print("Год издания: ");
                    int year = scan.nextInt();
                    System.out.print("Цена: ");
                    int price = scan.nextInt();
                    Book book = new Book(name, author, year, price);
                    allBooks.add(book);
                    break;
                case 2:
                    int amount = 0;
                    for (Book books : allBooks) {
                        System.out.println(books.getId() + " " + books.getName() + " " + books.getAuthor() + " " + books.getYear() + " " + books.getPrice());
                        amount += books.getPrice();
                    }
                    System.out.println("Общая стоимость всех книг: " + amount);
                    break;
                case 3:
                    System.out.print("Введите максимальную цену: ");
                    int number = scan.nextInt();
                    for (Book books : allBooks) {
                        if (books.getPrice() <= number){
                            System.out.println(books.getId() + " " + books.getName() + " " + books.getAuthor() + " " + books.getYear() + " " + books.getPrice());
                        }
                    }
                    break;

                default:
                    break;
            }
        }
    }
}
