package ru.mtsbank.depositservice.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CurrentRequestStatusId implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer requestId;
    private Integer requestStatusId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentRequestStatusId that = (CurrentRequestStatusId) o;
        return Objects.equals(requestId, that.requestId) && Objects.equals(requestStatusId, that.requestStatusId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, requestStatusId);
    }
}
