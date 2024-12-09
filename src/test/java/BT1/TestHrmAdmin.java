package BT1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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

        System.out.println("Đăng nhập thành công!");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

        By adminMenu = By.xpath("//span[text()='Admin' and contains(@class, 'oxd-main-menu-item--name')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminMenu));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
        driver.findElement(adminMenu).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));


        // Chờ trang Admin tải xong
        wait.until(ExpectedConditions.urlContains("/admin/viewSystemUsers"));driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));
        System.out.println("Đã chuyển đến trang Admin thành công!");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));


        // Kết thúc trình duyệt
        driver.quit();
    }
}