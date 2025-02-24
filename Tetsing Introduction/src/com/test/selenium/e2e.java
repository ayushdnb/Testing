package com.test.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class e2e {

    public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	System.out.println("URL Hit: "+"True");
	driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	System.out.println("Opened 'From' Dropdown: "+"True");
	driver.findElement(By.xpath("//a[@value='BLR']")).click();
	System.out.println("Selected 'From' City: "+"True");
	//Thread.sleep(2000);
	// Explicit wait before selecting the destination
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // Click on the "To" dropdown and select Chennai (MAA)
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@value='MAA'])[2]"))).click();
        System.out.println("Opened 'To' Dropdown: "+"True");
	driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
	System.out.println("Selected 'To' City: "+"True");
	////a[@class='ui-state-default ui-state-active ui-state-hover']
	//.ui-state-default.ui-state-active.ui-state-hover
	driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();
	System.out.println("Selected 'Departure Date': "+"True");
	if(driver.findElement(By.id("ctl00_mainContent_view_date2")).getAttribute("style").contains("1"))
	{
	System.out.println("its enabled");
	Assert.assertTrue(false);
	}
	else
	{
	Assert.assertTrue(true);
	}
	System.out.println("'Return Date' is Selected: "+"False");
	driver.findElement(By.cssSelector("#divpaxinfo")).click();
	for(int i=1;i<5;i++) {
	    //<span class="pax-add pax-enabled" id="hrefIncAdt">+</span>
	    driver.findElement(By.id("hrefIncAdt")).click();
	}
	Assert.assertEquals(driver.findElement(By.id("spanAudlt")).getText(),"5");
	System.out.println("'Adult' added is 5: "+"True");
	driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
	Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected(), "Checkbox not selected");
	System.out.println("'Senior Citizen' Checkbox is Selected: "+"False");
	driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
	Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected(), "Checkbox Selected");
	System.out.println("'Senior Citizen' Checkbox is Selected: "+"True");
	WebElement staticDropdown=driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
	Select dropdown=new Select(staticDropdown);
	dropdown.selectByVisibleText("USD");
	Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "USD");
	System.out.println("'Currency' Selected is USD: "+"True");
	driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
    }

}
