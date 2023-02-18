public class Car {
    
    private String model;
    private String regNumber;
    private int year;
    private int mileage;
    private double price;

    public Car(String model, String regNumber, int year, int mileage, double price){
        this.model = model;
        this.regNumber = regNumber;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    public String getModel(){
        return model;
    }

    public String getRegNumber(){
        return regNumber;
    }

    public int getYear(){
        return year;
    }

    public int getMileage(){
        return mileage;
    }

    public double getPrice(){
        return price;
    }

}
