package com.test.ajax;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandles {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	WebDriver driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	driver.findElement(By.cssSelector(".blinkingText")).click();
	Set<String> windows=driver.getWindowHandles();
	Iterator<String> it=windows.iterator();
	String parentId=it.next();
	String childId=it.next();
	driver.switchTo().window(childId);
	String longText=driver.findElement(By.cssSelector(".im-para.red")).getText();
	System.out.println(longText);
	String emailId=longText.split("at")[1].trim().split(" ")[0];
	System.out.println(emailId);
	driver.switchTo().window(parentId);
	driver.findElement(By.id("username")).sendKeys(emailId);
    }

}
