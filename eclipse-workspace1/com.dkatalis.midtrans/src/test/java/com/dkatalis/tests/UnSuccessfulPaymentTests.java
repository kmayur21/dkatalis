package com.dkatalis.tests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.dkatalis.base.TestBase;
import com.dkatalis.pages.BuyNowPage;
import com.dkatalis.pages.OrderSummaryPage;
import com.dkatalis.pages.ShoppingCartPage;

/**
 * Test class to check the fail payment.
 * @author Mayur Kumbhar
 *
 */
public class UnSuccessfulPaymentTests extends TestBase{

	
	private BuyNowPage buyNow;
	private ShoppingCartPage checkOutPage;
	private OrderSummaryPage orderSummary;
	
	/**
	 * before class to create objects.
	 */
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
	
	/**
	 * Test case to check the fail card payment
	 */
	@Test
	public void checkFailPaymentTest()
	{
		final String expectedMessage="Transaction failed";
		buyNow.clickOnBuyNowButton();
		
		checkOutPage.clickCheckOutbutton();
		orderSummary.clickOnContineButton();
		orderSummary.clickOnCardDetails();
		orderSummary.enterCardNumber(config.getProperty("TEST.CONFIG.INVALID.CARD.NUMBER"));
		orderSummary.enterCardExpiryDate(config.getProperty("TEST.CONFIG.INVALID.EXPIRY.DATE"));
		orderSummary.enterCardCVV(config.getProperty("TEST.CONFIG.VALID.CARD.CVV"));
		orderSummary.clickOnPayNowButton();
		/**
		 * Since card expiry date is not correct getting validation while procceding the test.
		 */
	
	}
	
}
