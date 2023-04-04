package com.testcase.testcasecgm.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;


@Getter
@Setter
public class Analyser {

    private Map<Character, Value> values = new HashMap<>();
}
