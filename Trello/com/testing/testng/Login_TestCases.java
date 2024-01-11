package com.testing.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_TestCases 
{
	WebDriver driver;

	@BeforeMethod
	public void pre_condition() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void post_condition() 
	{
		driver.manage().window().minimize();
		driver.quit();	
	}

	@Test(priority = 2)
	public void fb_login_testCase() 
	{
		driver.get("https://www.facebook.com/");

		driver.findElement(By.id("email")).sendKeys("madesh123@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.name("login")).submit();

	}

	@Test(priority = 1)
	public void swagLabs_login_testCase() 
	{
		driver.get("https://www.saucedemo.com/");

		WebElement userName_textField = driver.findElement(By.id("user-name"));
		userName_textField.sendKeys("standard_user");

		WebElement password_textField = driver.findElement(By.id("password"));
		password_textField.sendKeys("secret_sauce");

		driver.findElement(By.id("login-button")).click();

	}

}
