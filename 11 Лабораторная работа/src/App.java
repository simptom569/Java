import java.util.Arrays;

public class App {
    static void sort_array(){
        int[] array = new int[20];
        for (int i = 0; i < 20; ++i){
            array[i] = (int)( Math.random() * 1000);
        }
        System.out.println("Массив до сортировки: " + Arrays.toString(array));
        for (int i = 0; i < array.length - 1; ++i){
            for (int j = i + 1; j < array.length; ++j){
                if (array[i] < array[j]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
       }
       System.out.println("Массив после сортировки: " + Arrays.toString(array));
    }

    static void sort_array_car(){
        String[] array = {"Audi", "Volkswagen", "Mercedes", "BMW", "Ford", "Cherry", "Lada", "Kia", "Hyundai", "Honda", "Mazda"};
        System.out.println("Массив до сортировки: " + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Массив после сортировки: " + Arrays.toString(array));
    }

    public static void main(String[] args) throws Exception {
        sort_array();
        sort_array_car();
    }
}
