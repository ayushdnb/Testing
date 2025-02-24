package com.test.assign3;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

    public static void main(String[] args) {
	String[] phonesNeeded= {"iphone X","Samsung Note 8","Nokia Edge","Blackberry"};
	WebDriver driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	System.out.println("First Page");
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	//.icon-circled
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".icon-circled")));
	driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
	driver.findElement(By.id("password")).sendKeys("learning");
	//List<WebElement> radioButtons=driver.findElements(By.cssSelector("input[type='radio']"));
	driver.findElement(By.cssSelector("input[value='user']")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn"))).click();
	WebElement userTypesDropdown=driver.findElement(By.cssSelector("select[class='form-control']"));
	Select select=new Select(userTypesDropdown);
	select.selectByVisibleText("Consultant");
	driver.findElement(By.id("terms")).click();
	driver.findElement(By.id("signInBtn")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[class='navbar-brand']")));
	System.out.println("Second Page");
	addPhones(driver,phonesNeeded);
	driver.findElement(By.xpath("//li[@class='nav-item active']/a")).click();
	System.out.println("Third Page");
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@class='btn btn-success']")));
	driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
    }

    private static void addPhones(WebDriver driver, String[] phonesNeeded) {
	List<WebElement> phonesAvailable = driver.findElements(By.cssSelector("h4.card-title a"));
	    int count = 0;
	    for (String phoneNeeded : phonesNeeded) {  // Loop through required phones
	        for (WebElement phone : phonesAvailable) {  // Search in available phones
	            if (phone.getText().trim().equalsIgnoreCase(phoneNeeded)) {
	                // Locate the corresponding 'Add to Cart' button and click
	                WebElement addToCartButton = phone.findElement(By.xpath("./ancestor::div[@class='card h-100']//button[contains(text(),'Add')]"));
	                addToCartButton.click();
	                System.out.println("Added to Cart: " + phoneNeeded);                
	                count++;
	                break;  // Exit inner loop once the phone is found
	            }
	        }
	        if (count == phonesNeeded.length) {
	            System.out.println("All required phones added. Exiting.");
	            break;  // Stop searching if all phones are added
	        }
	    }
}
}
