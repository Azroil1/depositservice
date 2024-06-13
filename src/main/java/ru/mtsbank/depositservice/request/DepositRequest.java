package ru.mtsbank.depositservice.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositRequest {
    private String depositType;
    private int monthsDeposits;
    private BigDecimal amount;
    private String percentType;
    private int transferAccount;


}
