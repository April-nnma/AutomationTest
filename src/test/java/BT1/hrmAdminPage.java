package BT1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import static BT2.airbnbHomePage.scrollIntoView;

public class hrmAdminPage {

    public static void slowDown(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void safeClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            element.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Element click intercepted. Using JavaScript click...");
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

            driver.get("https://opensource-demo.orangehrmlive.com/");
            LoginPage.login(driver, "Admin", "admin123");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.urlContains("/dashboard/index"));

            // slide bar -> Admin menu
            By adminMenu = By.xpath("//span[text()='Admin' and contains(@class, 'oxd-main-menu-item--name')]");
            WebElement adminElement = wait.until(ExpectedConditions.elementToBeClickable(adminMenu));
            safeClick(driver, adminElement);
            slowDown(2000);

            wait.until(ExpectedConditions.urlContains("/admin/viewSystemUsers"));

            // button add
            By addButton = By.xpath("//button[contains(@class, 'oxd-button') and .//i[contains(@class, 'bi-plus')]]");
            WebElement addBtn = wait.until(ExpectedConditions.elementToBeClickable(addButton));
            js.executeScript("arguments[0].scrollIntoView(true);", addBtn);
            System.out.println("Clicking the Add button...");
            safeClick(driver, addBtn);

            wait.until(ExpectedConditions.urlContains("/admin/saveSystemUser"));
            System.out.println("Successfully");
            driver.navigate().back();
            wait.until(ExpectedConditions.urlContains("/admin/viewSystemUsers"));
            System.out.println("Returned to Admin page successfully!");

            // input username
            By usernameInput = By.xpath("//label[text()='Username']/following::input[contains(@class, 'oxd-input')]");
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
            usernameField.sendKeys("admin");

            // select dropdown admin
            By userRoleDropdown = By.xpath("//div[contains(@class, 'oxd-select-text')]");
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(userRoleDropdown));
            safeClick(driver, dropdown);

            By roleOption = By.xpath("//div[@role='option' and contains(., 'Admin')]");
            WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(roleOption));
            System.out.println("Selecting 'Admin' from the dropdown...");
            safeClick(driver, option);

            slowDown(1000);

            // search
            By searchButton = By.xpath("//button[contains(@class, 'oxd-button') and contains(., 'Search')]");
            WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            System.out.println("Clicking the Search button...");
            safeClick(driver, searchBtn);
            slowDown(2000);

            // reset
            By resetButton = By.xpath("//button[contains(@class, 'oxd-button--ghost') and contains(., 'Reset')]");
            WebElement resetBtn = wait.until(ExpectedConditions.elementToBeClickable(resetButton));
            System.out.println("Clicking the Reset button...");
            safeClick(driver, resetBtn);

            slowDown(1000);
            String usernameValue = usernameField.getAttribute("value");
            if (usernameValue.isEmpty()) {
                System.out.println("Reset button worked: Username field is cleared.");
            } else {
                System.err.println("Reset button failed: Username field is not cleared.");
            }

            //user management
            By userManagementDropdown = By.xpath("//li[contains(@class, 'oxd-topbar-body-nav-tab') and .//span[contains(text(), 'User Management')]]");
            By usersOption = By.xpath("//ul[contains(@class, 'oxd-dropdown-menu')]//a[contains(text(), 'Users')]");
            WebElement userManagementElement = wait.until(ExpectedConditions.elementToBeClickable(userManagementDropdown));
            System.out.println("Opening");
            scrollIntoView(driver, userManagementElement);
            safeClick(driver, userManagementElement);
            slowDown(1000);
            //choose user
            WebElement usersOptionElement = wait.until(ExpectedConditions.elementToBeClickable(usersOption));
            System.out.println("Selecting 'Users' option...");
            scrollIntoView(driver, usersOptionElement);
            safeClick(driver, usersOptionElement);
            slowDown(1000);
            System.out.println("Successfully selected 'Users' option!");

            // delete
            By deleteIcon = By.xpath("//button[contains(@class, 'oxd-icon-button') and .//i[contains(@class, 'bi-trash')]]");
            WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(deleteIcon));
            System.out.println("Clicking the delete icon...");
            safeClick(driver, deleteButton);

            slowDown(2000);
            // edit
            By editIcon = By.xpath("(//button[contains(@class, 'oxd-icon-button') and .//i[contains(@class, 'bi-pencil-fill')]])[1]");
            WebElement editButton = wait.until(ExpectedConditions.presenceOfElementLocated(editIcon));
            js.executeScript("arguments[0].scrollIntoView(true);", editButton);
            slowDown(1000);
            System.out.println("Attempting to click the edit icon...");
            safeClick(driver, editButton);

            slowDown(2000);

            wait.until(ExpectedConditions.urlContains("/admin/saveSystemUser/"));
            System.out.println("Successfully navigated to the Edit System User page!");

            // slide bar -> pim
            By pimMenu = By.xpath("//span[text()='PIM' and contains(@class, 'oxd-main-menu-item--name')]");
            WebElement pimElement = wait.until(ExpectedConditions.elementToBeClickable(pimMenu));
            System.out.println("Navigating to PIM Menu...");
            scrollIntoView(driver, pimElement);
            safeClick(driver, pimElement);
            wait.until(ExpectedConditions.urlContains("/pim/viewEmployeeList"));
            System.out.println("Successfully navigated to the PIM Employee List page!");

            // slide bar -> leave
            By leaveMenu = By.xpath("//span[text()='Leave' and contains(@class, 'oxd-main-menu-item--name')]");
            WebElement leaveElement = wait.until(ExpectedConditions.elementToBeClickable(leaveMenu));
            System.out.println("Navigating to Leave Menu...");
            scrollIntoView(driver, leaveElement);
            safeClick(driver, leaveElement);
            wait.until(ExpectedConditions.urlContains("/leave/viewLeaveList"));
            System.out.println("Successfully navigated to the Leave List page!");

            // slide bar -> collapse
            By sidebarCollapseButton = By.xpath("//button[contains(@class, 'oxd-icon-button') and .//i[contains(@class, 'bi-chevron-left')]]");
            WebElement collapseButton = wait.until(ExpectedConditions.elementToBeClickable(sidebarCollapseButton));
            System.out.println("Collapsing the sidebar...");
            safeClick(driver, collapseButton);
            slowDown(1000);

            System.out.println("Expanding the sidebar...");
            safeClick(driver, collapseButton);
            slowDown(1000);
            //toggle
            By toggleButton = By.xpath("//div[contains(@class, '--toggle')]//button[contains(@class, 'oxd-icon-button') and .//i[contains(@class, 'bi-caret-up-fill')]]");
            WebElement toggleButtonElement = wait.until(ExpectedConditions.elementToBeClickable(toggleButton));
            System.out.println("Clicking the toggle button...");
            safeClick(driver, toggleButtonElement);
            slowDown(1000);
            System.out.println("Toggle button clicked successfully!");

            System.out.println("Test execution completed successfully!");

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
            System.out.println("Browser closed.");
        }
    }
}