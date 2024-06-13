package ru.mtsbank.depositservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name = "account" , url = "http://localhost:8081")
public interface AccountServiceClient {
    @GetMapping("mtsbank/account/balance")
    BigDecimal getAccountBalance(@RequestHeader("Authorization") String accountId);
}
