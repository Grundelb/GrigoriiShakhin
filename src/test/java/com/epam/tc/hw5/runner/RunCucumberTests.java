package com.epam.tc.hw5.runner;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/feature",
        glue = {"steps_bdd"},
        monochrome = true,
        plugin = {"pretty", "html:target/HtmlReports"})

public class RunCucumberTests {

}
