package com.test.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dropdown {

    public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	driver.findElement(By.xpath("//a[@value='BLR']")).click();
	Thread.sleep(2000);
	// Explicit wait before selecting the destination
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Click on the "To" dropdown and select Chennai (MAA)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@value='MAA'])[2]"))).click();
	driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
	driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active ui-state-hover']")).click();
    }

}
