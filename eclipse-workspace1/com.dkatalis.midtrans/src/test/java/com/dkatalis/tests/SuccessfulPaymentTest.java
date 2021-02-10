package com.dkatalis.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dkatalis.base.TestBase;
import com.dkatalis.pages.BuyNowPage;
import com.dkatalis.pages.ShoppingCartPage;

public class SuccessfulPaymentTest extends TestBase{
	
	private BuyNowPage buyNow;
	private ShoppingCartPage checkOutPage;
	
	
	@BeforeClass(alwaysRun=true)
	public void initializeObjects()
	{
		buyNow=new BuyNowPage();
		checkOutPage=new ShoppingCartPage();
	}
	
	@BeforeMethod
	public void beforTest()
	{
		setUp();
	}
	
	
	@Test
	public void checkSuccessfulPaymentTest()
	{
		
		buyNow.clickOnBuyNowButton();
		checkOutPage.enterPillowAmount("100");
	}
	

}
