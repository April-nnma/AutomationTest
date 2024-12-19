package BT2;

import org.openqa.selenium.By;

public class Locators {
    //public static By aboutLink = By.xpath("//a[@aria-current='page' and contains(text(),'About')]");
    public static By destinationSection = By.xpath("//div[contains(@class, 'col-span-3') and .//p[contains(text(),'Địa điểm')]]"); // Adjusted for the container
    public static By hoChiMinhOption = By.xpath("//p[contains(text(),'Hồ Chí Minh')]/preceding-sibling::div//img");
    public static By datePicker = By.xpath("//div[contains(@class, 'col-span-4') and contains(@class, 'relative') and .//p[contains(text(), '–')]]");
    public static By todayButton = By.xpath("//button[@type='button' and .//span[contains(text(),'Today')]]");
    public static By calendarStartDay = By.xpath("//button[contains(@class,'rdrDay') and .//span[text()='19']]");
    public static By calendarEndDay = By.xpath("//button[contains(@class,'rdrDay') and .//span[text()='26']]");
    public static By addGuestButton = By.xpath("//button[contains(text(),'Thêm khách')]");
    public static By searchButton = By.xpath("//span[@role='img' and @aria-label='search']");
}