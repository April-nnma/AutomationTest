package BT2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static BT2.Locators.*;

public class airbnbHomePage {

    public static void slowDown(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void safeClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            element.click();
        } catch (Exception e) {
            System.out.println("Direct click failed. Using JavaScript to click...");
            js.executeScript("arguments[0].click();", element);
        }
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            driver.get("https://demo4.cybersoft.edu.vn/");
            slowDown(5000);
            //about
            WebElement aboutLink = wait.until(ExpectedConditions.elementToBeClickable(Locators.aboutLink));
            aboutLink.click();
            slowDown(5000);
            //location
            WebElement destinationSection = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.destinationSection));
            scrollIntoView(driver, destinationSection);
            safeClick(driver, destinationSection);
            System.out.println("Destination section clicked successfully.");
            slowDown(2000);
            //choose hcm
            WebElement hoChiMinhOption = wait.until(ExpectedConditions.elementToBeClickable(Locators.hoChiMinhOption));
            safeClick(driver, hoChiMinhOption);
            System.out.println("Hồ Chí Minh selected successfully.");
            slowDown(2000);
            //avt
            WebElement interactButton = wait.until(ExpectedConditions.elementToBeClickable(Locators.interactButton));
            scrollIntoView(driver, interactButton);
            safeClick(driver, interactButton);
            System.out.println("Interact button clicked the first time.");
            slowDown(2000);
            safeClick(driver, interactButton);
            System.out.println("Interact button clicked the second time to close the popover.");
            slowDown(2000);
            //cantho
            WebElement canThoOption = wait.until(ExpectedConditions.elementToBeClickable(Locators.canThoOption));
            scrollIntoView(driver, canThoOption);
            safeClick(driver, canThoOption);
            System.out.println("Cần Thơ selected successfully.");
            slowDown(2000);

            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL: " + currentUrl);
            if (currentUrl.contains("rooms/ho-chi-minh")) {
                System.out.println("Successfully navigated to the Hồ Chí Minh page.");
            } else {
                System.out.println("Navigation failed.");
            }
            //return main page by logo airbnb
            WebElement airbnbLogoLink = wait.until(ExpectedConditions.elementToBeClickable(Locators.airbnbLogoLink));
            scrollIntoView(driver, airbnbLogoLink);
            safeClick(driver, airbnbLogoLink);
            System.out.println("Clicked on Airbnb logo link to return to the main page.");
            slowDown(2000);
            //loai noi
            WebElement loaiNoiOButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loaiNoiOButton));
            scrollIntoView(driver, loaiNoiOButtonElement);
            safeClick(driver, loaiNoiOButtonElement);
            System.out.println("Clicked on 'Loại nơi ở' button successfully.");
            slowDown(2000);
            //gia
            WebElement giaButtonElement = wait.until(ExpectedConditions.elementToBeClickable(giaButton));
            scrollIntoView(driver, giaButtonElement);
            safeClick(driver, giaButtonElement);
            System.out.println("Clicked on 'Giá' button successfully.");
            slowDown(2000);
            //button them khach
            WebElement themKhachElement = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.themKhachText));
            scrollIntoView(driver, themKhachElement);
            safeClick(driver, themKhachElement);
            System.out.println("'Thêm khách' text clicked successfully.");
            slowDown(2000);
            //+
            WebElement plusButtonElement = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.plusButton));
            scrollIntoView(driver, plusButtonElement);
            safeClick(driver, plusButtonElement);
            System.out.println("'+' button clicked successfully.");
            slowDown(2000);
            //-
            WebElement minusButtonElement = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.minusButton));
            scrollIntoView(driver, minusButtonElement);
            safeClick(driver, minusButtonElement);
            System.out.println("'-' button clicked successfully.");
            slowDown(2000);
            //search
            WebElement searchIconElement = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.searchIcon));
            scrollIntoView(driver, searchIconElement);
            safeClick(driver, searchIconElement);
            System.out.println("Search icon clicked successfully.");
            slowDown(2000);
            //return main page by homelink
            WebElement homeLinkElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.homeLink));
            scrollIntoView(driver, homeLinkElement);
            safeClick(driver, homeLinkElement);
            System.out.println("Clicked on the 'Home' link successfully.");
            slowDown(2000);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
