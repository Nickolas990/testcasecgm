package com.testcase.testcasecgm.interfaces;

public interface Mapper<V, T> {
    T toDto(V value);
}
