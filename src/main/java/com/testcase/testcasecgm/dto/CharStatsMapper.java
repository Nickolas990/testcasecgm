package com.testcase.testcasecgm.dto;

import com.testcase.testcasecgm.domain.CharStats;
import com.testcase.testcasecgm.interfaces.Mapper;
import org.springframework.stereotype.Component;

@Component
public class CharStatsMapper implements Mapper<CharStats, CharStatsDTO> {
    public CharStatsDTO toDto (CharStats charStats) {
        return new CharStatsDTO(charStats.getCount(), charStats.getAverageLength(), charStats.getAverageChain());
    }
}
