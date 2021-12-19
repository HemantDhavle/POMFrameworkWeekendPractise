package com.opencart.qa.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.opencart.qa.factory.DriverFactory;
import com.opencart.qa.pages.LoginPage;

public class baseTest 
{
	DriverFactory df;
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;
	@BeforeTest
	public void setUp()
	{
		df = new DriverFactory();
		prop = df.init_prop();
		driver = df.init_driver(prop);
		loginpage = new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown()
	{
		
	}

}
