package com.test.streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebSorting {
    public static void main(String[] args) {
	String nameOfItem="Banana";
	String nameOfItem2="Rice";
	WebDriver driver=new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	driver.findElement(By.xpath("//thead/tr/th[1]")).click();
	List<WebElement> originalList=driver.findElements(By.xpath("//tbody/tr/td[1]"));
	List<String> sortedList=originalList.stream().map(s->s.getText()).sorted().collect(Collectors.toList());
	List<String> originalListString=originalList.stream().map(s->s.getText()).collect(Collectors.toList());
	Assert.assertEquals(sortedList, originalListString);
	List<String> priceOfItem;
	do {
	    List<WebElement> row=driver.findElements(By.xpath("//tbody/tr/td[1]"));
	    priceOfItem=row.stream().filter(s->s.getText().contains(nameOfItem2)).map(s->getItemPrice(s)).collect(Collectors.toList());
	    priceOfItem.forEach(a->System.out.println(a));
	    if(priceOfItem.size()<1) {
		driver.findElement(By.xpath("//ul[@class='pagination pull-right']/li[7]")).click();
	    }
		}while(priceOfItem.size()<1);
    }

    private static String getItemPrice(WebElement s) {
	return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }

}
