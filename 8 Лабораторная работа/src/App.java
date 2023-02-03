public class App {
    public static void main(String[] args) throws Exception {
        int a = 1123124;
        int b = 23;
        int c = 9293;
        int d = 1123124;
        int e = 68123;
        String name1 = "Егор";
        String name2 = "ЕГоР";
        int mounth = 10;
        
        Function function = new Function();
        int min = function.minimal_four(a, b, c, d);
        int kol_max_chisl = function.kol_max_chisl(a, b, c, d);
        int min_five = function.minimal_five(a, b, c, d, e);
        int max_five = function.maximum_five(a, b, c, d, e);
        String compare = function.compare(name1, name2);
        String season = function.seasons(mounth);

        System.out.print(a + " ");
        System.out.print(b + " ");
        System.out.print(c + " ");
        System.out.print(d + " ");
        System.out.println(e);
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(mounth);
        System.out.println("Минимально число среди четырех чисел: " + min);
        System.out.println("Количетсво максимальных чисел среди четырех: " + kol_max_chisl);
        System.out.println("Минимальное среди пяти чисел: " + min_five);
        System.out.println("максимальное среди пяти чисел: " + max_five);
        System.out.println(compare);
        System.out.println(season);
    }
}