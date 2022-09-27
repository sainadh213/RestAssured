package com.RMGYantra_CRUDwithBDD;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice4 {

	public static void main(String[] args) {
		System.setProperty("webDriver.chrome.driver","D:\\Automation\\Hybrid Framework\\Hybrid_Complete_Framework\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("www.CodeBunk.com/b/");
		WebElement text = driver.findElement(By.id("dn-inp"));
		text.sendKeys("nagalakshmi");
		
		driver.findElement(By.id("save-dn")).click();


	}

}
