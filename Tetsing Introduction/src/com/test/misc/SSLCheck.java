package com.test.misc;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;


public class SSLCheck {

    public static void main(String[] args) throws IOException {
	// TODO Auto-generated method stub
	ChromeOptions options = new ChromeOptions();
	Proxy proxy = new Proxy();
	proxy.setHttpProxy("ipaddress:4444");
	options.setCapability("proxy", proxy);
	Map<String, Object> prefs = new HashMap<String, Object>();
	prefs.put("download.default_directory", "/directory/path");
	options.setExperimentalOption("prefs", prefs);
	// FirefoxOptions options1 = new FirefoxOptions();
	// options1.setAcceptInsecureCerts(true);
	// EdgeOptions options2 = new EdgeOptions();
	options.setAcceptInsecureCerts(true);
	WebDriver driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.get("https://expired.badssl.com/");
	System.out.println(driver.getTitle());
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("C:\\Users\\" + System.getProperty("user.name") + "\\screenshot.png"));

    }
}
