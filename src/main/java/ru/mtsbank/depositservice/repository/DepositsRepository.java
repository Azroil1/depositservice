package ru.mtsbank.depositservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mtsbank.depositservice.entity.Deposit;

import java.util.List;

@Repository
public interface DepositsRepository extends JpaRepository<Deposit, Integer> {
    Deposit findDepositById(int id);
}
