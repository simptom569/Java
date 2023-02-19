//1 Вариант
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Car> cars = new ArrayList<Car>();

        String model;
        String regNumber;
        int year;
        int mileage;
        double price;

        System.out.print("Введите количество машин:");
        int count = scanner.nextInt();

        for (int i = 0; i < count; ++i) {
            System.out.print("Введите модель машины:");
            scanner.nextLine();
            model = scanner.nextLine();
            System.out.print("Введите рег номер:");
            regNumber = scanner.nextLine();
            System.out.print("Введите год выпуска машины:");
            year = scanner.nextInt();
            System.out.print("Введите пробег:");
            mileage = scanner.nextInt();
            System.out.print("Введите стоимость машины:");
            price = scanner.nextDouble();

            cars.add(new Car(model, regNumber, year, mileage, price));
        }

        int min_number = 0;
        double min = cars.get(0).getPrice();

        for (int i = 0; i < cars.size(); ++i) {
            if (cars.get(i).getPrice() < min){
                min_number = i;
                min = cars.get(i).getPrice();
            }
        }
        
        System.out.println();
        System.out.println("Автомобиль с наименьшей стоимость:" + cars.get(min_number).getModel() + " Его стоимость:" + cars.get(min_number).getPrice());
        System.out.println();

        for (int i = 0; i < cars.size(); ++i) {
            for (int j = 0; j < cars.size() - i - 1; ++j){
                if (cars.get(j).getYear() < cars.get(j+1).getYear()){
                    Car car = cars.get(j);
                    cars.set(j, cars.get(j+1));
                    cars.set(j+1, car);
                }
            }
        }
        
        System.out.println();
        System.out.println("Машина\tГод выпуска");
        for (Car car : cars) {
            System.out.println(car.getModel() + "\t" + car.getYear());
        }
        System.out.println();

        System.out.println();
        System.out.print("Введите рег номер по которому нужно искать:");
        scanner.nextLine();
        String regNumber1 = scanner.nextLine();
        int regcar = -1;
        for (int i = 0; i < cars.size(); ++i){
            if (cars.get(i).getRegNumber().equals(regNumber1)){
                regcar = i;
            }
        }
        if (regcar > -1){
            System.out.print("Введите цену для данной модели:");
            price = scanner.nextDouble();
            cars.get(regcar).setPrice(price);
            System.out.println(cars.get(regcar).getModel() + "\t" + cars.get(regcar).getRegNumber() + "\t" + cars.get(regcar).getYear() + "\t" + cars.get(regcar).getMileage() + "\t" + cars.get(regcar).getPrice());
            System.out.println();
        }
        else{
            System.out.println("Такой машины нет");
        }

        scanner.close();

    }
}
