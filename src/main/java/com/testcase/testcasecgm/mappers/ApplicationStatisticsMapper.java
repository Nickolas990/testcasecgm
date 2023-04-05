package com.testcase.testcasecgm.mappers;

import com.testcase.testcasecgm.domain.ApplicationStatistics;
import com.testcase.testcasecgm.domain.CharStats;
import com.testcase.testcasecgm.dto.ApplicationStatisticsDTO;
import com.testcase.testcasecgm.interfaces.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ApplicationStatisticsMapper implements Mapper<ApplicationStatistics, ApplicationStatisticsDTO> {

    private final CharStatsMapper mapper;

    @Autowired
    public ApplicationStatisticsMapper(CharStatsMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ApplicationStatisticsDTO toDto(ApplicationStatistics value) {
        ConcurrentHashMap<Character, CharStats> map = value.getStats();
        ApplicationStatisticsDTO result = new ApplicationStatisticsDTO();


        for (Map.Entry<Character, CharStats> entry : map.entrySet()) {
            result.getStats().put(entry.getKey(), mapper.toDto(entry.getValue()));
        }
        return result;
    }
}
