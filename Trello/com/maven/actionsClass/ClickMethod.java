package com.maven.actionsClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickMethod 
{

	static WebDriver driver;
	public static void main(String[] args) throws IOException 
	{
	      FileInputStream fis = new FileInputStream("./src/test/resource/data.properties");
	     
	      Properties prt_obj = new Properties();
	      
	      prt_obj.load(fis);
	      
	     String chrome_browser = prt_obj.getProperty("browser");
	     
	     if(chrome_browser.equals("chrome"))
	     {
	    	 driver = new ChromeDriver();
	     }
	     
	     driver.get(prt_obj.getProperty("url"));
	     
	     // actions  class objects
	     // it is an concrete class
	     
	     Actions actions  = new Actions(driver);
	     
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	     
	     
	     WebElement forgotten_link = driver.findElement(By.xpath("//a[text()='Forgotten password?']"));
	     
	     actions.click(forgotten_link).perform();
	      
	      
	      

	}

}
