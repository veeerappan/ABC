package com.selenium_prj;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) {
 
		System.setProperty( "webdriver.chrome.driver", "C:\\Users\\Jenish Mon\\eclipse-workspace\\Selenium_Project\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get( "https://www.facebook.com/");
		
		WebElement  Create_new = driver.findElement( By.id( "u_0_2"));
		Create_new.click();
		
		WebElement  day = driver.findElement( By.id( "day"));
		
		Select s = new Select(day);
		
		
		
		
		
		
	}

}
