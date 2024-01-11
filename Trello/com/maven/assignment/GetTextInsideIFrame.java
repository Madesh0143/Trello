package com.maven.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GetTextInsideIFrame
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		
		// Actions Class Objects
		Actions actions = new Actions(driver);
		
		WebElement parent_Frame = driver.findElement(By.id("iframeResult"));
		driver.switchTo().frame(parent_Frame);
		
		WebElement child_Frame = driver.findElement(By.xpath("//iframe[@src='demo_iframe.htm']"));
		driver.switchTo().frame(child_Frame);
		
		WebElement child_Frame_Text = driver.findElement(By.tagName("h1"));
		String  child_text = child_Frame_Text.getText();
		System.out.println("child_text : "+child_text);
		
		driver.switchTo().parentFrame();
		String Parenttext = driver.findElement(By.tagName("p")).getText();
		System.out.println("Parenttext : "+Parenttext);
		
		

	}

}

