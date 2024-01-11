package com.testng.group;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Trello 
{
	WebDriver driver;
    WebDriverWait w ;
	
	@Parameters({"browserName"})
	@BeforeMethod
	public void pre_contition(String browserName) 
	{
        w = new WebDriverWait(driver, Duration.ofSeconds(5));
//        w.until(excco)
		if (browserName.equals("chrome")) 
		{
			driver = new ChromeDriver();
		} 
		else if (browserName.equals("edge")) 
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	
//	@AfterMethod
	public void post_condition() 
	{
	
		driver.manage().window().minimize();
		driver.quit();
	}
	
// WELCOME MODULE //
	
	@Parameters({"URL","send_email","send_password"})
	
	@Test(priority = 1)
	public void welcome_page(String URL,String send_email,String send_password) 
	{
	      
		driver.get(URL);
		
		String welcome_title = driver.getTitle();  //  Get welcome page title
		String excepted_title = "Manage Your Team’s Projects From Anywhere | Trello";
		
		Assert.assertEquals(welcome_title, excepted_title);
		
		// Click On Login
		login_page( send_email,send_password);
			
	}
	
	
//	LOGIN MODULE  //
	
	@Parameters({"send_email","send_password"})
	
	@Test()
	
	public void  login_page(String send_email,String send_password) 
	{
		WebElement login_Btn = driver.findElement(By.xpath("//div[@class='Buttonsstyles__ButtonGroup-sc-1jwidxo-3 jnMZCI']/a[text()='Log in']"));
//		WebElement login_Btn = driver.switchTo().activeElement();
		           login_Btn.click();
		
		WebElement email_textField = driver.findElement(By.xpath("//input[@placeholder='Enter your email']"));
		           email_textField.sendKeys(send_email);
		
		WebElement Continue_btn = driver.findElement(By.id("login-submit"));
		           Continue_btn.click();
		
		WebElement password_textField = driver.findElement(By.xpath("//input[@placeholder='Enter password']"));
		           password_textField.sendKeys(send_password);
			
			       Continue_btn.click();
			      
	}
	
//// DASHBOARD MODULE //
//	
//	@Parameters("URL")
//	
//	@Test(priority = 3)
//	public void home_page(String URL) 
//	{
//		String ac_homeP_title = driver.getTitle();
//		
//		System.out.println(ac_homeP_title);
//		String ex_homeP_title = "Boards | Trello";
//		
////	   	Assert.assertEquals(ac_homeP_title, ex_homeP_title); // check
//	   	
//	   	
//		
//	}
		
}

