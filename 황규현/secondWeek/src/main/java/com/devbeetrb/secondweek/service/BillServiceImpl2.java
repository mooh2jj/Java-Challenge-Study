package com.devbeetrb.secondweek.service;

import com.devbeetrb.secondweek.dto.BillCreateReqDto;
import com.devbeetrb.secondweek.persistence.Bill;
import com.devbeetrb.secondweek.repository.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillServiceImpl2 {
    private final BillRepository billRepository;

    public Bill createBill(BillCreateReqDto billCreateReqDto) {
        Bill bill = new Bill(billCreateReqDto);
        return billRepository.save(bill);
    }

    public List<Bill> getAllBill() {
        return billRepository.findAll();
    }
}
