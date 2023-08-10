package com.Automation;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bookmyshow {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://in.bookmyshow.com/explore/home/");
		
		driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div[2]/ul/li[3]/div/div/img")).click();
		driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/header/div[1]/div/div/div/div[2]/div[2]/div[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div")).click();
		driver.findElement(By.xpath("//input[@id='emailId']")).sendKeys("selauto@yopmail.com");
		driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div/div[2]/form/div[2]/button")).click();
		String id = driver.getWindowHandle();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://yopmail.com/");
		driver.findElement(By.xpath("//*[@id=\"login\"]")).sendKeys("selauto@yopmail.com");
		driver.findElement(By.xpath("//*[@id=\"refreshbut\"]/button/i")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.name("ifmail")));
		String otp = driver.findElement(By.xpath("//*[@id=\"mail\"]/div/table/tbody/tr[1]/td/div/table/tbody/tr[4]/td/table/tbody/tr[2]/td/table/tbody/tr/td")).getText();
		
		driver.switchTo().window(id);
		
		for(int i = 0; i < 6; i++)
		{
			String s = String.valueOf(otp.charAt(i));
			driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/form/div[1]/div[3]/input["+(i+1)+"]")).sendKeys(s);
		}
		driver.findElement(By.xpath("//*[@id=\"modal-root\"]/div/div/div/div/div[2]/form/div[2]/button")).click();
	}

}
