package BT1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class hrmAdminPage {
    public static By adminMenu = By.xpath("//span[text()='Admin' and contains(@class, 'oxd-main-menu-item--name')]");

    public static void goToAdminPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement adminElement = wait.until(ExpectedConditions.visibilityOfElementLocated(adminMenu));
        adminElement.click();
    }
}

