import java.util.Scanner;

public class Phone {
    
    private String brand;
    private String model;
    private int SIM_cards;
    private Instances[] instances;
    private Scanner scanner;

    Phone(String brand, String model, int SIM_cards, int instances){
        this.brand = brand;
        this.model = model;
        this.SIM_cards = SIM_cards;
        this.instances = new Instances[instances];
        scanner = new Scanner(System.in);

        for (int i = 0; i < instances; ++i){
            System.out.print("Введите цвет экземпляра:");
            String color = scanner.nextLine();
            System.out.print("Введите их количство на складе:");
            int number = scanner.nextInt();
            scanner.nextLine();
            this.instances[i] = new Instances(color, number);
        }

    }

    public String get_brand(){
        return brand;
    }

    public String get_model(){
        return model;
    }

    public int get_SIM_cards(){
        return SIM_cards;
    }

    public Instances[] get_instances(){
        return instances;
    }

    public void closed_scanner(){
        scanner.close();
    }

}
