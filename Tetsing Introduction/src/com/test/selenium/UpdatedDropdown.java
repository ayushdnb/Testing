package com.test.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

    public static void main(String[] args) throws InterruptedException {

	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
	Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected(), "Checkbox not selected");
	driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
	Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected(), "Checkbox Selected");
	System.out.println(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
	System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	//<div id="divpaxinfo" class="paxinfo">1 Adult</div>
	driver.findElement(By.id("divpaxinfo")).click();
	Thread.sleep(2000);
	for(int i=1;i<5;i++) {
	  //<span class="pax-add pax-enabled" id="hrefIncAdt">+</span>
	  driver.findElement(By.id("hrefIncAdt")).click();
	}
	//<input class="buttonN" id="btnclosepaxoption" value="Done" type="button">
	driver.findElement(By.id("btnclosepaxoption")).click();
	//<div id="divpaxinfo" class="paxinfo">1 Adult</div>
	Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult" );
	System.out.println("All Good");
	System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
	driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
	System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
	if(driver.findElement(By.id("ctl00_mainContent_view_date2")).getAttribute("style").contains("1"))
	{
	System.out.println("its enabled");
	Assert.assertTrue(true);
	}
	else
	{
	Assert.assertTrue(false);
	}

    }
    

}
