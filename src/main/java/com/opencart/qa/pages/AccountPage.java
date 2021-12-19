package com.opencart.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage 
{
	private WebDriver driver;
	
	public AccountPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By accountTitle = By.cssSelector("div#logo a");
	private By sectionsHeader = By.cssSelector("div#content h2");
	private By searchBox = By.name("search");
	private By searchBtn = By.xpath("//span[@class='input-group-btn']/button");
	
	public String accountPageTitle()
	{
		return driver.findElement(accountTitle).getText();
	}
	
	
	public List<String> accountSectionHeader()
	{
		List<WebElement> secHeaderText= driver.findElements(sectionsHeader);
		List<String> headerText = new ArrayList<String>();
		for(WebElement e : secHeaderText)
		{
			String secText = e.getText();
			headerText.add(secText);
		}
		return headerText;
	}
	
	public boolean isSearchBoxDisplayed()
	{
		return driver.findElement(searchBox).isDisplayed();
		
	}
	
	public void productSearch(String productName)
	{
		if(isSearchBoxDisplayed())
		{
			driver.findElement(searchBox).sendKeys(productName);
			driver.findElement(searchBtn).click();	
		}
	}
	

}
