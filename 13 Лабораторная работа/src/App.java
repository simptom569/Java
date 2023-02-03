public class App {
    static void divisible(int[] n){
        System.out.println("Числа кратные 3 и 6:");
        for (int i : n) {
            if ((i % 3 == 0) && (i % 6 == 0)){
                System.out.println(i);
            }
        }
    }

    static void avearge(int[] n){
        int result = 0;
        int quantity = 0;
        for (int i : n) {
            result += i;
            quantity++;
        }

        System.out.println("Среднее арифметическое массива: " + ((float)result/quantity));
    }

    static void area_and_perimeter(int x, int y){
        System.out.println("Площадь треугольника равна: " + (float)((x*y)/2));
        System.out.println("Периметр треугольника равен: " + (float)(Math.sqrt((Math.pow(x, 2)+Math.pow(y, 2)))+x+y));
    }

    static void multiple(int x, int y){
        int min = x;
        int multiples = 0;
        if (min > y){
            min = y;
        }
        for (int i = 1; i < min; ++i){
            if ((x % i == 0) && (y % i == 0)){
                multiples = i;
            }
        }
        System.out.println("Наибольший общий множитель: " + multiples);
        for (int i = 2; i < min; ++i){
            if ((x % i == 0) && (y % i == 0)){
                multiples = i;
                break;
            }
        }
        System.out.println("Наименьшее общее кратное: " + multiples);
    }

    static void cone(int r, int h){
        double x;
        x = (Math.pow(r, 2)/3)*(double)h*Math.PI;
        System.out.println("Объем конуса равен: " + x);
    }

    public static void main(String[] args) throws Exception {
        int[] x = {213, 32134, 434, 4234, 3546, 231};
        for (int i : x) {
            System.out.print(i + " ");
        }
        System.out.println();
        divisible(x);
        avearge(x);
        System.out.println("Значения: 5 и 4");
        area_and_perimeter(5, 4);
        System.out.println("Значения: 144 и 180");
        multiple(144, 180);
        System.out.println("Значения: 3 и 4");
        cone(3, 4);
    }
}
