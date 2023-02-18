import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in, "Cp866");
        ArrayList<Country> countries = new ArrayList<Country>();
        boolean tf = true;

        System.out.print("Введите количество стран:");
        int count = scanner.nextInt();

        for (int i = 0; i < count; ++i) {

            String name;
            double square;

            scanner.nextLine();
            System.out.print("Введите название страны:");
            name = scanner.nextLine();
            System.out.print("Введите площадь страны:");
            square = scanner.nextDouble();

            countries.add(new Country(name, square));

        }

        while (tf){

            System.out.println("Выберите операцию: 1-показать таблицу стран, 2-показать страну с наибольшей площадью, 3-сортировать по возрастания площадей, 4-сортировать по алфавиту, 5-показать среднюю площадь, 6-найти страну, 0-выход из программы");
            int number = scanner.nextInt();

            switch (number) {
                case 0:
                    scanner.close();
                    tf = false;
                    break;
                case 1:
                    if (countries.size() > 0){
                        System.out.println();
                        System.out.println("Список стран");
                        System.out.println("№\tНазвание страны\t\tПлощадь страны");
                    }
                    for (int i = 0; i < countries.size(); ++i) {
                        System.out.println((i + 1) + "\t" + countries.get(i).getCountryName() + "\t\t" + countries.get(i).getSquare() + " млн. кв. м.");
                    }
                    System.out.println();
                    break;
                case 2:
                    double square = countries.get(0).getSquare();
                    int max_number = 0;

                    System.out.println();
                    for (int i = 0; i < countries.size(); ++i) {
                        if (countries.get(i).getSquare() > square){
                            square = countries.get(i).getSquare();
                            max_number = i;
                        }
                    }

                    System.out.println("№\tНазвание страны\t\tПлощадь страны");
                    System.out.println((max_number + 1) + "\t" + countries.get(max_number).getCountryName() + "\t\t" + countries.get(max_number).getSquare());
                    System.out.println();
                    break;
                case 3:
                    for (int i = 0; i < countries.size(); ++i){
                        for (int j = 0; j < countries.size() - 1 - i; ++j){
                            if (countries.get(j).getSquare() > countries.get(j+1).getSquare()){
                                Country country = countries.get(j);
                                countries.set(j, countries.get(j+1));
                                countries.set(j+1, country);
                            }
                        }
                    }
                    System.out.println();
                    System.out.println("Список стран");
                    System.out.println("№\tНазвание страны\t\tПлощадь страны");
                    for (int i = 0; i < countries.size(); ++i) {
                        System.out.println((i + 1) + "\t" + countries.get(i).getCountryName() + "\t\t" + countries.get(i).getSquare() + " млн. кв. м.");
                    }
                    System.out.println();
                    break;
                case 4:
                    for (int i = 0; i < countries.size(); ++i){
                        for (int j = 0; j < countries.size() - 1 - i; ++j){
                            if (countries.get(j).getCountryName().compareTo(countries.get(j+1).getCountryName()) > 0){
                                Country country = countries.get(j);
                                countries.set(j, countries.get(j+1));
                                countries.set(j+1, country);
                            }
                        }
                    }
                    System.out.println();
                    System.out.println("Список стран");
                    System.out.println("№\tНазвание страны\t\tПлощадь страны");
                    for (int i = 0; i < countries.size(); ++i) {
                        System.out.println((i + 1) + "\t" + countries.get(i).getCountryName() + "\t\t" + countries.get(i).getSquare() + " млн. кв. м.");
                    }
                    System.out.println();
                    break;
                case  5:
                    double square1 = 0;
                    for (Country country : countries) {
                        square1 += country.getSquare();
                    }
                    square1 /= countries.size();

                    System.out.println();
                    System.out.println(square1 + " млн. кв. м.");
                    System.out.println();
                    break;
                case 6:
                    System.out.println();
                    System.out.print("Введите название страны:");
                    scanner.nextLine();
                    String search = scanner.nextLine();
                    System.out.println();
                    System.out.println("Список стран");
                    System.out.println("№\tНазвание страны\t\tПлощадь страны");
                    for (int i = 0; i < countries.size(); ++i) {
                        if(countries.get(i).getCountryName().equals(search)){
                            System.out.println((i + 1) + "\t" + countries.get(i).getCountryName() + "\t\t" + countries.get(i).getSquare() + " млн. кв. м.");
                        }
                    }
                    System.out.println();
                
                default:
                    break;
            }

        }

    }
}
