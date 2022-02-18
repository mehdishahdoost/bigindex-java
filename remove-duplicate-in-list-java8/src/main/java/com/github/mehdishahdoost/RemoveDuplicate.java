package com.github.mehdishahdoost;

import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicate {

    public List<String> removeDuplicates(List<String> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

}
