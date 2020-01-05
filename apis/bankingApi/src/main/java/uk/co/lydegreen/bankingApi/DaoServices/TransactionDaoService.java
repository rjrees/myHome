package uk.co.lydegreen.bankingApi.DaoServices;

import org.springframework.stereotype.Component;
import uk.co.lydegreen.bankingApi.representations.Transactions;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionDaoService {
    private List<Transactions> transactions = new ArrayList<>();
}
