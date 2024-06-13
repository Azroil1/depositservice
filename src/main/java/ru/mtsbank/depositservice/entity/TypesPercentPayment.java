package ru.mtsbank.depositservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "types_percent_payment")
public class TypesPercentPayment {
    @Id
    @Column(name = "id_type_percent_payment", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_type_percent_payment", nullable = false, referencedColumnName = "type_percent_payment_id")
    private Deposit deposits;

    @Column(name = "type_percent_payment_period", nullable = false, length = 13)
    private String typePercentPaymentPeriod;

}