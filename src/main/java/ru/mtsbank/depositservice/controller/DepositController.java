package ru.mtsbank.depositservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mtsbank.depositservice.entity.Deposit;
import ru.mtsbank.depositservice.jwt.JwtUtil;
import ru.mtsbank.depositservice.service.DepositService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/mtsbank/deposits")
public class DepositController {
    DepositService depositService;
    JwtUtil jwtUtil;
    public DepositController(DepositService depositService, JwtUtil jwtUtil) {
        this.depositService = depositService;
        this.jwtUtil = jwtUtil;
    }
    @GetMapping("/my")
    public ResponseEntity<?> getDeposits(@RequestHeader("Authorization") String token) {
        String jwtToken = token.replace("Bearer ", "");
        Integer accountId = jwtUtil.extractAccountId(jwtToken).get("bankAccountId");
        List<Deposit> deposits = depositService.getDeposits(accountId);
        log.info(token);
        BigDecimal balnce = depositService.getBalance(token);
        Map<String,Object> response = new HashMap<>();
        response.put("balance",balnce);
        response.put("deposits",deposits);
        return ResponseEntity.ok().body(response);
    }
}
