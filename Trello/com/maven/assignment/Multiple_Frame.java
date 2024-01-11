package com.maven.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multiple_Frame 
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

		driver.get("https://demoapps.qspiders.com/frames/multiple?sublist=2");

		WebElement signup_Frame = driver.findElement(By.xpath("//iframe[@src='../signup.html']"));
		driver.switchTo().frame(signup_Frame);

		driver.findElement(By.id("email")).sendKeys("Admin@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Admin@1234");
		driver.findElement(By.id("confirm-password")).sendKeys("Admin@1234");

		driver.switchTo().defaultContent();
		
		WebElement signIn_Frame = driver.findElement(By.xpath("//iframe[@src='../signin.html']"));
		driver.switchTo().frame(signIn_Frame);
		driver.findElement(By.id("email")).sendKeys("Admin@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Admin@1234");
		


	}

}
