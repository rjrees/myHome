package dev.pariah.bankingApi.controllers;

import dev.pariah.bankingApi.representations.Transactions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

import dev.pariah.bankingApi.representations.*;

@RestController
public class statementApiResource {
    private Date startDate;
    private Date endDate;

    private Object Transactions;

    @RequestMapping(method = RequestMethod.GET, path = "/statement")
    public Object Transactions()
    {
        dev.pariah.bankingApi.representations.Transactions Transaction = new Transactions();
        Transaction.getTransaction(startDate, endDate );
        return Transactions;
    }
}