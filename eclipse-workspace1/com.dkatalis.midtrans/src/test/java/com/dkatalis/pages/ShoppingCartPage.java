package com.dkatalis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.dkatalis.base.CommonMethods;
import com.dkatalis.base.TestBase;

public class ShoppingCartPage extends TestBase {
	
	private CommonMethods commonMethod;
	
	
	public ShoppingCartPage()
	{
		commonMethod=new CommonMethods(driver);
		PageFactory.initElements(driver, this);
	}
	private By pillowAmount=By.xpath("//input[@type='number']");
	private By customerName=By.xpath("//input[@data-reactid='.0.0.1.0.3.0.0.0.1.0']");
	private By customerEmailID=By.xpath("//input[@type='email']");
	private By customerPhoneNumber=By.xpath("//input[@data-reactid='.0.0.1.0.3.0.0.2.1.0']");
	private By customerCity=By.xpath("//input[@data-reactid='.0.0.1.0.3.0.0.3.1.0']");
	private By customerAddress=By.xpath("//td[@data-reactid='.0.0.1.0.3.0.0.4.1']");
	private By customerPostalCode=By.xpath("//input[@data-reactid='.0.0.1.0.3.0.0.5.1.0']");
	private By checkoutButton=By.xpath("//div[@class='cart-checkout']");
	private By cancelButton=By.xpath("//div[text()='cancel']");
	
	/**
	 * Enter Pillow Amount
	 * @param amount
	 */
	public void enterPillowAmount(final String amount)
	{
		commonMethod.waitForPageToLoad(pillowAmount);
		commonMethod.enterText(pillowAmount, amount);
	}
	
	/**
	 * Enter Customer Name
	 * @param Name
	 */
	public void enterCustomerName(final String Name)
	{
		commonMethod.waitForPageToLoad(customerName);
		commonMethod.enterText(customerName, Name);
		
	}
	
	/**
	 * Enter Customer mail ID
	 * @param email
	 */
	public void enterCustomerMailID(final String email)
	{
		commonMethod.waitForPageToLoad(customerEmailID);
		commonMethod.enterText(customerEmailID, email);
		
	}
	
	/**
	 * Enter Customer Phone Number
	 * @param phoneNumber
	 */
	public void enterCustomerPhoneNumber(final String phoneNumber)
	{
		commonMethod.waitForPageToLoad(customerPhoneNumber);
		commonMethod.enterText(customerEmailID, phoneNumber);
	}
	
	/**
	 * Enter Customer City
	 * @param city
	 */
	public void enterCustomerCity(final String city)
	{
		commonMethod.waitForPageToLoad(customerCity);
		commonMethod.enterText(customerCity, city);
		
	}
	
	/**
	 * Enter Customer Address
	 * @param address
	 */
	public void enterCustomerAddress(final String address)
	{
		commonMethod.waitForPageToLoad(customerAddress);
		commonMethod.enterText(customerAddress, address);
	}
	
	/**
	 * Enter Customer Postal Code
	 * @param PostalCode
	 */
	public void enterPostalCode(final String PostalCode)
	{
		commonMethod.waitForPageToLoad(customerPostalCode);
		commonMethod.enterText(customerPostalCode, PostalCode);
	}
	
	/**
	 * Click on check out button
	 */
	public void clickCheckOutbutton()
	{
		commonMethod.waitForElementToGetDisplayed(checkoutButton);
		commonMethod.clickOnElement(checkoutButton);
	}
	
	/**
	 * click on cancel button
	 */
	public void clickOnCancelButton()
	{
		commonMethod.waitForPageToLoad(cancelButton);
		commonMethod.clickOnElement(cancelButton);
	}
	

}
