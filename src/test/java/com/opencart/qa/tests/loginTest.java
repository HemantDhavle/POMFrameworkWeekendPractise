package com.opencart.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import com.opencart.qa.utility.Constants;

public class loginTest extends baseTest
{
	@Test
	public void loginPageTitleTest()
	{
		String lTitle = loginpage.loginPageTitle();
		Assert.assertEquals(lTitle, Constants.LOGIN_PAGE_TITLE);
	}

	@Test
	public void loginPageURLTest()
	{
		String lURL = loginpage.loginPageURL();
		Assert.assertTrue(lURL.contains(Constants.LOGIN_PAGE_URL_FRACTION));
		
	}
	
	@Test
	public void doLoginTest()
	{
		String un = prop.getProperty("un");
		String pw = prop.getProperty("pw");
		
		loginpage.doLogin(un, 		pw);
	}
}
