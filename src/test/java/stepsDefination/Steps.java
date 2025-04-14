package stepsDefination;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.junit.Assert;

public class Steps {
    WebDriver driver;
    WebDriverWait wait;
    
    @Given("the user is on the nopCommerce login page")
    public void navigateToLoginPage() {
        // Initialize driver
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        
        // Navigate to login page with explicit waits
        driver.get("https://demo.nopcommerce.com/");
        wait.until(ExpectedConditions.titleContains("nopCommerce"));
        
        // Click login link with proper wait
        WebElement loginLink = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Log in')]")));
        loginLink.click();
        
        // Verify we're on login page
        wait.until(ExpectedConditions.urlContains("login"));
    }

    @When("the user enters valid credentials \\(username: {string}, password: {string})")
    public void enterCredentials(String email, String password) {
        // Wait for email field to be present and visible
        WebElement emailField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("Email")));
        emailField.clear();
        emailField.sendKeys(email);
        
        // Wait for password field
        WebElement passwordField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("Password")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @When("the user clicks on the Login button")
    public void clickLogin() {
        // Handle any potential popups first
        handlePopups();
        
        // Click login button with explicit wait
        WebElement loginButton = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(),'Log in')]")));
        loginButton.click();
        
        // Verify no error messages appeared
        try {
            WebElement error = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector(".message-error")));
            Assert.fail("Login failed with error: " + error.getText());
        } catch (TimeoutException e) {
            // No error - proceed
        }
    }

    @Then("the user should be redirected to the My Account page")
    public void verifyAccountPage() {
        // Wait for URL to change
        wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("login")));
        
        // Verify account link using multiple locator strategies
        WebElement accountLink = null;
        try {
            accountLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@class,'account')]")));
        } catch (TimeoutException e) {
            try {
                accountLink = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("a.ico-account")));
            } catch (TimeoutException e2) {
                Assert.fail("Could not find account link after login");
            }
        }
        Assert.assertTrue(accountLink.isDisplayed());
    }

    @Then("the user should see a welcome message")
    public void verifyWelcomeMessage() {
        WebElement welcomeMessage = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[contains(text(),'Welcome')]")));
        Assert.assertTrue(welcomeMessage.isDisplayed());
        driver.quit();
    }
    
    private void handlePopups() {
        try {
            // Handle any alerts
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (NoAlertPresentException e) {}
        
        try {
            // Close any modal popups
            WebElement closeButton = driver.findElement(
                By.cssSelector("button.close, .popup-close"));
            closeButton.click();
        } catch (NoSuchElementException e) {}
    }
}