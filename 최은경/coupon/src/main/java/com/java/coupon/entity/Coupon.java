package com.java.coupon.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coupon")
public class Coupon {

    @Id
    @GeneratedValue
    private int cpId;

    private String cpName;

    private String cpCode;

    private String userId;

    private char usageStatus;

    private char status;

    private LocalDateTime beginDt;

    private LocalDateTime endDt;
}
