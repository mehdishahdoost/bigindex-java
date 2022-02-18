package com.github.mehdishahdoost;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SumUp {

    /**
     * Returns sum of 0 to max by java streams.
     */
    public int sumUp(int max) {
        return IntStream.rangeClosed(0, max).sum();
    }
}
