package com.api.automation;

import com.api.automation.extentreport.ReportHook;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParalleRunner1WithExtentReport {
   @Test
    void testParallel(){
       Results results = Runner.path("classpath:com/api/automation/extentreport")
                       .hook(new ReportHook())
                               .parallel(1);
       assertEquals(0, results.getFailCount(), results.getErrorMessages());
   }


}
