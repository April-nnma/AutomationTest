package BT2;

import org.openqa.selenium.By;

public class Locators {
    public static By airbnbLogoLink = By.xpath("//a[@href='/' and contains(@class, 'flex items-center')]");
    public static By aboutLink = By.xpath("//a[@aria-current='page' and contains(text(),'About')]");
    public static By destinationSection = By.xpath("//div[contains(@class, 'col-span-3') and .//p[contains(text(),'Địa điểm')]]");
    public static By hoChiMinhOption = By.xpath("//p[contains(text(),'Hồ Chí Minh')]/preceding-sibling::div//img");
    public static By canThoOption = By.xpath("//h2[contains(text(), 'Cần Thơ')]");
    public static By interactButton = By.xpath("//button[.//img[contains(@src, '6596121')]]");
    public static By loaiNoiOButton = By.xpath("//button[contains(@class, 'rounded-lg') and text()='Loại nơi ở']");
    public static By giaButton = By.xpath("//button[contains(@class, 'rounded-lg') and text()='Giá']");
    public static By themKhachText = By.xpath("//div[contains(@class, 'col-span-3') and contains(@class, 'cursor-pointer')]//p[text()='Thêm khách']");
    public static By plusButton = By.xpath("//button[contains(@class, 'font-bold') and contains(@class, 'rounded-full') and .//div[text()='+']]");
    public static By minusButton = By.xpath("//button[contains(@class, 'font-bold') and contains(@class, 'rounded-full') and .//div[text()='-']]");
    public static By searchIcon = By.xpath("//div[contains(@class, 'bg-main') and contains(@class, 'rounded-full')]//span[@aria-label='search']");
    public static By homeLink = By.xpath("//li/a[contains(@class, 'block') and contains(text(), 'Home')]");
}