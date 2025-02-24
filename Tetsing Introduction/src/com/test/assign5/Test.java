package com.test.assign5;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

    public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://the-internet.herokuapp.com/");
	//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();
	driver.switchTo().frame("frame-top");
	WebElement middleFrame=driver.findElement(By.name("frame-middle"));
	driver.switchTo().frame(middleFrame);
	String middleFrameMessage=driver.findElement(By.id("content")).getText();
	System.out.println(middleFrameMessage);

    }

}
