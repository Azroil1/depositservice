package ru.mtsbank.depositservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtsbank.depositservice.entity.CustomerDeposit;

import java.util.List;

public interface CustomerDepositsRepository extends JpaRepository<CustomerDeposit,Integer> {
    List<CustomerDeposit> findByCustomerId(int customerId);
}
