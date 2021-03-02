package uk.co.lydegreen.bankingApi.representations;


import java.sql.Date;
import java.util.List;

public class Transactions {

    private String DateTransactionDate;
    private String TransactionType;
    private String SortCode;
    private long AccountNumber;
    private String TransactionDescription;
    private long DebitAmount;
    private long CreditAmount;
    private long Balance;

    public String getDateTransactionDate() {
        return DateTransactionDate;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public String getSortCode() {
        return SortCode;
    }

    public long getAccountNumber() {
        return AccountNumber;
    }

    public String getTransactionDescription() {
        return TransactionDescription;
    }

    public long getDebitAmount() {
        return DebitAmount;
    }

    public long getCreditAmount() {
        return CreditAmount;
    }

    public long getBalance() {
        return Balance;
    }

    public void getTransaction(Date StartDate, Date FinishDate) {

    }
}

  /*  public Transactions(String dateTransactionDate, String transactionType, String sortCode, long accountNumber, String transactionDescription, long debitAmount, long creditAmount, long balance) {
        DateTransactionDate = dateTransactionDate;
        TransactionType = transactionType;
        SortCode = sortCode;
        AccountNumber = accountNumber;
        TransactionDescription = transactionDescription;
        DebitAmount = debitAmount;
        CreditAmount = creditAmount;
        Balance = balance;
    } */
