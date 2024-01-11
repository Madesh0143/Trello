package com.testng.projects;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Test
public class Trello 
{
	WebDriver driver;
    WebDriverWait ex_wait;
    FileInputStream fis;

	@Parameters({ "browserName" })
	@BeforeMethod
	public void pre_contition(String browserName) 
	{
		if (browserName.equals("chrome")) 
		{
			driver = new ChromeDriver();
		} 
		else if (browserName.equals("edge")) 
		{
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	
	
	@Parameters({"URL","send_email","send_password","board_title"})
	public void welcome_page(String URL,String send_email,String send_password,String board_title) throws EncryptedDocumentException, IOException, InterruptedException 
	{
		driver.get(URL);
		ex_wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        
        ex_wait.until(ExpectedConditions.titleIs("Manage Your Team’s Projects From Anywhere | Trello"));
        
        
        
        // WELCOME MODULE //
        
		String welcome_title = driver.getTitle(); // Get welcome page title
		String excepted_title = "Manage Your Team’s Projects From Anywhere | Trello";

		Assert.assertEquals(welcome_title, excepted_title); // verifying login page title 

		
		// LOGIN MODULE //
		
		WebElement login_btn = driver.findElement(By.linkText("Log in"));
		           login_btn.click();
		
		WebElement email_textField = driver.findElement(By.id("username"));
		           email_textField.sendKeys(send_email);

		WebElement Continue_btn = driver.findElement(By.id("login-submit"));
		           Continue_btn.click();

		WebElement password_textField = driver.findElement(By.id("password"));
		           password_textField.sendKeys(send_password);

		Continue_btn.click();
		
		
		// DASHBOARD MOUDULE //
		
//		ex_wait.until(ExpectedConditions.titleIs("TestNG_Task | Trello"));
		
		// VERIFY AND VALIDATE THE TITLE  HOME PAGE TITLE //
//		String ac_homePage_title = driver.getTitle();
//		String ex_homePage_title = "TestNG_Task | Trello";
//		Assert.assertEquals(ac_homePage_title, ex_homePage_title);
		
		
		// CREATE BROAD PART //
		WebElement create_btn = driver.findElement(By.xpath("//p[text()='Create']"));
		           create_btn.click();
		           
	    WebElement creat_board = driver.findElement(By.xpath("//p[contains(text(),'A board is made up of cards ordered')]"));
	               creat_board.click();
	               
	    WebElement board_title_Tfield = driver.findElement(By.xpath("//input[@data-testid='create-board-title-input']"));
	               board_title_Tfield.sendKeys(board_title);
//        	   WebElement workSpace = driver.findElement(By.xpath("//div[text()='Workspace']"));
//                       Select s = new Select(workSpace);
//                       s.selectByIndex(1);System.out.println(s);
	               
	    Actions actions = new Actions(driver);
	    
	    WebElement create_btn_template = driver.findElement(By.xpath("//button[@data-testid='create-board-submit-button']"));
	    
	     actions.click(create_btn_template).perform();
//	     Thread.sleep(2000);
	     
	     
	     // CARD PART //
	     
	     fis = new FileInputStream("./src/test/resource/trello.xlsx");
	     XSSFWorkbook wbook = new XSSFWorkbook(fis);
	     
	     XSSFSheet sheet = wbook.getSheetAt(0);
	     
	     int lastRowNum = sheet.getLastRowNum();
	     System.out.println("lastRowNum :"+lastRowNum);
	     short lastCellNum = sheet.getRow(0).getLastCellNum();
	     System.out.println("lastCellNum :"+lastCellNum);
	     
	     for(int i=1;i<=lastRowNum;i++)
	     {
	    	 XSSFRow row = sheet.getRow(i);
	    	 for(int j=0;j<lastCellNum;j++)
	    	 {
	    		XSSFCell cell = row.getCell(j); 
	    		String value = cell.getStringCellValue();
	    		
	    		 WebElement activeElement = driver.findElement(By.name("Enter list title…"));
		    	 activeElement.sendKeys(value);
		    	 
		    	 WebElement addToCart = driver.findElement(By.xpath("//button[text()='Add list']"));
		    	 addToCart.click();
	    		
	    	 }
	     }
	     
	     WebElement cancle_icon = driver.findElement(By.xpath("//span[@data-testid='CloseIcon']"));
	                cancle_icon.click();
	                
	    // TOPICS ENTER IN TO FIRST CART BOX PART //
	                
	      XSSFSheet sheet1 = wbook.getSheetAt(1);
	      
	      int lastRowNum_topic = sheet1.getLastRowNum();
		  System.out.println("lastRowNum :"+lastRowNum_topic);
		  short lastCellNum_topic = sheet1.getRow(0).getLastCellNum();
          System.out.println("lastCellNum :"+lastCellNum_topic);
	                
	     for(int i=1;i<=lastRowNum_topic;i++)
	     {
	    	 XSSFRow row = sheet1.getRow(i); 
	    	 
	    	 WebElement list_add_card = driver.findElement(By.xpath("//button[@data-testid='list-add-card-button']"));
	    	 list_add_card.click();
	    	 
	    	 for(int j=1;j< lastCellNum_topic;j++)
	    	 {
	    		 XSSFCell cell = row.getCell(j); 
		         String value = cell.getStringCellValue();
		         
		         WebElement first_cart = driver.findElement(By.xpath("//li[@data-testid='list-wrapper'][1]"));
		         if(first_cart!=null)
		         {
		        	 WebElement text_area = driver.findElement(By.xpath("//textarea[@placeholder='Enter a title for this card…']"));
		        	 
		        	 if(text_area.isEnabled())
		        	 {
		        		 text_area.sendKeys(value);
		        		 
		        		 WebElement add_to_cart = driver.findElement(By.xpath("//button[text()='Add card']"));
		        		 add_to_cart.click(); 
		        	 }
		         } 
	    	 }
	    	 
	     }
	                
	     wbook.close();
	     
	    
	     
	     
	     
	        
	     
	    
	     
	     
	              
		
	}
}

