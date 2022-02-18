package com.github.mehdishahdoost;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumUpTest {

    @Test
    void sumUp() {
        SumUp sumUp = new SumUp();
        int sum = sumUp.sumUp(50);
        Assertions.assertEquals(sum, 1275);
    }
}