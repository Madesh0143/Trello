package com.maven.actionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementMethod 
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Object For Actions
		Actions actions = new Actions(driver);

		driver.get("https://www.myntra.com/");

		WebElement men_Opt = driver.findElement(By.xpath("//div[@class='desktop-navLink']//a[text()='Men']"));
		WebElement women_Opt = driver.findElement(By.xpath("//div[@class='desktop-navLink']//a[text()='Women']"));
		WebElement kids_Opt = driver.findElement(By.xpath("//div[@class='desktop-navLink']//a[text()='Kids']"));
		WebElement home_Opt = driver.findElement(By.xpath("//div[@class='desktop-navLink']//a[text()='Home & Living']"));
		WebElement beauty_Opt = driver.findElement(By.xpath("//div[@class='desktop-navLink']//a[text()='Beauty']"));
		WebElement studio_Opt = driver.findElement(By.xpath("//div[@class='desktop-navLink']//a[text()='Studio']"));

		//This move forward -->
		actions.moveToElement(men_Opt).pause(2000).moveToElement(women_Opt).pause(2000).moveToElement(kids_Opt).pause(2000).moveToElement(home_Opt).pause(2000).moveToElement(beauty_Opt).pause(2000).moveToElement(studio_Opt).build().perform();

		// This move backward  <--
		actions.moveToElement(studio_Opt).pause(2000).moveToElement(beauty_Opt).pause(2000).moveToElement(home_Opt).pause(2000).moveToElement(kids_Opt).pause(2000).moveToElement(women_Opt).pause(2000).moveToElement(men_Opt).build().perform();

		/* 
		 Using one Reference variable move forward direction -->
         find width of single elements
		men_Opt   women_Opt   kids_Opt   home_Opt   beauty_Opt   studio_Opt
		  62         84           64         131         84           83    -->Original Width
		  31         42           32         66          42           42 

		 */    

		actions.moveToElement(men_Opt, 0, 0).pause(2000).moveToElement(men_Opt, 73, 0).pause(2000).moveToElement(men_Opt, 147, 0).pause(2000).moveToElement(men_Opt, 245, 0).pause(2000).moveToElement(men_Opt, 352, 0).pause(2000).moveToElement(men_Opt, 436, 0).build().perform();

		// Using one Reference variable move backward direction <--

		actions.moveToElement(studio_Opt, 0, 0).pause(2000).moveToElement(studio_Opt, -84, 0).pause(2000).moveToElement(studio_Opt, -192, 0).pause(2000).moveToElement(studio_Opt, -289, 0).pause(2000).moveToElement(studio_Opt, -363, 0).pause(2000).moveToElement(studio_Opt, -436, 0).build().perform();

	}

}


