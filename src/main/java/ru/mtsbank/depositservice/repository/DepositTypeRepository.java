package ru.mtsbank.depositservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mtsbank.depositservice.entity.DepositType;

@Repository
public interface DepositTypeRepository extends JpaRepository<DepositType, Integer> {
    int findByDepositTypesName(String name);
}
