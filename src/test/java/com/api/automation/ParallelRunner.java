package com.api.automation;

import org.junit.jupiter.api.Assertions;
import com.intuit.karate.Results;
import org.junit.jupiter.api.Test;
import com.intuit.karate.Runner;

public class ParallelRunner {
	
	@Test
	public void executeKarateTests() {
		Results results = Runner.path("classpath:com/api/automation").parallel(5);
		Assertions.assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}
}
