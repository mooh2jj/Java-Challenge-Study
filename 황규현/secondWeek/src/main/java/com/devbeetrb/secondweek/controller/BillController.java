package com.devbeetrb.secondweek.controller;

import com.devbeetrb.secondweek.persistence.Bill;
import com.devbeetrb.secondweek.service.BillServiceImpl2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bill")
@RequiredArgsConstructor
public class BillController {

    private final BillServiceImpl2 billServiceImpl;
    @GetMapping
    public List<Bill> getBill() {
        return billServiceImpl.getAllBill();
    }
}