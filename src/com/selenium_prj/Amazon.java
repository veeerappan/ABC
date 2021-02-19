package com.selenium_prj;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.sun.tools.javac.util.Context.Key;

public class Amazon {

	public static void main(String[] args) {
 
	System.setProperty( "webdriver.chrome.driver","C:\\Users\\Jenish Mon\\eclipse-workspace\\Selenium_Project\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get( "https://www.amazon.in/");
	
	WebElement searchbox=  driver.findElement(By.id( "twotabsearchtextbox"));
	searchbox.sendKeys( "Apple"+Keys.ENTER);
	WebElement image = driver.findElement( By.xpath( "//*[@id=\"search\"]/div[1]/div[2]/div/span[3]/div[2]/div[3]/div/span/div/div/div[2]/div[1]/div/div/span/a/div/img"));
	 image.click();
	}

}
