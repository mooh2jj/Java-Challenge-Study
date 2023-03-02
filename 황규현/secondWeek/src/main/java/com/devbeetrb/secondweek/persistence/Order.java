package com.devbeetrb.secondweek.persistence;

import com.devbeetrb.secondweek.dto.OrderCreateReqDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id;
    private String address;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill bill;

    public Order(OrderCreateReqDto reqDto, Bill bill) {
        this.address = reqDto.getAddress();
        this.bill = bill;
    }

}
