package BT1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class hrmAdminPage {
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

            driver.get("https://opensource-demo.orangehrmlive.com/");
            LoginPage.login(driver, "Admin", "admin123");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.urlContains("/dashboard/index"));

            By adminMenu = By.xpath("//span[text()='Admin' and contains(@class, 'oxd-main-menu-item--name')]");
            WebElement adminElement = wait.until(ExpectedConditions.elementToBeClickable(adminMenu));
            adminElement.click();
            slowDown(2000); // Pause after clicking Admin menu

            wait.until(ExpectedConditions.urlContains("/admin/viewSystemUsers"));

            By addButton = By.xpath("//button[contains(@class, 'oxd-button') and .//i[contains(@class, 'bi-plus')]]");
            WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addButton));
            js.executeScript("arguments[0].scrollIntoView(true);", addBtn);
            System.out.println("Clicking the Add button...");
            slowDown(1000);
            addBtn.click();

            wait.until(ExpectedConditions.urlContains("/admin/saveSystemUser"));
            System.out.println("Successfully navigated to the Add System User page!");
            driver.navigate().back();
            wait.until(ExpectedConditions.urlContains("/admin/viewSystemUsers"));
            System.out.println("Returned to Admin page successfully!");

            By usernameInput = By.xpath("//label[text()='Username']/following::input[contains(@class, 'oxd-input')]");
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
            System.out.println("Typing 'admin' into the Username field...");
            usernameField.sendKeys("admin");

            By userRoleDropdown = By.xpath("//div[contains(@class, 'oxd-select-text')]");
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdown));
            dropdown.click();
            By roleOption = By.xpath("//div[@role='option' and contains(., 'Admin')]");
            WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(roleOption));
            System.out.println("Selecting 'Admin' from the dropdown...");
            option.click();

            slowDown(1000);

            By searchButton = By.xpath("//button[contains(@class, 'oxd-button') and contains(., 'Search')]");
            WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            System.out.println("Clicking the Search button...");
            searchBtn.click();
            slowDown(2000); // Small pause after clicking Search
            System.out.println("Search completed successfully!");

            By resetButton = By.xpath("//button[contains(@class, 'oxd-button--ghost') and contains(., 'Reset')]");
            WebElement resetBtn = wait.until(ExpectedConditions.elementToBeClickable(resetButton));
            System.out.println("Clicking the Reset button...");
            resetBtn.click();

            slowDown(1000);
            String usernameValue = usernameField.getAttribute("value");
            if (usernameValue.isEmpty()) {
                System.out.println("Reset button worked: Username field is cleared.");
            } else {
                System.err.println("Reset button failed: Username field is not cleared.");
            }

            By deleteIcon = By.xpath("//button[contains(@class, 'oxd-icon-button') and .//i[contains(@class, 'bi-trash')]]");
            WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(deleteIcon));
            System.out.println("Clicking the delete icon...");
            deleteButton.click();

            slowDown(2000);

            By editIcon = By.xpath("(//button[contains(@class, 'oxd-icon-button') and .//i[contains(@class, 'bi-pencil-fill')]])[1]");
            WebElement editButton = wait.until(ExpectedConditions.presenceOfElementLocated(editIcon));
            js.executeScript("arguments[0].scrollIntoView(true);", editButton);
            slowDown(1000);
            try {
                System.out.println("Attempting to click the edit icon...");
                wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
            } catch (Exception e) {
                System.out.println("Normal click failed. Using JavaScript click...");
                js.executeScript("arguments[0].click();", editButton);
            }

            slowDown(2000);

            wait.until(ExpectedConditions.urlContains("/admin/saveSystemUser/"));
            System.out.println("Successfully navigated to the Edit System User page!");
            wait.until(ExpectedConditions.urlContains("/admin/saveSystemUser/"));
            System.out.println("Successfully navigated to the Edit System User page!");

            By pimMenu = By.xpath("//span[text()='PIM' and contains(@class, 'oxd-main-menu-item--name')]");
            WebElement pimElement = wait.until(ExpectedConditions.elementToBeClickable(pimMenu));
            js.executeScript("arguments[0].scrollIntoView(true);", pimElement);
            slowDown(1000);
            System.out.println("Clicking the PIM menu...");
            pimElement.click();
            wait.until(ExpectedConditions.urlContains("/pim/viewEmployeeList"));
            System.out.println("Successfully navigated to the PIM Employee List page!");

            By leaveMenu = By.xpath("//span[text()='Leave' and contains(@class, 'oxd-main-menu-item--name')]");
            WebElement leaveElement = wait.until(ExpectedConditions.elementToBeClickable(leaveMenu));
            js.executeScript("arguments[0].scrollIntoView(true);", leaveElement);
            slowDown(1000);
            System.out.println("Clicking the Leave menu...");
            leaveElement.click();
            wait.until(ExpectedConditions.urlContains("/leave/viewLeaveList"));
            System.out.println("Successfully navigated to the Leave List page!");

            By sidebarCollapseButton = By.xpath("//button[contains(@class, 'oxd-icon-button') and .//i[contains(@class, 'bi-chevron-left')]]");
            WebElement collapseButton = wait.until(ExpectedConditions.elementToBeClickable(sidebarCollapseButton));
            System.out.println("Clicking the sidebar collapse button...");
            collapseButton.click();
            slowDown(1000);

            By sidebarExpandButton = By.xpath("//button[contains(@class, 'oxd-icon-button') and .//i[contains(@class, 'bi-caret-up-fill')]]");
            WebElement expandButton = wait.until(ExpectedConditions.elementToBeClickable(sidebarExpandButton));
            System.out.println("Clicking the sidebar expand button...");
            expandButton.click();
            slowDown(1000);
            System.out.println("Sidebar interaction completed successfully!");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("Test execution completed!");
        }
    }
}