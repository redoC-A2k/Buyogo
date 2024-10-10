package com.redoC_A2k.trainingcenter.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @EntityListeners(AuditingEntityListener.class)
public class BaseEntity  {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdOn;
}
