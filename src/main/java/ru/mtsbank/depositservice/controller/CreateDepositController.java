package ru.mtsbank.depositservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mtsbank.depositservice.dto.RequestDto;
import ru.mtsbank.depositservice.exception.NoMoneyException;
import ru.mtsbank.depositservice.jwt.JwtUtil;
import ru.mtsbank.depositservice.request.DepositRequest;
import ru.mtsbank.depositservice.service.DepositService;
import ru.mtsbank.depositservice.service.NewDepositService;

import java.util.Map;

@RestController
@RequestMapping("mtsbank/deposits")
public class CreateDepositController {
    private final NewDepositService newDepositService;
    private final JwtUtil jwtUtil;

    public CreateDepositController(NewDepositService newDepositService, JwtUtil jwtUtil) {
        this.newDepositService = newDepositService;
        this.jwtUtil = jwtUtil;
    }
    @PostMapping("/newrequests")
    public ResponseEntity<?> requestNewDeposit(@RequestHeader("Authorization") String token, @RequestBody DepositRequest depositRequest) throws NoMoneyException, InterruptedException {
        String jwtToket = token.substring(7);
        int bankAccountId = jwtUtil.extractAccountId(jwtToket).get("bankAccountId");
        int customerAccountId = jwtUtil.extractAccountId(jwtToket).get("customerAccountId");
        newDepositService.checkNewDeposit(depositRequest, customerAccountId, bankAccountId);
        return ResponseEntity.ok().build();
    }
}
