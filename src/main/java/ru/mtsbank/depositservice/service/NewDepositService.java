package ru.mtsbank.depositservice.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.mtsbank.depositservice.dto.DepositDto;
import ru.mtsbank.depositservice.dto.RequestDto;
import ru.mtsbank.depositservice.entity.Deposit;
import ru.mtsbank.depositservice.exception.NoMoneyException;
import ru.mtsbank.depositservice.mapperentitytodto.DepositMapper;
import ru.mtsbank.depositservice.repository.CustomerDepositsRepository;
import ru.mtsbank.depositservice.repository.DepositTypeRepository;
import ru.mtsbank.depositservice.repository.DepositsRepository;
import ru.mtsbank.depositservice.request.DepositRequest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class NewDepositService {
    DepositsRepository depositsRepository;
    CustomerDepositsRepository customerDepositsRepository;
    DepositTypeRepository depositTypeRepository;
    public NewDepositService(DepositsRepository depositsRepository,
                             CustomerDepositsRepository customerDepositsRepository,
                             DepositTypeRepository depositTypeRepository) {
        this.depositsRepository = depositsRepository;
        this.customerDepositsRepository = customerDepositsRepository;
        this.depositTypeRepository = depositTypeRepository;
    }

    @Async
    public void checkNewDeposit(DepositRequest request, int customerId, int accountId) throws NoMoneyException, InterruptedException {
        RequestDto requestDto = new RequestDto();
        requestDto.setCustomerId(customerId);
        requestDto.setRequestDate(LocalDateTime.now());
        DepositDto depositDto = new DepositDto();
        depositDto.setDepositAccountId(accountId);
        depositDto.setDepositTypeId(depositTypeRepository.findByDepositTypesName(request.getDepositType()));
        if(request.getMonthsDeposits() > 12){
            request.setMonthsDeposits(12);
        }
        depositDto.setDepositAmount(request.getAmount());
        System.out.println("Заявка заведна");
        Thread.sleep(10000);
        switch (request.getPercentType()) {
            case ("Cо снятием и пополнением"):
                depositDto.setDepositRate(new BigDecimal("4.2"));
                depositDto.setDepositRefill(true);
                break;
            case ("Со снятием и без пополнения"):
                depositDto.setDepositRate(new BigDecimal("6"));
                break;
            case ("Без снятия"):
                depositDto.setDepositRate(new BigDecimal("10"));
        }
        depositDto.setStartDate(LocalDateTime.now());
        if(request.getAmount().intValue() > 10000) {
            System.out.println("Заявка одобренна");
            depositDto.setEndDate(depositDto.getStartDate().plusMinutes(request.getMonthsDeposits()));
        }
        else{
            System.out.println("Заявка отлконена");
        }
        Deposit save = depositsRepository.save(DepositMapper.map(depositDto));
    }

}
