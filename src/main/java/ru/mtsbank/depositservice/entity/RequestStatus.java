package ru.mtsbank.depositservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "requestStatus")
@Table(name = "request_statuses")
public class RequestStatus {
    @Id
    @Column(name = "id_request_status", nullable = false)
    private Integer id;

    @Column(name = "request_status_name", nullable = false, length = 21)
    private String requestStatusName;

    @OneToOne(mappedBy = "requestStatus")
    private CurrentRequestStatus currentRequestStatus;

}