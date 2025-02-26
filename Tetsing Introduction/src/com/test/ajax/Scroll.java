package com.test.ajax;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Scroll {

    public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scroll(0,500)");
	String scrollTable="document.querySelector('.tableFixHead').scrollTop=5000";
	js.executeScript(scrollTable);
	List<WebElement> values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
	int sum=0;
	for(WebElement v:values) {
	    sum+=Integer.parseInt(v.getText());
	}
	System.out.println(sum);
	String displayedText=driver.findElement(By.cssSelector(".totalAmount")).getText();
	int displayedSum=Integer.parseInt(displayedText.split(":")[1].trim());
	System.out.println(displayedSum);
	Assert.assertEquals(displayedSum,sum);
    }

}
