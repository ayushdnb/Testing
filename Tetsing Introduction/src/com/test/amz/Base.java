package com.test.amz;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	String[] itemsNeeded= {"Cucumber","Brocolli","Beetroot"};
	driver.get("https://rahulshettyacademy.com/seleniumPractise/");
	Thread.sleep(5);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(5));
	addItems(driver,itemsNeeded);
	driver.findElement(By.cssSelector("img[alt='Cart']")).click();
	driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
	driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
	driver.findElement(By.cssSelector("button.promoBtn")).click();
	//explicit wait
	w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
	System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }

    public static void addItems(WebDriver driver,String[] itemsNeeded) {
	int j=0;
	List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
	for(int i=0;i<products.size();i++) {
	    String formattedName=products.get(i).getText().split("-")[0].trim();
	    List<String> itemsNeededList=Arrays.asList(itemsNeeded);
	    if(itemsNeededList.contains(formattedName)) {
		j++;
		driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
	    }
	    if(j==itemsNeeded.length) {
		break;
	    }
	}
	
    }

}
