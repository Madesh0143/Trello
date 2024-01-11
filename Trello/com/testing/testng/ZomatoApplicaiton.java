package com.testing.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ZomatoApplicaiton
{
	WebDriver driver;

	@BeforeMethod
	public void pre_condition() 
	{
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
//	@AfterMethod
	public void post_condition() 
	{
		driver.manage().window().minimize();
		driver.quit();
	}
	
	@Test(priority = 1)
	public void login_testCase() throws InterruptedException 
	{
		driver.get("https://www.zomato.com/india");
		
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
//		WebElement continue_email = driver.findElement(By.xpath("//div[@aria-label='Continue with Email']"));
		WebElement first_Frame = driver.findElement(By.xpath("//iframe[@id='auth-login-ui']"));
		driver.switchTo().frame(first_Frame);
		
		WebElement continue_email = driver.findElement(By.xpath("//div[@aria-label='Continue with Email']"));
		actions.click(continue_email).perform();
		
;		driver.findElement(By.xpath("//section[@class='sc-1yzxt5f-4 codcVD']/input")).sendKeys("madesh123@gmail.com");
	}
}
