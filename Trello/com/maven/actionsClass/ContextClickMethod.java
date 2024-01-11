package com.maven.actionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClickMethod 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.facebook.com/");
		
		Actions actions = new Actions(driver);
		
		Thread.sleep(2000);
		
		WebElement login_btn = driver.findElement(By.name("login"));
		Thread.sleep(2000);
		
		actions.contextClick(login_btn).perform();
		
		
	}

}
