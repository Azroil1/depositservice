package ru.mtsbank.depositservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "deposits")
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_deposit", nullable = false)
    private int id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_deposit", nullable = false)
    private CustomerDeposit customerDeposits;

    @Column(name = "deposit_account_id", nullable = false)
    private Integer depositAccountId;

    @Column(name = "deposit_type_id", nullable = false)
    private Integer depositTypeId;

    @Column(name = "deposit_refill", nullable = false)
    private Boolean depositRefill = false;

    @Column(name = "deposit_amount", nullable = false, precision = 20, scale = 2)
    private BigDecimal depositAmount;

    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "deposit_rate", precision = 4, scale = 2)
    private BigDecimal depositRate;

    @Column(name = "type_percent_payment_id")
    private Integer typePercentPaymentId;

    @Column(name = "percent_payment_date")
    private LocalDate percentPaymentDate;

    @Column(name = "percent_payment_account_id", nullable = false)
    private Integer percentPaymentAccountId;

    @Column(name = "capitalization", nullable = false)
    private Boolean capitalization = false;

    @Column(name = "deposit_refund_account_id", nullable = false)
    private Integer depositRefundAccountId;

    @OneToOne(mappedBy = "deposit")
    private Request request;

}