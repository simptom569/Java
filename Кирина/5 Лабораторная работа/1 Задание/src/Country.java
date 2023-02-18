public class Country {
    
    private String countryName;
    private double square;

    public Country(String name, double square){

        this.countryName = name;
        this.square = square;

    }

    public String getCountryName(){
        return countryName;
    }

    public double getSquare(){
        return square;
    }

}
