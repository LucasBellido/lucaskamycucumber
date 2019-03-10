package com.lucaskamy.cucumber;


import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class StepDefinitions {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String PATH_TO_CHROME_DRIVER = "chromedriver.exe";
    private final String EMAIL_URL = "https://mail.google.com/mail/u/0/#inbox";

    @Given("^I am on the Gmail main page")
    public void loginToGmail() throws Throwable{
        setupSeleniumWebDrivers();
        goTo(EMAIL_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId"))).sendKeys("123Cucumber123");
        driver.findElement(By.id("identifierNext")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']"))).sendKeys("123Cucumber!");
        driver.findElement(By.id("passwordNext")).click();
    }

    @When("^I press \"Compose\"")
    public void test2() throws Throwable{
        setupSeleniumWebDrivers();

    }

    @And("^Attach an Image")
    public void test3() throws Throwable{
        setupSeleniumWebDrivers();

    }

    @And("^Enter a valid recipient")
    public void test4() throws Throwable{
        setupSeleniumWebDrivers();

    }

    @Then("^I should be able to press \"Send\"")
    public void test5() throws Throwable{
        setupSeleniumWebDrivers();

    }

    @And("^A \"Message Sent\" popup exists")

    public void test6() throws Throwable{
        setupSeleniumWebDrivers();

    }



    private void setupSeleniumWebDrivers() throws MalformedURLException {
        if (driver == null) {
            System.out.println("Setting up ChromeDriver... ");
            System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 10);
            System.out.print("Done!\n");
        }
    }

    private boolean searchForText(String text, String textToFind) {
        return text.contains(textToFind);
    }

    private void goTo(String url) {
        if (driver != null) {
            System.out.println("Going to " + url);
            driver.get(url);
        }
    }


}
