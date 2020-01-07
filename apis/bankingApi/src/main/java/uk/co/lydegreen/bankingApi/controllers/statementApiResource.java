package uk.co.lydegreen.bankingApi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

import uk.co.lydegreen.bankingApi.representations.*;

@RestController
public class statementApiResource {


    @RequestMapping(method = RequestMethod.GET, path = "/statement")
    public List<Transactions> Transactions()
    {
        Transactions Transaction = new Transactions;
        Transaction.getTransaction();
        return (List<Transactions>) Transaction;
    }
}