package dev.pariah.blog.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import dev.pariah.blog.representations.*;

import java.sql.Date;

@RestController
public class blogPostApi {
    private Date startDate;
    private Date endDate;

    private Object Transactions;

    @RequestMapping(method = RequestMethod.GET, path = "/blogPost")
    public Object Transactions()
    {
        dev.pariah.bankingApi.representations.Transactions Transaction = new Transactions();
        Transaction.getPost;
        return Transactions;
    }
}
