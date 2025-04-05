package com.pratikPatil.assignment.stepDefinitions;

import com.pratikPatil.assignment.test.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static final Logger log = LoggerFactory.getLogger(Hooks.class);

    @Before
    public void beforeScenario() {
        log.info("Starting test scenario...");
        BaseTest.setupDriver();
    }

    @After
    public void afterScenario() {
        log.info("Test scenario completed. Closing browser...");
        BaseTest.tearDown();
    }
}
