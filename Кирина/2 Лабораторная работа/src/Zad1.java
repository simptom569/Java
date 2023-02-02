import java.util.Arrays;

public class Zad1 {
    private static int proizvedenie(int[] list){
        int result = 1;
        for (int i : list) {
            result *= i;
        }
        return result;
    }

    private static int nechet(int[] list){
        int result = 0;
        for (int i : list) {
            if (i % 2 != 0){
                result++;
            }
        }
        return result;
    }

    private static int kratnoe_3(int[] list){
        int result = 0;
        for (int i : list) {
            if (i % 3 == 0){
                result++;
            }
        }
        return result;
    }

    private static boolean uporadochen(int[] list){
        boolean result = true;
        int n = list[0];
        for (int i : list) {
            if (i < n){
                result = false;
                break;
            }
            n = i;
        }
        return result;
    }
    
    private static int[] izmenit(int[] list){
        Arrays.sort(list);
        return list;
    }

    public static void main(String[] args) throws Exception {
        int[] list = {-2, 181, 0, -10};
        System.out.println("Произведение всех чисел: " + proizvedenie(list));
        System.out.println("Количество нечетных: " + nechet(list));
        System.out.println("Количество чисел кратных трем: " + kratnoe_3(list));
        if (uporadochen(list)){
            System.out.println("Упорядочен");
        }
        else{
            System.out.println("не упорядочен");
        }
        System.out.println(Arrays.toString(izmenit(list)));
    }
}
