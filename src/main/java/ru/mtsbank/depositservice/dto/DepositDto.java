package ru.mtsbank.depositservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.mtsbank.depositservice.entity.CustomerDeposit;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepositDto {
    private CustomerDeposit customerDeposit;
    private int depositAccountId;
    private int depositTypeId;
    private Boolean depositRefill;
    private BigDecimal depositAmount;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private BigDecimal depositRate;
    private int typePercentPaymentId;
    private LocalDate percentPaymentDate;
    private int percentPaymentAccountId;
    private boolean capitalization;
    private int depositRefundAccountId;
}
