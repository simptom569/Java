public class App {
    static void divisible(int[] n){
        System.out.println("Числа кратные 3 и 6:");
        for (int i : n) {
            if ((i % 3 == 0) && (i % 6 == 0)){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int[] x = {213, 32134, 434, 4234, 3546, 231};
        divisible(x);
    }
}
