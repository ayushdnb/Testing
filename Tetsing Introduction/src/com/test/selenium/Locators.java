package com.test.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) throws InterruptedException {
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rahulshettyacademy.com/locatorspractice/");
	//<input type="text" placeholder="Username" id="inputUsername" value="">
	driver.findElement(By.id("inputUsername")).sendKeys("rahul");
	//<input type="password" placeholder="Password" name="inputPassword" value="">
	driver.findElement(By.name("inputPassword")).sendKeys("Hello123");
	//<button class="submit signInBtn" type="submit">Sign In</button>
	driver.findElement(By.className("signInBtn")).click();
	//<p class="error">* Incorrect username or password </p>
	System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
	//<a href="#">Forgot your password?</a>
	driver.findElement(By.linkText("Forgot your password?")).click();
	//<input type="text" placeholder="Name">
	//input[@placeholder='Name']
	driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");
	//<input type="text" placeholder="Email">
	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("john@srsa.com");
	driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
	driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("john@gmail.com");
	//<input type="text" placeholder="Phone Number">
	driver.findElement(By.xpath("//form/input[3]")).sendKeys("9999999999");
	//<button class="reset-pwd-btn">Reset Login</button>
	driver.findElement(By.className("reset-pwd-btn")).click();
	//<p class="infoMsg">Please use temporary password 'rahulshettyacademy' to Login. </p>
	System.out.println(driver.findElement(By.cssSelector("p.infoMsg")).getText());
	driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
	driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
	driver.findElement(By.id("chkboxOne")).click();
	driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();	
	// TODO Auto-generated method stub
	
    }

}
