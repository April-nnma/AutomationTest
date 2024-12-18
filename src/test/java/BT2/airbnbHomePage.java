package BT2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class airbnbHomePage {

    // Slow down execution (helper method)
    public static void slowDown(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Step 1: Open the website
            driver.get("https://demo4.cybersoft.edu.vn/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            slowDown(2000);

            // Step 2: Click on the "About" Link
            WebElement aboutLink = wait.until(ExpectedConditions.elementToBeClickable(Locators.aboutLink));
            System.out.println("Clicking on the About link...");
            aboutLink.click();
            slowDown(2000);

            // Step 3: Verify "Địa điểm" Section
            WebElement destination = driver.findElement(Locators.destinationSection);
            if (destination.isDisplayed()) {
                System.out.println("Destination section is visible.");
            }
            slowDown(1000);

            // Step 4: Interact with Date Picker
            WebElement datePicker = driver.findElement(Locators.datePicker);
            datePicker.click();
            System.out.println("Date Picker clicked.");
            slowDown(1000);

            // Step 5: Select Start Date and End Date
            WebElement startDate = driver.findElement(Locators.calendarStartDay);
            WebElement endDate = driver.findElement(Locators.calendarEndDay);
            startDate.click();
            System.out.println("Start date selected.");
            slowDown(1000);
            endDate.click();
            System.out.println("End date selected.");
            slowDown(1000);

            // Step 6: Click "Thêm khách"
            WebElement addGuest = driver.findElement(Locators.addGuestButton);
            addGuest.click();
            System.out.println("Clicked on Thêm khách button.");
            slowDown(1000);

            // Step 7: Click Search button
            WebElement searchButton = driver.findElement(Locators.searchButton);
            searchButton.click();
            System.out.println("Search button clicked.");
            slowDown(2000);

            System.out.println("Test executed successfully!");

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}
