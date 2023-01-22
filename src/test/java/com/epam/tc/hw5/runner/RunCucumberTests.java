package com.epam.tc.hw5.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/feature/"},
        glue = {"com.epam.tc.hw5.steps_bdd"})

public class RunCucumberTests extends AbstractTestNGCucumberTests {

}
