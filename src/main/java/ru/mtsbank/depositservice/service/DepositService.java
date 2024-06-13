package ru.mtsbank.depositservice.service;

import org.springframework.stereotype.Service;
import ru.mtsbank.depositservice.entity.CustomerDeposit;
import ru.mtsbank.depositservice.entity.Deposit;
import ru.mtsbank.depositservice.feignclient.AccountServiceClient;
import ru.mtsbank.depositservice.repository.CustomerDepositsRepository;
import ru.mtsbank.depositservice.repository.DepositsRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepositService {
    private DepositsRepository depositsRepository;
    private final AccountServiceClient accountServiceClient;
    private CustomerDepositsRepository customerDepositsRepository;
    public DepositService(DepositsRepository depositsRepository, AccountServiceClient accountServiceClient, CustomerDepositsRepository customerDepositsRepository) {
        this.depositsRepository = depositsRepository;
        this.accountServiceClient = accountServiceClient;
        this.customerDepositsRepository = customerDepositsRepository;
    }
    public List<Deposit> getDeposits(int id) {
        List<Deposit> deposits = new ArrayList<>();
        List<CustomerDeposit> customerDeposits = customerDepositsRepository.findByCustomerId(id);
        for (CustomerDeposit customerDeposit : customerDeposits) {
            deposits.add(depositsRepository.findDepositById(customerDeposit.getCustomerId()));
        }
        return deposits;
    }
    public BigDecimal getBalance(String token) {
        return accountServiceClient.getAccountBalance(token);
    }

}
