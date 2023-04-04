package com.testcase.testcasecgm.controller;


import com.testcase.testcasecgm.domain.Analyser;
import com.testcase.testcasecgm.domain.ApplicationStatistics;
import com.testcase.testcasecgm.services.AnalysingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    AnalysingService analysingService;

    @Autowired
    public ApiController(AnalysingService analysingService) {
        this.analysingService = analysingService;
    }

    @GetMapping(value = "/analyse/{input_string}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Analyser analyse(@PathVariable("input_string") String inputString) {
           return analysingService.analysing(inputString);
    }

    @GetMapping(value = "/statistics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApplicationStatistics statistics () {
        return analysingService.getApplicationStatistics();
    }
}
