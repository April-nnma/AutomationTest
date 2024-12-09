package BT1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
    // Locators
    public static By usernameField = By.name("username"); // Ô nhập Username
    public static By passwordField = By.name("password"); // Ô nhập Password
    public static By loginButton = By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button"); // Nút Login

    // Phương thức đăng nhập
    public static void login(WebDriver driver, String username, String password) {
        // Đợi các element xuất hiện
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));

        // Nhập username và password
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click(); // Nhấn nút Login
    }
}
