import java.util.Date;

public class Transaction {
    
    private int amount;
    private Date date;
    private String note;

    Transaction(int amount, Date date, String note){
        this.amount = amount;
        this.date = date;
        this.note = note;
    }

    public int getAmount(){
        return amount;
    }

    public Date getDate(){
        return date;
    }

    public String getNote(){
        return note;
    }

}
