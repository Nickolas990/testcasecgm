package com.testcase.testcasecgm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CharStatsDTO {
    private Long count;
    private Long averageLength;

    private Long averageChain;
}
