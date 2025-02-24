	package com.test.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntroduction {

    public static void main(String[] args) {
	
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.com/");
	System.out.println(driver.getTitle());
	//System.out.println(driver.getCurrentUrl());
	System.out.println(driver.toString());
	System.out.println(driver.getWindowHandle());
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getClass());
	driver.quit();
	//driver.close();
	// TODO Auto-generated method stub

    }

}
