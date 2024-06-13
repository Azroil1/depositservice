package ru.mtsbank.depositservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "deposit_types")
public class DepositType {
    @Id
    @Column(name = "id_deposit_types", nullable = false)
    private Integer id;

    @Column(name = "deposit_types_name", nullable = false, length = 28)
    private String depositTypesName;

}