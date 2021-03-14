package dev.pariah.bankingApi.DaoServices;

import dev.pariah.bankingApi.representations.Transactions;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionDaoService {
    private List<Transactions> transactions = new ArrayList<>();
}
