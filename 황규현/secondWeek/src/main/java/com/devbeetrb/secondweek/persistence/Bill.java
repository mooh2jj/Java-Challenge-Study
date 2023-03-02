package com.devbeetrb.secondweek.persistence;

import com.devbeetrb.secondweek.dto.BillCreateReqDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "bill")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;
    private Long payPrice;
    private String itemName;
    @OneToMany(mappedBy = "bill", cascade = CascadeType.PERSIST)
    private List<Order> orders;

    public Bill (BillCreateReqDto reqDto) {
        this.payPrice = reqDto.getPayPrice();
        this.itemName = reqDto.getItemName();
        this.orders = reqDto.getOrderCreateReqDto()
                        .stream()
                        .map(orderCreateReqDto -> new Order(orderCreateReqDto, this))
                        .collect(Collectors.toList());
    }
}
