package ru.mtsbank.depositservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mtsbank.depositservice.entity.CurrentRequestStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestDto implements Serializable {
    private int customerId;
    private LocalDateTime requestDate;
    private DepositDto depositDto;
    private CurrentRequestStatus currentRequestStatus;
}
