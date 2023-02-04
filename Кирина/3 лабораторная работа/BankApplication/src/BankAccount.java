import java.util.ArrayList;
import java.util.Date;

public class BankAccount {
    
    private ArrayList<Transaction> allTransactions = new ArrayList<Transaction>();
    private String fio;
    private int balance;
    private int number;
    private static int accountNumber = 1223124213;

    BankAccount(String fio, int balance){
        this.fio = fio;
        this.balance = balance;
        accountNumber++;
        this.number = accountNumber;

        System.out.println("Создан новый банковский счет: " + this.number);
        System.out.println("Владелец: " + this.fio);
        System.out.println("Начальный баланс: " + this.balance);
    }

    public void addTransaction(int number, String note){
        if (number <= 0){
            System.out.println("Число должно быть больше нуля");
        }
        else{
            Transaction transaction = new Transaction(number, new Date(), note);
            allTransactions.add(transaction);
        }
    }

    public void minusTransaction(int number, String note){
        if (number <= 0){
            System.out.println("Число должно быть больше нуля");
        }
        else{
            if (getBalance() < number){
                System.out.println("Не хватает средств");
            }
            else{
                Transaction transaction = new Transaction(-number, new Date(), note);
                allTransactions.add(transaction);
            }
        }
    }

    public void getAllTransaction(){
        for (Transaction transaction : allTransactions) {
            System.out.println("Все транзакции:");
            System.out.println("Сумма:" + transaction.getAmount() + " Дата:" + transaction.getDate() + " Коммент:" + transaction.getNote());
        }
    }

    public int getBalance(){
        int amount = 0;
        for (Transaction transaction : allTransactions) {
            amount += transaction.getAmount();
        }
        return amount;
    }

}
