package com.qa.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"com.qa.steps"}, features = {"src/test/resources"},
plugin = {"pretty", "html:target/cucumber-pretty", "json:target/cucumber.json"})
public class TestRunner {
}
