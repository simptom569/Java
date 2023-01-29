import java.util.Arrays;

public class App {
    static int[][] create_array(int x, int y){
        int[][] array = new int[x][y];
        for (int i = 0; i < array.length; ++i){
            for (int j = 0; j <array[i].length; ++j){
                array[i][j] = (int)(Math.random() * 199 - 100);
            }
        }
        return array;
    }

    static void addition_array(int[][] C, int[][] D){
        int[][] A = new int[C.length][C[0].length];
        for (int i = 0; i < C.length; ++i){
            for (int j = 0; j < C[i].length; ++j){
                A[i][j] = C[i][j] + D[i][j];
            }
        }
        System.out.println("Матрица C + D:");
        for (int i = 0; i < A.length; ++i){
            System.out.println(Arrays.toString(A[i]));
        }
    }

    static void multiplication_array(int[][] C, int[][] D){
        int[][] A = new int[C.length][D[0].length];
        for (int i = 0; i < A.length; ++i){
            for (int j = 0; j < A[i].length; ++j){
                for (int l = 0; l < D.length; ++l){
                    A[i][j] += C[i][l] * D[l][j];
                }
            }
        }
        System.out.println("Матрица C * D:");
        for (int i = 0; i < A.length; ++i){
            System.out.println(Arrays.toString(A[i]));
        }
    }

    static void sum_array(int[][] n){
        int sum = 0;
        for (int i = 0; i < n.length; ++i){
            for (int j = 0; j < n[i].length; ++j){
                sum += n[i][j];
            }
        }
        System.out.println("Сумма всех чисел двумерного массива: " + sum);
    }

    static void odd_array(int[][] n){
        System.out.println("Ячейки нечетныйх чисел:");
        for (int i = 0; i < n.length; ++i){
            for (int j = 0; j < n[i].length; ++j){
                if (n[i][j] < 0){
                    System.out.println(i + "x" + j + " = " + n[i][j]);
                }
            }
        }
    }

    static void sort_array(int[][] n){
        System.out.println("Массив до сортировки:");
        for (int i = 0; i< n.length; ++i){
            System.out.println(Arrays.toString(n[i]));
        }
        for (int i = 0; i < n.length; ++i){
            Arrays.sort(n[i]);
        }
        System.out.println("Массив после сортировки:");
        for (int i = 0; i< n.length; ++i){
            System.out.println(Arrays.toString(n[i]));
        }
    }

    public static void main(String[] args) throws Exception {
        int[][] C = create_array(3, 3);
        int[][] D = create_array(3, 3);

        System.out.println("3 строка с размерностью 5 на 6: " + Arrays.toString(create_array(5, 6)[3]));
        System.out.println("Матрица C:");
        for (int i = 0; i < C.length; ++i){
            System.out.println(Arrays.toString(C[i]));
        }
        System.out.println("Матрица D:");
        for (int i = 0; i < D.length; ++i){
            System.out.println(Arrays.toString(D[i]));
        }
        addition_array(C, D);
        multiplication_array(C, D);
        sum_array(create_array(2, 2));
        odd_array(create_array(2, 2));
        sort_array(create_array(2, 2));
    }
}
