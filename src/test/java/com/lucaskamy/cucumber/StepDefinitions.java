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

public class StepDefinitions {
    /*
     *  PRIVATE VARIABLES
     */
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    private final String PATH_TO_CHROME_DRIVER = "tools/chromedriver.exe";
    private final String EMAIL_URL = "https://mail.google.com/mail/u/0/#inbox";
    private final String OUTLOOK_URL = "https://outlook.office.com/mail/inbox";

    /*
     *  GIVEN
     */
    @Given("^I am on the Outlook main page")
    public void loginToOutlook() throws Throwable{
        setupSeleniumWebDrivers();
        goTo(OUTLOOK_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"i0116\"]"))).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passwordInput\"]"))).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"submitButton\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
    }

    /*
     *  WHEN
     */
    @When("^I press \"New Message\"")
    public void pressNew() throws Throwable{
        setupSeleniumWebDrivers();
        System.out.println("Searching for compose button\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div[1]/div/button"))).click();
        System.out.println("Compose button found\n");

    }

    @When("I press \"Drafts\"")
    public void pressDrafts() throws Throwable{
        setupSeleniumWebDrivers();
        System.out.println("Searching for draft button\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div[3]/div"))).click();
        System.out.println("draft button found\n");
    }

    /*
     *  AND
     */
    @And("^Attach an Image")
    public void attachImage() throws Throwable {
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

    @And("^Attach an image that is too large")
    public void attachLargeImage() throws Throwable {
        setupSeleniumWebDrivers();
        System.out.println("Looking for insert image\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/div[3]/div[1]/div/div/div/div[1]/div[4]/div[2]/div[2]/div/div/div/div/div[1]/div/button/div"))).click();
        System.out.println("insert image button clicked\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#id__1209-menu > div > ul > li:nth-child(2) > button > div"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[8]/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div/div[8]/div/div/div[2]/div[2]/span"))).click(); //click on picture to select it
        System.out.println("picture selected\n");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/button"))).click(); //insert button

        System.out.println("insert button clicked \n");
    }

    @And("^Attach an Image as OneDrive Link")
    public void attachLink() throws Throwable {
        setupSeleniumWebDrivers();
        System.out.println("Looking for insert image\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/div[3]/div[1]/div/div/div/div[1]/div[4]/div[2]/div[2]/div/div/div/div/div[1]/div/button/div"))).click();
        System.out.println("insert image button clicked\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#id__1209-menu > div > ul > li:nth-child(2) > button > div"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[8]/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div/div[7]/div/div"))).click(); //click on picture to select it
        System.out.println("picture selected\n");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[3]/div/button"))).click(); //insert button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[10]/div/div/div/div[2]/div/div/div/div[3]/button[1]"))).click();
        System.out.println("insert button clicked \n");
    }

    @And("^Enter a valid recipient")
    public void enterValidRecipient() throws Throwable{
        setupSeleniumWebDrivers();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/div[3]/div[1]/div/div/div/div[1]/div[1]/div[1]/div[1]/div[1]/div/div/div/div/div[1]/div/div/input"))).sendKeys("kamy.moussavikafi@mail.mcgill.ca");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"subjectLine0\"]"))).sendKeys("Spam Kamy with Cucumbers");
        System.out.println("Subject and Recipient Entered \n");
    }

    @And("^Enter an invalid recipient")
    public void enterInvalidRecipient() throws Throwable{
        setupSeleniumWebDrivers();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/div[3]/div[1]/div/div/div/div[1]/div[1]/div[1]/div[1]/div[1]/div/div/div/div/div[1]/div/div/input"))).sendKeys("");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"subjectLine0\"]"))).sendKeys("Spam Kamy with Cucumbers");
        System.out.println("Subject and Recipient Entered \n");
    }

    @And("^The message successfully sends")
    public void makeSureMessageIsSent() throws Throwable{
        setupSeleniumWebDrivers();

        //VERIFY CONFIRMATION OF MESSAGE SENT
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/div[3]/div/div/div/div/div")));

        cleanupSeleniumWebDrivers();
    }

    @And("^a previous draft of my valid email exists")
    public void clickDraftEmail() throws Throwable{
        setupSeleniumWebDrivers();
        System.out.println("looking for existing draft\n");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AQAAAAAAAQ8BAAABuHB8xgAAAAA=\"]"))).click();
        System.out.println("latest message pressed\n");
    }

    @And("^an error message exists indicating that there needs to be a recipient")
    public void errorRecipient() throws Throwable{
        setupSeleniumWebDrivers();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/div[3]/div[1]/div/div/div/div[1]/div[1]/div[1]")));
        System.out.println("Error message found\n");

        cleanupSeleniumWebDrivers();
    }

    /*
     *  THEN
     */
    @Then("^I shouldn’t be able to add the image as attachment")
    public void addAttachment() throws Throwable{
        setupSeleniumWebDrivers();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"MessageBar1425\"]")));

        cleanupSeleniumWebDrivers();
    }

    @Then("^I should be able to press \"Send\"")
    public void pressSend() throws Throwable{
        setupSeleniumWebDrivers();
        System.out.println("Looking for send button \n");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/div/div/div[3]/div[2]/div/div[3]/div[1]/div/div/div/div[1]/div[2]/div[2]"))).sendKeys(Keys.chord("Hello Kamy, Hope you enjoy this cucumber picture as much as I do. It's my favorite one. I took it myself, on a summer day, right after waking up.", Keys.CONTROL, Keys.RETURN));

        System.out.println("send button pressed\n");
    }

    /*
     *  SETTING UP THE ENVIRONMENT BEFORE EACH TEST
     */
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

    /*
     *  CLEANING UP THE ENVIRONMENT AFTER EACH TEST
     */
    private void cleanupSeleniumWebDrivers() {
        driver.quit();
    }

    /*
     *  METHOD TO GO TO A WEB URL
     */
    private void goTo(String url) {
        if (driver != null) {
            System.out.println("Going to " + url);
            driver.get(url);
        }
    }




}
