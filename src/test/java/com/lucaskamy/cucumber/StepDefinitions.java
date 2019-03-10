package com.lucaskamy.cucumber;


import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    private final String PATH_TO_CHROME_DRIVER = "tools/chromedriver.exe";
    private final String EMAIL_URL = "https://mail.google.com/mail/u/0/#inbox";
    private final String OUTLOOK_URL = "https://outlook.office.com/mail/inbox";


    @Given("^I am on the Gmail main page")
    public void loginToGmail() throws Throwable{
        setupSeleniumWebDrivers();
        goTo(OUTLOOK_URL);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"i0116\"]"))).sendKeys("seyed.moussavikafi@mail.mcgill.ca");
      driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passwordInput\"]"))).sendKeys("");
      driver.findElement(By.xpath("//*[@id=\"submitButton\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
    }

    @When("^I press \"Compose\"")
    public void test2() throws Throwable{
        setupSeleniumWebDrivers();
        System.out.println("Searching for compose button\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div[1]/div/button"))).click();
        System.out.println("Compose button found\n");

    }

    @And("^Attach an Image")
    public void test3() throws Throwable {
        setupSeleniumWebDrivers();
        System.out.println("Looking for insert image\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/div[3]/div[1]/div/div/div/div[1]/div[4]/div[2]/div[2]/div/div/div/div/div[1]/div/button/div"))).click();
        System.out.println("insert image button clicked\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#id__1209-menu > div > ul > li:nth-child(2) > button > div"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[8]/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div/div[7]/div/div"))).click(); //click on picture to select it
        System.out.println("picture selected\n");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/button"))).click(); //insert button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[10]/div/div/div/div[2]/div/div/div/div[4]/button[1]"))).click();
        System.out.println("insert button clicked \n");
    }

    @And("^Enter a valid recipient")
    public void test4() throws Throwable{
        setupSeleniumWebDrivers();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/div[3]/div[1]/div/div/div/div[1]/div[1]/div[1]/div[1]/div[1]/div/div/div/div/div[1]/div/div/input"))).sendKeys("kamy.moussavikafi@mail.mcgill.ca");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"subjectLine0\"]"))).sendKeys("Spam Kamy with Cucumbers");
        System.out.println("Subject and Recipient Entered \n");
    }

    @Then("^I should be able to press \"Send\"")
    public void test5() throws Throwable{
        setupSeleniumWebDrivers();
        System.out.println("Looking for send button \n");

        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ms-Image-image.is-loaded"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/div[3]/div[1]/div/div/div/div[1]/div[2]/div[2]"))).sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));

        System.out.println("send button pressed\n");
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
            wait = new WebDriverWait(driver, 15);
            action = new Actions(driver);
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
