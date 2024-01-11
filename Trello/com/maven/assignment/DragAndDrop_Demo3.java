package com.maven.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop_Demo3 {

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	    driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		// object of actions class
		
		Actions actions = new Actions(driver);
		
		// Source Element
		
		WebElement Oslo_box1 = driver.findElement(By.id("box1"));
		WebElement Stockholm_box2 = driver.findElement(By.id("box2"));
		WebElement Washington_box3 = driver.findElement(By.id("box3"));
		WebElement Copenhagen_box4 = driver.findElement(By.id("box4"));
		WebElement Seoul_box5 = driver.findElement(By.id("box5"));
		WebElement Rome_box6= driver.findElement(By.id("box6"));
		WebElement Madrid_box7 = driver.findElement(By.id("box7"));
		
		// Target Element
		
		WebElement Italy = driver.findElement(By.xpath("//div[text()='Italy']"));
		WebElement spain = driver.findElement(By.xpath("//div[text()='Spain']"));
		WebElement norway = driver.findElement(By.xpath("//div[text()='Norway']"));
		WebElement denmark = driver.findElement(By.xpath("//div[text()='Denmark']"));
		WebElement skorea = driver.findElement(By.xpath("//div[text()='South Korea']"));
		WebElement sweden = driver.findElement(By.xpath("//div[text()='Sweden']"));
		WebElement us = driver.findElement(By.xpath("//div[text()='United States']"));
		
		
		actions.dragAndDrop(Oslo_box1, norway).pause(2000).dragAndDrop(Stockholm_box2, sweden).pause(2000).dragAndDrop(Washington_box3, us).pause(2000).dragAndDrop(Copenhagen_box4, denmark).pause(2000).dragAndDrop(Seoul_box5, skorea).pause(2000).dragAndDrop(Rome_box6, Italy).pause(2000).dragAndDrop(Madrid_box7, spain).build().perform();

	}

}
