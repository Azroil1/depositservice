package ru.mtsbank.depositservice.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "customer_deposits")
@Data
@NoArgsConstructor
public class CustomerDeposit {
    @Id
    @Column(name = "deposit_id", nullable = false)
    private Integer id;

    @Column(name = "customer_id")
    private Integer customerId;

}