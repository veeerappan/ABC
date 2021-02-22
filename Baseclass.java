package com.automation_practice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass {
	public static WebDriver driver;
	public static WebElement element;
	
	public static WebDriver browserlanch(String browser) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
				 driver = new ChromeDriver();
				
			}
			else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
				 driver = new InternetExplorerDriver();
				
			}
			else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.geko.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
				 driver = new FirefoxDriver();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		return driver;
	}
	 public static void close() {
		 driver.close();
	}
	
	 public static void quit() {
		 driver.quit();
	}
	public static void navigateto (String url) {
		driver.navigate().to(url);
		
	}
	public static void navigate(String cmd) {
		if (cmd.equalsIgnoreCase("forward")) {
			driver.navigate().forward();
		}
		else if (cmd.equalsIgnoreCase("back")) {
			driver.navigate().back();
		}
		else if (cmd.equalsIgnoreCase("refresh")) {
			driver.navigate().refresh();
		}
	
	}
	public static void get(String url) {
		driver.get(url);
	}
	public static void alert(String alert_t) {
		if (alert_t.equalsIgnoreCase("accept")) {
			Alert alert_n = driver.switchTo().alert();
			alert_n.accept();
		}
		else if (alert_t.equalsIgnoreCase("dismiss")) {
			Alert alert_n = driver.switchTo().alert();
			alert_n.dismiss();
		}
		else if (alert_t.equalsIgnoreCase("prompt alert")) {
			Alert alert_n = driver.switchTo().alert();
			String text = alert_n.getText();
			System.out.println(text);
		}

	}
	
	public static void action(WebElement element,String act_nam ) {
		Actions a= new Actions(driver);
		if (act_nam.equalsIgnoreCase("click")) {
			a.moveToElement(element).build().perform();
			a.click(element).build().perform();
			
		}
		else if (act_nam.equalsIgnoreCase("contextclick")) {
			a.contextClick(element).build().perform();
			
			
		}
		else if (act_nam.equalsIgnoreCase("move to")) {
			a.moveToElement(element).build().perform();
			
		}

	}
	public static void frame(WebElement element,String frame) {
		if (frame.equalsIgnoreCase("frame")) {
			driver.switchTo().frame(element);
			
		}
		else if (frame.equalsIgnoreCase("default")) {
			driver.switchTo().defaultContent();
			
		}
	}
	public static void windowhandle(WebElement windowhandle,String handling) {
		if (handling.equalsIgnoreCase("window handle")) {
			String name = driver.getWindowHandle();
		}else if (handling.equalsIgnoreCase("window handles")) {
			Set<String> name = driver.getWindowHandles();	
		}
	}
	public static void dropdown(WebElement element,String selectby,String element1) {
		Select s = new Select(element);
		if (selectby.equalsIgnoreCase("value")) {
			s.selectByValue(element1);
		}
		else if (selectby.equalsIgnoreCase("index")) {
			int index = Integer.parseInt(element1);
			s.selectByIndex(index);
		}
		else if (selectby.equalsIgnoreCase("visibletext")) {
			s.selectByVisibleText(element1);
		}
		else if (selectby.equalsIgnoreCase("de value")) {
			s.deselectByValue(element1);
		}
		else if (selectby.equalsIgnoreCase("de index")) {
			int index = Integer.parseInt(element1);
			s.deselectByIndex(index);
		}
		else if (selectby.equalsIgnoreCase("de visibletext")) {
			s.deselectByVisibleText(element1);
		}
	}
	public static void checkbox(WebElement element) {
		element.click();
	}	
	public static void isenable(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println(enabled);
	}
	public static void isdisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		System.out.println(displayed);
	}
	public static void isselected(WebElement element) {
		boolean selected = element.isSelected();
		System.out.println(selected);
	}
	public static void gettext(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}
	public static void gettitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	public static void getcurrenturl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}
	public static void getoptions(WebElement element,String get) {
		Select s = new Select(element);
		if (get.equalsIgnoreCase("get options")) {
			List<WebElement> options = s.getOptions();
			for (WebElement alltext : options) {
				String text = alltext.getText();
				System.out.println(text);
		}
		}
		else if (get.equalsIgnoreCase("get first selected")) {
			WebElement firstSelectedOption = s.getFirstSelectedOption();
			String text = firstSelectedOption.getText();
			System.out.println(text);
			
		}else if (get.equalsIgnoreCase("get all selected options")) {
			List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
			
			
		}
	}
	public static void getattribute(WebElement element, String v_or_n) {
		String attribute = element.getAttribute(v_or_n);
		System.out.println(attribute);
	}
	public static void takescreenshots(String path) throws Throwable  {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(source, destination);
	
	
	}
	public static void scroll(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
	}
	public static void sendkeys(WebElement element,String input) {
		element.sendKeys(input);
	}
	public static void ismultiple(WebElement element) {
		Select s = new Select(element);
		boolean multiple = s.isMultiple();
		System.out.println(multiple);
	}
	public static void click(WebElement element) {
		element.click();
		
	}
	public static void robot(String noofclick) throws Throwable {
		Robot r = new Robot();
		if (noofclick.equalsIgnoreCase("single click")) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
		}
		else if (noofclick.equalsIgnoreCase("doubleclick")) {
			
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}
	}
	public static void wat(String waitfun,int tim) {
		if (waitfun.equalsIgnoreCase("implicit wait")) {
			driver.manage().timeouts().implicitlyWait(tim, TimeUnit.SECONDS);
			
		}
		else if (waitfun.equalsIgnoreCase("explicit wait")) {
			WebDriverWait wait = new WebDriverWait(driver, tim);
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}
	}
	
	
	
	
	
	

}
