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

                   // Step 3: Verify "Địa điểm" Section
            // Step 2: Scroll to and interact with "Địa điểm" Section
            WebElement destinationSection = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.destinationSection));

// Scroll into view
            js.executeScript("arguments[0].scrollIntoView(true);", destinationSection);
            slowDown(1000);

// Try clicking on the "Địa điểm" section
            try {
                destinationSection.click();
                System.out.println("Destination section clicked successfully.");
            } catch (Exception e) {
                System.out.println("Direct click failed. Using JavaScript to click...");
                js.executeScript("arguments[0].click();", destinationSection);
            }
            slowDown(2000);
            WebElement hoChiMinhOption = wait.until(ExpectedConditions.elementToBeClickable(Locators.hoChiMinhOption));
            try {
                hoChiMinhOption.click();
                System.out.println("Hồ Chí Minh selected successfully.");
            } catch (Exception e) {
                System.out.println("Failed to click Hồ Chí Minh. Using JavaScript...");
                js.executeScript("arguments[0].click();", hoChiMinhOption);
            }
            slowDown(1000);

            //
            try {
                // Locate and interact with the Date Picker
                WebElement datePickerElement = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.datePicker));

                // Ensure the element is visible
                if (datePickerElement.isDisplayed()) {
                    System.out.println("Date Picker located.");

                    // Scroll into view
                    js.executeScript("arguments[0].scrollIntoView(true);", datePickerElement);
                    slowDown(1000);

                    // Click the Date Picker
                    datePickerElement.click();
                    System.out.println("Date Picker clicked.");
                } else {
                    throw new Exception("Date Picker is not visible.");
                }
                slowDown(2000);

                // Step 4: Interact with Start Date and End Date
                WebElement startDate = wait.until(ExpectedConditions.elementToBeClickable(Locators.calendarStartDay));
                WebElement endDate = wait.until(ExpectedConditions.elementToBeClickable(Locators.calendarEndDay));
                startDate.click();
                System.out.println("Start date selected.");
                slowDown(1000);
                endDate.click();
                System.out.println("End date selected.");
                slowDown(1000);

                System.out.println("Date Picker interaction completed successfully!");

            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }

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
