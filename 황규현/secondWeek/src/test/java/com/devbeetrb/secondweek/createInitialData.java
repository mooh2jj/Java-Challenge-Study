package com.devbeetrb.secondweek;

import com.devbeetrb.secondweek.dto.BillCreateReqDto;
import com.devbeetrb.secondweek.dto.OrderCreateReqDto;
import com.devbeetrb.secondweek.service.BillServiceImpl2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class createInitialData {

    @Autowired
    BillServiceImpl2 billServiceImpl;
    @Test
    void makeBill () {
        for (int i = 0; i < 10; i++) {
            BillCreateReqDto billCreateReqDto = new BillCreateReqDto("테스트 아이템"+i, 2L*i);
            List<OrderCreateReqDto> orderReqDtos = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                OrderCreateReqDto orderCreateReqDto = new OrderCreateReqDto();
                orderCreateReqDto.setAddress("서울특별시 강남구 테헤란로 8"+i+"길 512-"+i);
                orderReqDtos.add(orderCreateReqDto);
            }
            billCreateReqDto.setOrderCreateReqDto(orderReqDtos);
            billServiceImpl.createBill(billCreateReqDto);
        }
    }
}
