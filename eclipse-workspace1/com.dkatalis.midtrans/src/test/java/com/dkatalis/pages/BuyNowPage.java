package com.dkatalis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.dkatalis.base.CommonMethods;
import com.dkatalis.base.TestBase;

/**
 * Class for Locators and Methods.
 * 
 * @author Mayur.Kumbhar
 *
 */
public class BuyNowPage extends TestBase {
	
	private CommonMethods commonMethod;
	
	
	public BuyNowPage() {
		commonMethod=new CommonMethods(driver);
		PageFactory.initElements(driver, this);
	}
	
	private By BuyNowButton=By.xpath("//a[@class='btn buy']");
	
	/**
	 * Click on Buy now button 
	 */
	public void clickOnBuyNowButton()
	{
		commonMethod.waitForPageToLoad(BuyNowButton);
		commonMethod.clickOnElement(BuyNowButton);
	}
	

}
