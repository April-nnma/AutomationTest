package BT3;

import org.openqa.selenium.By;

public class Locators {
    public static By searchInput = By.id("twotabsearchtextbox");
    public static By searchButton = By.id("nav-search-submit-button");
    public static By menFilterCheckbox = By.xpath("//li[@id='p_n_feature_thirty-two_browse-bin/121075132011']//label");
    public static By firstSpanInResultsHeader = By.xpath("//h2[@class='a-size-base a-spacing-small a-spacing-top-small a-text-normal']/span[1]");
    public static By womensFootwearDiv = By.xpath("//div[contains(@class, 's-card-container') and contains(@class, 's-overflow-hidden') and contains(@class, 's-visual-card-navigation-product-image-container')]");
    public static By shopTopAdidasCollectionsHeader = By.xpath("//h2[text()='Shop top adidas collections']");
    public static By cartLink = By.id("nav-cart");
    public static By bagsLink = By.xpath("//a[text()='Bags']");
    public static By adidasHeader = By.xpath("//h2[@class='a-size-mini s-line-clamp-1']//span[text()='adidas']");
    public static By deliveryDetails = By.xpath("//div[contains(@class, 'a-row') and contains(@class, 'a-size-base') and contains(@class, 's-align-children-center')]");
    public static By productImageDiv = By.xpath("//div[contains(@class, 'a-section') and contains(@class, 'aok-relative') and contains(@class, 's-image-square-aspect')]");
    public static By productTitleLink = By.xpath("//a[contains(@class, 'a-link-normal') and contains(@class, 's-line-clamp-4') and contains(@href, '/adidas-Womens-Court-Sneaker-White')]");
    public static By priceBlockDiv = By.xpath("//div[@class='a-section aok-inline-block' and .//span[contains(@class, 'a-price')]]");
    public static By priceBlock = By.xpath("//div[@class='a-section aok-inline-block' and .//span[@class='a-price a-text-price']]");
}

