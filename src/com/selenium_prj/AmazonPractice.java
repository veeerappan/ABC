package com.selenium_prj;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty( "webdriver.chrome.driver","C:\\Users\\Jenish Mon\\eclipse-workspace\\Selenium_Project\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get( "https://www.facebook.com");
			
	 WebElement  location = driver.findElement( By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img"));
	 location.click();
	 WebElement  signin = driver.findElement( By.xpath( "//*[@id=\"GLUXSignInButton\"]/span/input"));
	 signin.click();  
		
		
	}

}
