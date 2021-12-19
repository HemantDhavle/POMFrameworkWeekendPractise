package com.opencart.qa.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory 
{
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(Properties prop)
	{
		String browerName = prop.getProperty("browser");
		System.out.println(browerName+" browser opened successfully");
		if(browerName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browerName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browerName.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Incorrect browser selected "+browerName);
		}
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().window().fullscreen();
		return driver;		
	}
	
	public Properties init_prop()
	{
		prop = new Properties();
		try {
			FileInputStream fs = new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(fs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}
	

}
