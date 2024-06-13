package ru.mtsbank.depositservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.mtsbank.depositservice.entity.Request;

public interface RequestRepository extends JpaRepository<Request, Integer> {

}
