package com.test.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {
	String loginName="rahul";	
	WebDriver driver=new ChromeDriver();
	String password=getPassword(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rahulshettyacademy.com/locatorspractice/");
	//<input type="text" placeholder="Username" id="inputUsername" value="">
	driver.findElement(By.id("inputUsername")).sendKeys(loginName);
	//<input type="password" placeholder="Password" name="inputPassword" value="">
	//Correct Password
	driver.findElement(By.name("inputPassword")).sendKeys(password);
	//<button class="submit signInBtn" type="submit">Sign In</button>
	driver.findElement(By.className("signInBtn")).click();
	Thread.sleep(2000);
	//<p style="color: rgb(27, 179, 102); font-size: 18px; text-align: center;">You are successfully logged in.</p>
	System.out.println(driver.findElement(By.tagName("p")).getText());
	Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
	//<div class="login-container"><h2>Hello rahul,</h2><h1>Welcome to <strong style="color: rgb(255, 75, 43);">Rahul Shetty </strong>Academy</h1><p style="color: rgb(27, 179, 102); font-size: 18px; text-align: center;">You are successfully logged in.</p><button class="logout-btn">Log Out</button></div>
	String actualText = driver.findElement(By.cssSelector("div.login-container h2")).getText();
	String expectedText = "Hello " + loginName + ",";  
	Assert.assertEquals(actualText, expectedText, "Test Passed for Login name display for " + loginName);
	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/button[1]")).click();
	driver.close();
    }   
    public static String getPassword(WebDriver driver) throws InterruptedException
    {
	String originalUrl = "https://rahulshettyacademy.com/locatorspractice/";
	driver.get(originalUrl);
	driver.findElement(By.linkText("Forgot your password?")).click();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
	String passwordText = driver.findElement(By.cssSelector("form p")).getText();
	String password = passwordText.split("'")[1];  // Extract text inside quotes
	driver.navigate().to(originalUrl);  // Go back to login page
	return password;
	//0th index - Please use temporary password
	//1st index - rahulshettyacademy' to Login.
	//0th index - rahulshettyacademy
	//1st index - to Login.
    }
}
