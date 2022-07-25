package com.kyro;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


public class assessment {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://kyro.pages.dev/");
		
		//Login into to the application
		
		driver.findElement(By.className("LoginButton_login_button__ehTMa")).click();
		driver.findElement(By.id("username")).sendKeys("viswanathanm12@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Vishwa!1234!");
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		//driver.findElement(By.name("action")).click();
		Thread.sleep(2000);
		
		//Navigate to DashBoard and select one of the existing project
		
		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[normalize-space()='Kyro Version 1.0']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[texttransform ='none']")).click();
		
		// create a new Task
		
		driver.findElement(By.name("summary")).sendKeys("Create a new task");
		driver.findElement(By.name("task_type")).sendKeys("Automation");
		driver.findElement(By.name("description")).sendKeys("Validate the new task");
		driver.findElement(By.id(":r10:")).click();
		List<WebElement> lst= driver.findElements(By.xpath("//*[@id=\"menu-priority\"]/div[3]/ul/li"));
		lst.get(0).click();
		Thread.sleep(1000);
		driver.findElement(By.name("location")).sendKeys("Chennai");
		driver.findElement(By.name("start_date")).sendKeys("07072022");
		driver.findElement(By.name("due_date")).sendKeys("07062023");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		
	   //Validate the new task created in the list view by screenshot 
		
	    File f1=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    File f2 =new File("./screenshot/Projectpagedetails.jpg");
	    FileHandler.copy(f1, f2);
		driver.quit();
	}

}
