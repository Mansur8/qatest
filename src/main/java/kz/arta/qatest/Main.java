package kz.arta.qatest;

import kz.arta.qatest.pages.HomePage;
import kz.arta.qatest.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by mansurtursumbayev on 1/17/16.
 */
public class Main {
    public static void main(String[] args) {
        // FIXME: Set property
        System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.arta.kz/Synergy/");
        LoginPage loginPage = new LoginPage(driver);
        String testUsername = "111111";
        String testPassword = "111111";
        HomePage homePage = loginPage.loginAs(testUsername, testPassword);
        homePage.createWork();
    }
}
