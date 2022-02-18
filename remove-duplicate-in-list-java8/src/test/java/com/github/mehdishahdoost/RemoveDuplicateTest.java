package com.github.mehdishahdoost;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class RemoveDuplicateTest {

    @Test
    void removeDuplicates() {
        List<String> sourceList = Stream.of("Mehdi", "Elena", "Pet", "Mehdi", "Elena").collect(Collectors.toList());
        List<String> expectedList = Stream.of("Pet").collect(Collectors.toList());
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
        List<String> actualList = removeDuplicate.removeDuplicates(sourceList);
        Assertions.assertTrue(actualList.containsAll(expectedList));
    }
}