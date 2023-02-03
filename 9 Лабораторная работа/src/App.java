public class App {
    static void nechet_for(){
        System.out.println("Вывод от 1 до 99 циклом for:");
        for (int i=1; i < 100; i += 2){
            System.out.print(i + " ");
        }
    }

    static int factorial_for(int n){
        int g = 1;
        for (int j = n; j > 1; j--){
            g *= j;
        }
        return g;
    }

    static void nechet_while(){
        int i = 1;
        System.out.println("\n\nВывод от 1 до 99 циклом while:");
        while (i < 100){
            System.out.print(i + " ");
            i += 2;
        }
    }

    static int factorial_while(int n){
        int g = 1;
        while (n > 1){
            g *= n;
            n--;
        }
        return g;
    }

    static int pow(int x, int n){
        int result = 1;
        for (int i = 0; i < n; ++i){
            result *= x;
        }
        return result;
    }

    static void order(int n){
        int result = 0;
        for (int i = 0; i < n; ++i){
            if (i == n-1){
                System.out.println(result);
            }
            else{
                System.out.print(result + " ");
            }
            result -= 5;
        }
    }

    static void search(String text, char t){
        int kol = 0;
        for (int i = 0; i < text.length(); ++i){
            if (text.charAt(i) == t){
                kol++;
            }
            if (kol == 2){
                System.out.println("Символ встречается хотя бы два раза");
                break;
            }
        }
        if (kol < 2){
            System.out.println("Символ не встречается хотя бы два раза");
        }
    }

    public static void main(String[] args) throws Exception {
        nechet_for();
        System.out.println("\n\n5");
        System.out.println("факториал числа циклом for: " + factorial_for(5));
        nechet_while();
        System.out.println("\n\n5");
        System.out.println("факториал числа циклом while: " + factorial_while(5));
        System.out.println("\n\n6 в 3");
        System.out.println("Возведение в степень: " + pow(6, 3));
        System.out.println("\n\nПоследовательность чисел: ");
        order(10);
        System.out.println("\n\nПипевень е");
        search("Пипевень", 'е');
    }
}