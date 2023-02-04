public class Book {
    
    private int InvN;
    private String Name;
    private String Author;
    private int Year;
    private int Price;
    private static int number = 0;

    Book(String name, String author, int year, int price){
        number++;
        this.InvN = number;
        this.Name = name;
        this.Author = author;
        this.Year = year;
        this.Price = price;

        System.out.println("Книга Добавлена: ее номер " + InvN);
    }

    public String getName(){
        return Name;
    }

    public String getAuthor(){
        return Author;
    }

    public int getYear(){
        return Year;
    }

    public int getPrice(){
        return Price;
    }

    public int getId(){
        return InvN;
    }

}
