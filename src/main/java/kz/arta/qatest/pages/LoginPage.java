package kz.arta.qatest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by mansurtursumbayev on 1/17/16.
 */
public class LoginPage {
    private final WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;

        if (!"ARTA Synergy".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }
    }
    By usernameLocator = By.id("login");
    By passwordLocator = By.id("pswd");
    By loginButtonLocator = By.id("submit_button");
    public LoginPage typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }
    public LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }
    public HomePage submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return new HomePage(driver);
    }
    public HomePage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }
}
