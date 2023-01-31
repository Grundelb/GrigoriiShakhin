package com.epam.tc.hw5.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        monochrome = true,
        tags = "@smoke",
        features = {"src/test/resources/feature"},
        glue = {"com.epam.tc.hw5.steps.bdd"})

public class RunCucumberTests extends AbstractTestNGCucumberTests {

}
