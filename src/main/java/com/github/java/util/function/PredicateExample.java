package com.github.java.util.function;

import java.util.function.Predicate;

public class PredicateExample {

    public boolean isBiggerThanHundred(int n) {
        Predicate<Integer> p = b -> b > 100;
        return p.test(n);
    }
}
