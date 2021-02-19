package com.selenium_prj;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Facebook {

	public static void main(String[] args) {
 
		System.setProperty( "webdriver.chrome.driver",  "C:\\Users\\Jenish Mon\\eclipse-workspace\\Selenium_Project\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get( "https://www.facebook.com/");
		
		WebElement email = driver.findElement( By.id( "email"));
		email.sendKeys( "abc@gmail.com");
		
		WebElement  password = driver.findElement( By.id( "pass"));
		password.sendKeys( "1234abcd");
		
		WebElement  login = driver.findElement( By.name( "login"));
		login.click();
		
		
		
		
		
		
	}

}
