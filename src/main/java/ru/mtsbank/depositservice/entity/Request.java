package ru.mtsbank.depositservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "requests")
public class Request {
    @Id
    @Column(name = "id_request", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_request", referencedColumnName = "request_id", insertable = false, updatable = false)
    private CurrentRequestStatus requestStatus;

    @Column(name = "customer_id", nullable = false)
    private Integer customerId;

    @Column(name = "request_date", nullable = false)
    private LocalDateTime requestDate;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "deposit_id", nullable = false)
    private Deposit deposit;

}