package com.dkatalis.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dkatalis.base.TestBase;
import com.dkatalis.pages.BuyNowPage;
import com.dkatalis.pages.OrderSummaryPage;
import com.dkatalis.pages.ShoppingCartPage;

public class SuccessfulPaymentTest extends TestBase{
	
	private BuyNowPage buyNow;
	private ShoppingCartPage checkOutPage;
	private OrderSummaryPage orderSummary;
	
	
	@BeforeClass(alwaysRun=true)
	public void initializeObjects()
	{
		buyNow=new BuyNowPage();
		checkOutPage=new ShoppingCartPage();
		orderSummary=new OrderSummaryPage();
	}
	
	@BeforeMethod
	public void beforTest()
	{
		setUp();
	}
	
	
	@Test
	public void checkSuccessfulPaymentTest()
	{
		final String expectedMessage="Transaction Successful";
		buyNow.clickOnBuyNowButton();
		
		checkOutPage.clickCheckOutbutton();
		orderSummary.clickOnContineButton();
		orderSummary.clickOnCardDetails();
		orderSummary.enterCardNumber(config.getProperty("TEST.CONFIG.VALID.CARD.NUMBER"));
		orderSummary.enterCardExpiryDate(config.getProperty("TEST.CONFIG.VALID.CARD.EXPIRY.DATE"));
		orderSummary.enterCardCVV(config.getProperty("TEST.CONFIG.VALID.CARD.CVV"));
		orderSummary.enterBankOTP(config.getProperty("TEST.CONFIG.BANK.OT"));
		orderSummary.clickOnOKButtonOnBank();
		Assert.assertEquals("Transaction Successful", expectedMessage);
	}
	

}
