package BT2;

import org.openqa.selenium.By;

public class Locators {
    public static By aboutLink = By.xpath("//a[@aria-current='page' and contains(text(),'About')]");
    public static By destinationSection = By.xpath("//p[contains(text(),'Địa điểm')]/following-sibling::p[contains(text(),'Bạn sắp đi đâu?')]");
    public static By datePicker = By.xpath("//div[contains(@class, 'col-span-4') and .//p[contains(text(),'19/12/2024')]]");
    public static By calendarStartDay = By.xpath("//button[contains(@class,'rdrDay') and .//span[text()='19']]");
    public static By calendarEndDay = By.xpath("//button[contains(@class,'rdrDay') and .//span[text()='26']]");
    public static By addGuestButton = By.xpath("//button[contains(text(),'Thêm khách')]");
    public static By searchButton = By.xpath("//span[@role='img' and @aria-label='search']");
}