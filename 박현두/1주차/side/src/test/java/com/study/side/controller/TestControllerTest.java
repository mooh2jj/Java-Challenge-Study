package com.study.side.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestControllerTest {

    @Test
    void test() {
        TestController testController = new TestController();
        assertEquals("test", testController.test());
    }
}