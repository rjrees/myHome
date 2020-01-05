package uk.co.lydegreen.bankingApi.representations;


import java.util.List;

public class Transactions {

    String DateTransactionDate;
    String TransactionType;
    String SortCode;
    long AccountNumber;
    String TransactionDescription;
    long DebitAmount;
    long CreditAmount;
    long Balance;

    public String getTransaction() {
        return DateTransactionDate;
        //return (DateTransactionDate, TransactionType, SortCode, AccountNumber, TransactionDescription, DebitAmount, CreditAmount, Balance);
    }


    public Transactions(String dateTransactionDate, String transactionType, String sortCode, long accountNumber, String transactionDescription, long debitAmount, long creditAmount, long balance) {
        DateTransactionDate = dateTransactionDate;
        TransactionType = transactionType;
        SortCode = sortCode;
        AccountNumber = accountNumber;
        TransactionDescription = transactionDescription;
        DebitAmount = debitAmount;
        CreditAmount = creditAmount;
        Balance = balance;
    }
}