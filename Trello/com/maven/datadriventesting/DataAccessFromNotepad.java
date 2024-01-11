package com.maven.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v117.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;

public class DataAccessFromNotepad
{

	static  WebDriver driver;
	public static void main(String[] args) throws IOException 
	{

		FileInputStream 
		fis = new FileInputStream("./src/test/resource/FbData.properties");

		Properties prt = new Properties();
		prt.load(fis);

		String chrome_browser = prt.getProperty("browser");

		if(chrome_browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(chrome_browser.equals("Edge")) 
		{	
			driver = new EdgeDriver();
		}

		System.out.println(chrome_browser);


		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(prt.getProperty("url"));

		WebElement email_textField = driver.findElement(By.xpath("//input[@placeholder='Email address or phone number']"));
		email_textField.sendKeys(prt.getProperty("email"));

		WebElement password_TextField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		password_TextField.sendKeys(prt.getProperty("password"));





	}

}
