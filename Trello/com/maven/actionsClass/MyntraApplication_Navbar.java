package com.maven.actionsClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MyntraApplication_Navbar 
{

	static WebDriver driver;

	public static void main(String[] args) throws IOException 
	{
		
		FileInputStream fis = new FileInputStream("./src/test/resource/myntra_data.properties");
		
		Properties prt_obj = new Properties();
		
		prt_obj.load(fis);
		
		String chrome_browser = prt_obj.getProperty("browser");
		
		if(chrome_browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(prt_obj.getProperty("url"));
		
		// Create object for actions class 
		
		Actions actions = new Actions(driver);
		
//		WebElement men_navbar = driver.findElement(By.xpath("//div[@class='desktop-navLink']"));
		WebElement women_navbar = driver.findElement(By.xpath("//a[text()='Women']"));
		
		actions.clickAndHold(women_navbar).perform();
		
//		 WebElement women_list = driver.findElement(By.xpath("//div[@class='desktop-categoryContainer']/li/ul/li/a"));
//		 
//		Select wlist = new Select(women_list);
//		List<WebElement> options = wlist.getOptions();
////		String list = 
//		System.out.println(options);
		
		

	}

}
