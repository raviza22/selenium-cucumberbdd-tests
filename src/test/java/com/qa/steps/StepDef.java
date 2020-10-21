package com.qa.steps;

import com.qa.base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StepDef extends TestBase {

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.phptravels.net/login/en");
    }

    /*
    // Step Def with DataTable usage

    @When("I enter valid credentials")
    public void i_enter_valid_credentials(DataTable table) {
        List<String> loginInfo = table.asList();
       driver.findElement(By.name("username")).sendKeys(loginInfo.get(0));
       driver.findElement(By.name("password")).sendKeys(loginInfo.get(1));
       driver.findElement(By.xpath("//button[text()='Login']")).click();
    }
    */

    @When("I enter valid credentials {string} and {string}")
    public void i_enter_valid_credentials(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
    }

    @Then("I should be taken to Account page")
    public void i_should_be_taken_to_account_page() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("h3.text-align-left")).isDisplayed();
        driver.findElement(By.cssSelector("div.dropdown-login>a")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

    }

    @After
    public void teardown() {
        driver.quit();
    }

}
