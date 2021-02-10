package com.dkatalis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dkatalis.base.CommonMethods;
import com.dkatalis.base.TestBase;

/**
 *  Class file for Order Summary Page
 * @author Mayur Kumbhar
 *
 */
public class OrderSummaryPage extends TestBase {
	
	private CommonMethods commonMethod;
	
	public OrderSummaryPage()
	{
		commonMethod=new CommonMethods(driver);
		PageFactory.initElements(driver, this);
	}

	private By continueButton=By.xpath("//div[@class='button-main show']");
	private By cardDetails=By.xpath("//div[text()='Credit/Debit Card']");
	private By cardNumber=By.xpath("//input[@name='cardnumber']");
	private By expiryDate=By.xpath("//div[@class='input-group col-xs-7']//label[text()='Expiry date']");
	private By cardCVV=By.xpath("//div[@class='input-group col-xs-5']");
	private By payNowButton=By.xpath("//div[@class='text-button-main']");
	private By bankOTP=By.xpath("//input[@id='PaRes']");
	private By clickOK=By.xpath("//button[@type='submit']");
	
	
	
	/**
	 * click on Continue button
	 */
	public void clickOnContineButton()
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
		
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));

	}
	
	/**
	 * click on Credit/Debit Card.
	 */
	public void clickOnCardDetails()
	{
		commonMethod.waitForElementToGetDisplayed(cardDetails);
		commonMethod.clickOnElement(cardDetails);
	}
	
	/**
	 * Enter Card Number
	 * @param cardDetails
	 */
	public void enterCardNumber(final String cardDetails)
	{
		commonMethod.waitForElementToGetDisplayed(cardNumber);
		commonMethod.enterText(cardNumber, cardDetails);
	}
	
	/**
	 * enter card expiry Date
	 * @param date
	 */
	public void enterCardExpiryDate(final String date)
	{
		commonMethod.waitForElementToGetDisplayed(expiryDate);
		commonMethod.enterText(expiryDate, date);
	}
	/**
	 * enter the CVV number
	 * @param cvvNumber
	 */
	public void enterCardCVV(final String cvvNumber)
	{
		commonMethod.waitForElementToGetDisplayed(cardCVV);
		commonMethod.enterText(cardCVV, cvvNumber);
	}
	
	/**
	 * click on pay now button
	 */
	public void clickOnPayNowButton()
	{
		commonMethod.waitForElementToGetDisplayed(payNowButton);
		commonMethod.clickOnElement(payNowButton);
	}
	
	/**
	 * enter bank OTP
	 * @param OTPNumber
	 */
	public void enterBankOTP(final String OTPNumber)
	{
		commonMethod.waitForElementToGetDisplayed(bankOTP);
		commonMethod.enterText(bankOTP, OTPNumber);
	}
	
	/**
	 * click on OK button on upon entering bank OTP
	 */
	public void clickOnOKButtonOnBank()
	{
		commonMethod.waitForElementToGetDisplayed(clickOK);
		commonMethod.clickOnElement(clickOK);
	}
	
}
