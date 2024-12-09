package BT1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestHrmAdmin {
    public static void main(String[] args) {
        // Cấu hình WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Truy cập trang OrangeHRM
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Đăng nhập
        LoginPage.login(driver, "Admin", "admin123");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlContains("/dashboard/index"));
        // Kiểm tra: Đăng nhập thành công hay không
        System.out.println("Đăng nhập thành công!");

        // Kết thúc trình duyệt
        driver.quit();
    }
}