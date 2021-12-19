package com.opencart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By userName = By.xpath("//input[@name='email']");
	private By passWord = By.xpath("//input[@name='password']");
	private By loginBtn = By.xpath("//input[@value='Login']");
	
	public String loginPageTitle()
	{
		return driver.getTitle();
	}

	public String loginPageURL()
	{
		return driver.getCurrentUrl();
	}
	
	public AccountPage doLogin(String un, String pw)
	{
		driver.findElement(userName).sendKeys(un);
		System.out.println("User Name entered is "+un);
		driver.findElement(passWord).sendKeys(pw);
		System.out.println("Password entered is "+pw);
		driver.findElement(loginBtn).click();
		System.out.println("Login button clicked successfully");
		return new AccountPage(driver);
	}

}
