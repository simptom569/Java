import java.util.Scanner;

public class BankApplication {
    public static void main(String[] args) throws Exception {
        String fio;
        int balance;
        int x;
        boolean y = true;

        Scanner scan = new Scanner(System.in);
        System.out.print("Введите фио: ");
        fio = scan.nextLine();
        System.out.print("Введите начальный баланс: ");
        balance = scan.nextInt();
        BankAccount account = new BankAccount(fio, balance);
        while (y){
            System.out.println("0 - выйти, 1 - Пополнить, 2 - снять, 3 - Вывести историю транзакций");
            x = scan.nextInt();
            
            switch (x) {
                case 0:
                    y = false;
                    scan.close();
                    break;
                case 1:
                    System.out.print("Введите сумму транзакции: ");
                    balance = scan.nextInt();
                    account.addTransaction(balance, "Пополнение");
                    break;
                case 2:
                    System.out.print("Сумма снятия:");
                    balance = scan.nextInt();
                    account.minusTransaction(balance, "Снятие");
                    break;
                case 3:
                    account.getAllTransaction();
                    break;

                default:
                    break;
            }
        }
    }
}
