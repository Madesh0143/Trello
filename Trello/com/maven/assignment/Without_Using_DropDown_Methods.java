package com.maven.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Without_Using_DropDown_Methods {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://jqueryui.com/droppable/");
		
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		
		WebElement source_Element = driver.findElement(By.id("draggable"));
		WebElement target_Element = driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(source_Element).release(target_Element).build().perform();
	}

}
