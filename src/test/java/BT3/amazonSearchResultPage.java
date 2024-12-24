package BT3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class amazonSearchResultPage {
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
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
                try {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

                    driver.get("https://www.amazon.com");
                    System.out.println("Amazon website opened successfully!");
                    slowDown(2000);

                    // input
                    WebElement searchBoxElement = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.searchInput));
                    searchBoxElement.click();
                    searchBoxElement.sendKeys("adidas");
                    System.out.println("Entered 'adidas' in the search bar.");
                    slowDown(1000);

                    // icon search
                    WebElement searchButtonElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.searchButton));
                    searchButtonElement.click();
                    System.out.println("Search button clicked.");
                    slowDown(2000);

                    // cart
                    WebElement cartElement = wait.until(ExpectedConditions.elementToBeClickable(Locators.cartLink));
                    scrollIntoView(driver, cartElement);
                    cartElement.click();
                    System.out.println("Navigated to the cart page.");
                    slowDown(2000);
                    driver.navigate().back();
                    System.out.println("Returned to the main page.");
                    slowDown(2000);

                    // span "1-48 of over 30,000 results for"
                    WebElement firstSpanElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.firstSpanInResultsHeader));
                    System.out.println("Located the first span element successfully: " + firstSpanElement.getText());
                    slowDown(2000);

                    // div women
                    WebElement womensFootwearElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.womensFootwearDiv));
                    scrollIntoView(driver, womensFootwearElement);
                    System.out.println("Located the Women's Footwear div successfully!");
                    slowDown(2000);

                    // span "Shop top adidas collections"
                    WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.shopTopAdidasCollectionsHeader));
                    scrollIntoView(driver, headerElement);
                    System.out.println("Header 'Shop top adidas collections' located successfully!");
                    slowDown(2000);

                    // baglink
                    WebElement bagsLinkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.bagsLink));
                    scrollIntoView(driver, bagsLinkElement);
                    bagsLinkElement.click();
                    System.out.println("Clicked on the 'Bags' link.");
                    slowDown(2000);
                    driver.navigate().back();
                    System.out.println("Returned to the main page.");
                    slowDown(2000);

                    // img
                    WebElement productImageDivElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.productImageDiv));
                    scrollIntoView(driver, productImageDivElement);
                    productImageDivElement.click();
                    System.out.println("Located the product image div successfully!");
                    slowDown(2000);
                    driver.navigate().back();
                    System.out.println("Returned to the main page.");
                    slowDown(2000);

                    // header adidas
                    WebElement adidasHeaderElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.adidasHeader));
                    scrollIntoView(driver, adidasHeaderElement);
                    System.out.println("Located the adidas header successfully!");
                    slowDown(2000);

                    // title
                    WebElement productTitleLinkElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.productTitleLink));
                    scrollIntoView(driver, productTitleLinkElement);
                    productTitleLinkElement.click();
                    System.out.println("Located the product title link successfully!");
                    slowDown(2000);
                    driver.navigate().back();
                    System.out.println("Returned to the main page.");
                    slowDown(2000);

                    // price
                    WebElement priceBlockElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.priceBlockDiv));
                    scrollIntoView(driver, priceBlockElement);
                    System.out.println("Price Block Text: " + priceBlockElement.getText());
                    slowDown(2000);

                    // list price --
                    WebElement listPriceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.priceBlock));
                    listPriceElement.click();
                    System.out.println("List Price Text");
                    slowDown(2000);
                    driver.navigate().back();
                    System.out.println("Returned to the main page.");
                    slowDown(2000);

                    // delivery
                    WebElement deliveryDetailsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.deliveryDetails));
                    scrollIntoView(driver, deliveryDetailsElement);
                    System.out.println("Located the delivery details successfully!");
                    slowDown(2000);

                    //checkbox men
                    WebElement menCheckboxElement = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.menFilterCheckbox));
                    scrollIntoView(driver, menCheckboxElement);
                    try {
                        System.out.println("Clicking the 'Men' filter checkbox...");
                        menCheckboxElement.click();
                    } catch (Exception e) {
                        System.out.println("Element click intercepted. Using JavaScript click...");
                        js.executeScript("arguments[0].click();", menCheckboxElement);
                    }
                    slowDown(2000);
                    System.out.println("'Men' filter applied successfully!");
                    slowDown(2000);
                } catch (Exception e) {
                    System.err.println("An error occurred: " + e.getMessage());
                } finally {
                    driver.quit();
                    System.out.println("Browser closed.");
                }
            }
    }