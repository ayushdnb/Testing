package com.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

    public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://google.com");
	driver.navigate().to("https://rahulshettyacademy.com");
	Thread.sleep(5000);
	driver.navigate().back();
	// TODO Auto-generated method stub

    }

}
