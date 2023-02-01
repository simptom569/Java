//13 вариант
public class Zad2 {
    public static void main(String[] args) {
        double x, y;
        x = 3.981*Math.pow(10, -2);
        y = -1.625*Math.pow(10, 3);
        if ((double)x/y>0){
            System.out.println(Math.pow(x+Math.log(Math.abs(y)), 3));
        }
        if((double)x/y<0){
            System.out.println((double)2/3+Math.log(Math.abs(Math.sin(y))));
        }
        else{
            System.out.println(Math.pow(Math.pow(Math.sin(y), 2), (double)1/3));
        }
    }
}
