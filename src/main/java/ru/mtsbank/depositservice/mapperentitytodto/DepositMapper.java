package ru.mtsbank.depositservice.mapperentitytodto;

import ru.mtsbank.depositservice.dto.DepositDto;
import ru.mtsbank.depositservice.entity.Deposit;

public class DepositMapper {
    public static Deposit map(DepositDto depositDto) {
        Deposit deposit = new Deposit();
        deposit.setCustomerDeposits(depositDto.getCustomerDeposit());
        deposit.setDepositAmount(depositDto.getDepositAmount());
        deposit.setDepositAccountId(depositDto.getDepositAccountId());
        deposit.setDepositTypeId(depositDto.getDepositTypeId());
        deposit.setDepositRefill(depositDto.getDepositRefill());
        deposit.setStartDate(depositDto.getStartDate());
        deposit.setEndDate(depositDto.getEndDate());
        deposit.setDepositRate(depositDto.getDepositRate());
        deposit.setTypePercentPaymentId(depositDto.getTypePercentPaymentId());
        deposit.setPercentPaymentDate(depositDto.getPercentPaymentDate());
        deposit.setPercentPaymentAccountId(depositDto.getPercentPaymentAccountId());
        deposit.setCapitalization(depositDto.isCapitalization());
        deposit.setDepositRefundAccountId(depositDto.getDepositRefundAccountId());
        return deposit;
    }
    public static DepositDto mapToDto(Deposit deposit) {
        DepositDto depositDto = new DepositDto();
        depositDto.setCustomerDeposit(deposit.getCustomerDeposits());
        depositDto.setDepositAmount(deposit.getDepositAmount());
        depositDto.setDepositAccountId(deposit.getDepositAccountId());
        depositDto.setDepositTypeId(deposit.getDepositTypeId());
        depositDto.setDepositRefill(deposit.getDepositRefill());
        depositDto.setStartDate(deposit.getStartDate());
        depositDto.setEndDate(deposit.getEndDate());
        depositDto.setDepositRate(deposit.getDepositRate());
        depositDto.setTypePercentPaymentId(deposit.getTypePercentPaymentId());
        depositDto.setPercentPaymentDate(deposit.getPercentPaymentDate());
        depositDto.setPercentPaymentAccountId(deposit.getPercentPaymentAccountId());
        depositDto.setCapitalization(deposit.getCapitalization());
        depositDto.setDepositRefundAccountId(deposit.getDepositRefundAccountId());
        return depositDto;
    }
}
