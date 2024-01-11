package com.maven.actionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Asig1 {

	public static void main(String[] args)
	{
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.landrover.in/range-rover/index.html");
		Actions actions = new Actions(driver);
		
		WebElement vechicles_Opts = driver.findElement(By.xpath("//a[@aria-label='EXPLORE VEHICLES']/span[text()='VEHICLES']"));
		 actions.click(vechicles_Opts).perform();
		 
		WebElement range_rover_evoque = driver.findElement(By.xpath("//div[@class='dxnav-vehicle-menu__categories']//p[text()='RANGE ROVER EVOQUE']"));
		WebElement new_range_rover = driver.findElement(By.xpath("//div[@class='dxnav-vehicle-menu__categories']//p[text()='NEW RANGE ROVER VELAR']"));
		WebElement range_over_sport = driver.findElement(By.xpath("//div[@class='dxnav-vehicle-menu__categories']//p[text()='RANGE ROVER SPORT']"));
		WebElement range_over = driver.findElement(By.xpath("//div[@class='dxnav-vehicle-menu__categories']//p[text()='RANGE ROVER']"));
		
		WebElement defender_130 = driver.findElement(By.xpath("//div[@class='dxnav-vehicle-menu__categories']//p[text()='DEFENDER 130']"));
		WebElement defender_110 = driver.findElement(By.xpath("//div[@class='dxnav-vehicle-menu__categories']//p[text()='DEFENDER 110']"));
		WebElement defender_90 = driver.findElement(By.xpath("//div[@class='dxnav-vehicle-menu__categories']//p[text()='DEFENDER 90']"));
		
		WebElement discovery_sport = driver.findElement(By.xpath("//div[@class='dxnav-vehicle-menu__categories']//p[text()='DISCOVERY SPORT']"));
		WebElement discovery = driver.findElement(By.xpath("//div[@class='dxnav-vehicle-menu__categories']//p[text()='DISCOVERY']"));
		/*
		 range_rover_evoque : 183 91
		 new_range_rover    : 183 91
		 range_over_sport   : 183 91
		 range_over         : 183 91
		 
		 defender_130       : 183 91
		 defender_110       : 183 91
		 defender_90        : 183 91
		 
		 discovery_sport    : 183 91
		 discovery          : 183 91
		 
		 */
		
//		actions.moveToElement(range_rover_evoque).pause(2000).moveToElement(new_range_rover).pause(2000).moveToElement(range_over_sport).pause(2000).moveToElement(range_over).pause(2000).moveToElement(defender_130).pause(2000).moveToElement(defender_110).pause(2000).moveToElement(defender_90).pause(2000).moveToElement(discovery_sport).pause(2000).moveToElement(discovery).build().perform();
		
		actions.moveToElement(range_rover_evoque, 0, 0).pause(2000).moveToElement(range_rover_evoque, 0, 182).build().perform();
//		.pause(2000).moveToElement(range_rover_evoque, 0, 36).pause(2000).moveToElement(range_rover_evoque, 0, 48).pause(2000).moveToElement(range_rover_evoque, 0, 60).pause(2000).moveToElement(range_rover_evoque, 0, 72).pause(2000).moveToElement(range_rover_evoque, 0, 84).pause(2000).moveToElement(range_rover_evoque, 0, 96).build().perform();

	}

}
