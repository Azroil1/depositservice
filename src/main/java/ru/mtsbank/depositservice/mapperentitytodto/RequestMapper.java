package ru.mtsbank.depositservice.mapperentitytodto;

import ru.mtsbank.depositservice.dto.DepositDto;
import ru.mtsbank.depositservice.dto.RequestDto;
import ru.mtsbank.depositservice.entity.Request;

public class RequestMapper {
    public static RequestDto fromEntity(Request request) {
        RequestDto requestDto = new RequestDto();
        requestDto.setCustomerId(request.getCustomerId());
        requestDto.setRequestDate(request.getRequestDate());
        if (request.getDeposit() != null) {
            requestDto.setDepositDto(DepositMapper.mapToDto(request.getDeposit()));
        }
        requestDto.setCurrentRequestStatus(request.getRequestStatus());
        return requestDto;
    }

    public static Request toEntity(RequestDto requestDto) {
        Request request = new Request();
        request.setCustomerId(requestDto.getCustomerId());
        request.setRequestDate(requestDto.getRequestDate());
        if (requestDto.getDepositDto() != null) {
            request.setDeposit(DepositMapper.map(requestDto.getDepositDto()));
        }
        request.setRequestStatus(requestDto.getCurrentRequestStatus());
        return request;
    }
}
