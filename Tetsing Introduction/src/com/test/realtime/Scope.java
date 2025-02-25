package com.test.realtime;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.ajax.WindowHandles;

public class Scope {

    public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("http://qaclickacademy.com/practice.php");
	WebElement footerDriver=driver.findElement(By.id("gf-BIG"));
	WebElement footerFirstColumnDriver=footerDriver.findElement(By.xpath("//table[@class='gf-t']/tbody/tr/td[1]/ul"));
	System.out.println("Number of links in Footer first Column: "+footerFirstColumnDriver.findElements(By.tagName("a")).size());
	for(int i=1;i<footerFirstColumnDriver.findElements(By.tagName("a")).size();i++) {
	    String clickOnLink=Keys.chord(Keys.CONTROL,Keys.ENTER);
	    footerFirstColumnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
	    Thread.sleep(5000L);
	}
	Set<String> windowHandles=driver.getWindowHandles();
	Iterator<String> itr=windowHandles.iterator();
	while(itr.hasNext()) {
	    driver.switchTo().window(itr.next());
	    System.out.println(driver.getTitle());
	}

    }

}
