package uk.co.lydegreen.representations;

import javassist.runtime.Desc;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.text.DateFormat;

/**
 * Created by richard on 24/08/16.
 */
public class Statement {

    private final int id;

    @NotBlank
    @Length(min =2, max = 10)
    private final String UID;

    @NotBlank
    private final boolean Public;

    @NotBlank
    @Length(min =2, max = 10)
    private final java.sql.Date TransactionDate;

    @NotBlank
    @Length(min = 2, max = 4)
    private final String Type;

    @NotBlank
    @Length(min = 2, max = 8)
    private final String SortCode;

    @NotBlank
    @Length(min = 2, max = 30)
    private final int AccountNumber;

    @NotBlank
    @Length(min = 2, max = 30)
    private final String Description;

    @NotBlank
    @Length(min = 2, max = 30)
    private final int Credit;

    @NotBlank
    @Length(min = 2, max = 11)
    private final int Debit;

    @NotBlank
    @Length(min = 2, max = 11)
    private final int Balance;

    @NotBlank
    @Length(min = 2, max = 11)
    private final int acl;


    public Statement (int id,String UID, boolean Public, java.sql.Date TransactionDate, String Type, String SortCode, int AccountNumber, String Description, int Credit, int Debit, int Balance, int acl )
    {
        this.id = id;
        this.UID = UID;
        this.Public = Public;
        this.TransactionDate = TransactionDate;
        this.Type = Type;
        this.SortCode = SortCode;
        this.AccountNumber = AccountNumber;
        this.Description = Description;
        this.Credit = Credit;
        this.Debit = Debit;
        this.Balance = Balance;
        this.acl = acl;

    }


    public int getId() {
        return id;
    }
}
