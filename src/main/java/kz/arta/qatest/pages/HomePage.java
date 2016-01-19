package kz.arta.qatest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mansurtursumbayev on 1/16/16.
 */
public class HomePage {
        public static final int DOUBLE_CLICK_TYPE = 2;
        public static final int SINGLE_CLICK_TYPE = 1;
        private final WebDriver driver;
        private final WebDriverWait wait;
        private final Actions action;

        public HomePage(WebDriver driver) {
                this.driver = driver;
                this.wait = new WebDriverWait(driver, 30);
                this.action = new Actions(driver);
                if (!"ARTA Synergy".equals(driver.getTitle())) {
                        throw new IllegalStateException("This is not the home page");
                }
        }
        By createButtonLocator = By.className("button-multi-toggle-text-bright-green");
        By workNameTALocator = By.className("gwt-TextArea");
        By user = By.className("gray-user-chooser-item");
        By userImage = By.xpath("//img[contains(@src,'images/usrchooser/choose.user.png')]");
        By finishButton = By.className("button-center-green");
        public void createWork() {
                waitAndPerformClick(createButtonLocator);
                switchToPopUp();
                waitAndWriteText(workNameTALocator, "test work name");
                waitListAndClickElement(userImage, 0);
                switchToPopUp();
                mouseOverAndDoubleClickElement(user, DOUBLE_CLICK_TYPE);
                mouseOverAndDoubleClickElement(finishButton, SINGLE_CLICK_TYPE);
        }

        private void switchToPopUp() {
                driver.switchTo().activeElement();
        }

        private void waitAndPerformClick(By elementBy) {
                wait.until(ExpectedConditions.elementToBeClickable(elementBy));
                driver.findElement(elementBy).click();
        }
        private void waitAndWriteText(By elementBy, String textToWrite) {
                wait.until(ExpectedConditions.elementToBeClickable(elementBy));
                driver.findElement(elementBy).sendKeys(textToWrite);
        }
        private void waitListAndClickElement(By elementBy, int elementIndex) {
                wait.until(ExpectedConditions.elementToBeClickable(elementBy));
                driver.findElements(elementBy).get(elementIndex).click();
        }
        private void mouseOverAndDoubleClickElement(By elementBy, int typeOfClick) {
                wait.until(ExpectedConditions.elementToBeClickable(elementBy));
                switch (typeOfClick) {
                        case DOUBLE_CLICK_TYPE :
                                action.moveToElement(driver.findElement(elementBy)).doubleClick().build().perform();
                                break;
                        case SINGLE_CLICK_TYPE :
                                action.moveToElement(driver.findElement(elementBy)).click().build().perform();
                                break;
                        default:
                                break;
                }
        }
}
