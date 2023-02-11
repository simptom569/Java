public class Instances {
    
    private String color;
    private int number;

    Instances(String color, int number){
        this.color = color;
        this.number = number;
    }

    public String get_color(){
        return color;
    }

    public int get_number(){
        return number;
    }

}
