import java.util.Arrays;

public class App {
    static void create_array(){
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int g = 1;

        System.out.print("Вывод первых 10 нечетных чисел: ");
        for (int i : array) {
            if (g++ == array.length){
                System.out.println(i);
            }
            else{
                System.out.print(i + ", ");
            }
        }
    }

    static void mins_array(int[] array){
        int min = array[0];
        
        System.out.print("Минимальные значения из N размерного массива:");
        for (int i : array) {
            if (min > i){
                min = i;
            }
        }
        for (int i : array) {
            if (min == i){
                System.out.print(" " + i);
            }
        }
    }

    static void max_array(int[] array){
        int max = array[0];
        
        System.out.print("\nМаксимальное значение N размерного массива: ");
        for (int i : array) {
            if (max < i){
                max = i;
            }
        }

        System.out.println(max);
    }

    static void change_array(int[] array){
        int min = array[0];
        int max = array[0];
        int i_min = 0;
        int i_max = 0;

        System.out.println("Массив до изменений: " + Arrays.toString(array));

        for (int i : array) {
            if (min > i){
                min = i;
            }
            if (max < i){
                max = i;
            }
        }

        for (int i = 0; i < array.length; ++i){
            if (array[i] == min){
                i_min = i;
            }
            if (array[i] == max){
                i_max = i;
            }
        }

        array[i_min] = max;
        array[i_max] = min;

        System.out.println("Массив после изменений: " + Arrays.toString(array));
    }

    static void average(int[] array){
        int count = 0;
        int summa = 0;
        
        for (int i : array) {
            summa += i;
            count++;
        }
        System.out.println("Среднее арифметическое: " + ((float) summa/count));
    }

    public static void main(String[] args) throws Exception {
        int[] array = {12, 43, 1331, 4, 6, 2, 9, 77, 9};

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        create_array();
        mins_array(array);
        max_array(array);
        change_array(array);
        average(array);
    }
}