package com.maven.actionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SendKeysMethods {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.saucedemo.com/");
		Actions actions = new Actions(driver);
		
		WebElement username_TextField = driver.findElement(By.id("user-name"));
		WebElement password_TextField = driver.findElement(By.id("password"));
		
		actions.sendKeys(username_TextField, "madesh@123gmail.com").sendKeys(password_TextField,"123456").perform();

	}

}
