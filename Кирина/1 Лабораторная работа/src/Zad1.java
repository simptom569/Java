//13 Вариант
public class Zad1 {
    public static void main(String[] args) throws Exception {
        double a, x, y, z;
        x = 3.981 * Math.pow(10, -2);
        y = -1.625 * Math.pow(10, 3);
        z = 0.512;
        a = Math.pow(2, -x);
        a *= Math.pow(x+Math.pow(Math.abs(y), (double)1/4), (double)1/2);
        a *= Math.pow(Math.pow(Math.E, x-(double)1/Math.sin(z)), (double)1/3);
        System.out.println(a);
    }
}
