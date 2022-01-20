package com.github.java.util.function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PredicateExampleTest {

    @Test
    public void isBiggerThanHundred() {
        PredicateExample predicateExample = new PredicateExample();
        boolean biggerThanHundred = predicateExample.isBiggerThanHundred(500);
        Assertions.assertTrue(biggerThanHundred);
    }
}
