package com.testng.group;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterMethodsInTestNg {
	WebDriver driver;

	@Parameters({ "browser", "url", "email", "password" })

	@Test
	
	public void login_to_facebook(String browser, String url, String email, String password) {

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get(url);

		WebElement email_textField = driver.findElement(By.id("email"));
		email_textField.sendKeys(email);

		WebElement password_textField = driver.findElement(By.id("pass"));
		password_textField.sendKeys(password);
	}

}
