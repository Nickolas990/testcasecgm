package com.testcase.testcasecgm.services;


import com.testcase.testcasecgm.domain.Analyser;
import com.testcase.testcasecgm.domain.ApplicationStatistics;
import com.testcase.testcasecgm.domain.CharStats;
import com.testcase.testcasecgm.domain.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AnalysingService {

    ApplicationStatistics applicationStatistics;

    @Autowired
    public AnalysingService(ApplicationStatistics applicationStatistics) {
        this.applicationStatistics = applicationStatistics;
    }

    public Analyser analysing(String string) {
        Analyser analyser = new Analyser();
        Long chains = 1L;
        Character prevChar = 0;

        for (int i = 0; i < string.length(); i++) {
            Value value;


            if (string.charAt(i) == prevChar && i!=0) {
                chains++;
            } else {
                chains = 1L;
            }

            if (!analyser.getValues().containsKey(string.charAt(i))) {
                value = new Value();
                value.setCounts(1L);
                value.setChains(chains);
            } else {
                value = analyser.getValues().get(string.charAt(i));
                value.setCounts(value.getCounts() + 1);
                if (value.getChains() < chains) {
                    value.setChains(chains);
                }
            }
            analyser.getValues().put(string.charAt(i), value);

            prevChar = string.charAt(i);
        }

        ConcurrentHashMap <Character, CharStats> stats = applicationStatistics.getStats();
        for (Map.Entry<Character, Value> entry : analyser.getValues().entrySet()) {
            CharStats charStats;
            if (!stats.containsKey(entry.getKey())) {
                charStats = new CharStats();
                stats.put(entry.getKey(), charStats);
            } else {
                Value value = entry.getValue();
                charStats = stats.get(entry.getKey());
                charStats.setSumOfChains(charStats.getSumOfChains() + value.getChains());
                charStats.setSumOfLengths(charStats.getSumOfLengths() + string.length());
                charStats.setCount(charStats.getCount() + 1);
                charStats.setAverageLength((charStats.getSumOfLengths() /charStats.getCount()));
                charStats.setAverageChain((charStats.getSumOfChains()/charStats.getCount()));
            }
        }
        return analyser;
    }

    public ApplicationStatistics getApplicationStatistics() {
        return applicationStatistics;
    }


}
