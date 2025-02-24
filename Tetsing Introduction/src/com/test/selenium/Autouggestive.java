package com.test.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autouggestive {

    public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	driver.findElement(By.id("autosuggest")).sendKeys("ind");
	List<WebElement> options=driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
	for(WebElement option:options) {
	    System.out.println(option.getText());
	    if(option.getText().equals("India")) {
		System.out.println("PASSED!!!!");
		option.click();
		break;
	    }
	}
    }
}
