package ru.mtsbank.depositservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.mapping.ToOne;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "current_request_status", schema = "depositsmtsbank")
@IdClass(CurrentRequestStatusId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrentRequestStatus {
    @Id
    @Column(name = "request_id")
    private int requestId;

    @Id
    @Column(name = "request_status_id")
    private Integer requestStatusId;

    @Column(name = "change_datatime", nullable = false, columnDefinition = "timetz")
    private ZonedDateTime changeDatatime;

    @OneToOne(mappedBy = "requestStatus")
    private Request request;

    @OneToOne
    @JoinColumn(name = "request_status_id",referencedColumnName = "id_request_status", insertable = false, updatable = false)
    private RequestStatus status;
}
