import java.util.Arrays;

public class Zad2 {
    private static int[][] create_matrix(int x, int y){
        int[][] list = new int[x][y];
        for (int i = 0; i < x; ++i){
            for (int j = 0; j < y; ++j){
                list[i][j] = (int)(Math.random() * 199 - 100);
            }
        }
        for (int[] is : list) {
            System.out.println(Arrays.toString(is));
        }
        return list;
    }

    private static int proizvedenie_poboch(int[][] list){
        int result = 1;
        for (int i = list.length - 1; i >= 0; --i){
            result *= list[i][list.length - 1 - i];
        }
        return result;
    }

    private static int polozhitel(int[][] list){
        int result = 0;
        for (int i = 0; i < list.length; ++i){
            for (int j = 0; j < i; ++j){
                if (list[i][j] >= 0){
                    result++;
                }
            }
        }
        return result;
    }

    private static int minimal(int[][] list){
        int min = 0;
        for (int i = 0; i < list[0].length; ++i){
            min = list[i][i];
            for (int j = 0; j < list.length; ++j){
                if (list[j][i] < min){
                    min = list[j][i];
                }
                // System.out.println(list[j][i]);
            }
            System.out.println("Минимальное значение " + (i + 1) + " столбца: " + min);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(proizvedenie_poboch(create_matrix(3, 3)));
        System.out.println(polozhitel(create_matrix(3, 3)));
        minimal(create_matrix(3, 3));
    }
}