public class Zad3 {
    public static void main(String[] args) {
        double a, b, h, x;
        a = 0.1;
        b = 1.2;
        h = 0.1;
        x = a;
        while (x<=b){
            x += h;
            for (int n = 1; n<=20; n++){
                System.out.println((double)((Math.pow(x, 2*n-2))/(4*Math.cos(n*Math.pow(x, 2)))));
            }
        }
    }
}