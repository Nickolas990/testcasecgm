package com.testcase.testcasecgm.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharStats {
    private Long count = 1L;
    private Long averageLength = 1L;

    private Long averageChain = 1L;

    private Long sumOfChains = 0L;
    private Long sumOfLengths = 0L;
}
