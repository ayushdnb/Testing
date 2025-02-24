package com.test.assign4;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

    public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/");
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Multiple Windows']")));
	driver.findElement(By.xpath("//a[normalize-space()='Multiple Windows']")).click();
	driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
	Set<String> windowHandles=driver.getWindowHandles();
	Iterator<String> it=windowHandles.iterator();
	String parentId=it.next();
	String childId=it.next();
	driver.switchTo().window(childId);
	String childWindowText=driver.findElement(By.xpath("//div[@class='example']")).getText();
	System.out.println(childWindowText);
	driver.switchTo().window(parentId);
	String parentWindowText=driver.findElement(By.xpath("//div[@class='example']")).getText();
	String finalMessage=parentWindowText.split("Click")[0].trim();
	System.out.println(finalMessage);
    }

}
