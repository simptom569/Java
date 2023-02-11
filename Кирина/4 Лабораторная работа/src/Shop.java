import java.util.ArrayList;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Phone> phones = new ArrayList<Phone>();
        boolean x = true;
        int key;

        while (x){
            System.out.println("0-выход, 1-добавить телефон, 2-вывести все телефоны");
            key = scanner.nextInt();
            switch (key) {
                case 0:
                    x = false;
                    scanner.close();
                    break;
                case 1:
                    scanner.nextLine();
                    System.out.print("Введите марку телефона:");
                    String brand = scanner.nextLine();
                    System.out.print("Введите модель телефона:");
                    String model = scanner.nextLine();
                    System.out.print("Введите количество СИМ карт:");
                    int SIM_cards = scanner.nextInt();
                    System.out.print("Введите количство экземпляров:");
                    int instances = scanner.nextInt();
                    phones.add(new Phone(brand, model, SIM_cards, instances));
                    break;
                case 2:
                    if (phones.size() != 0){
                        System.out.println("Марка \t Модель \t Кол-во SIM \t Кол-во экземпляров");
                        for (Phone phone : phones) {
                            System.out.println(phone.get_brand() + "\t" + phone.get_model() + "\t\t" + phone.get_SIM_cards() + "\t\t" + phone.get_instances().length);
                            if (phone.get_instances().length != 0){
                                System.out.println();
                                System.out.println("\tЦвет \t Кол-во на складе");
                                for (Instances instance : phone.get_instances()) {
                                    System.out.println("\t" + instance.get_color() + "\t\t" + instance.get_number());
                                }
                            }
                            System.out.println("\n");
                        }
                    }
                    break;

                default:
                    break;
            }
        }

    }
}