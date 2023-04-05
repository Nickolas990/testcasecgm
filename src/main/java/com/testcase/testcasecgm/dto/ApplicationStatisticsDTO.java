package com.testcase.testcasecgm.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.ConcurrentHashMap;

@Getter
@Setter
public class ApplicationStatisticsDTO {
    private ConcurrentHashMap<Character, CharStatsDTO> stats = new ConcurrentHashMap<>();
}
