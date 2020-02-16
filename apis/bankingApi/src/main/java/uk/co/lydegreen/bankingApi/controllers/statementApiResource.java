package uk.co.lydegreen.bankingApi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import uk.co.lydegreen.bankingApi.representations.*;

@RestController
public class statementApiResource {
    private Date startDate;
    private Date endDate;

    private Object Transactions;

    @RequestMapping(method = RequestMethod.GET, path = "/statement")
    public Object Transactions()
    {
        Transactions Transaction = new Transactions();
        Transaction.getTransaction(startDate, endDate );
        return Transactions;
    }
}