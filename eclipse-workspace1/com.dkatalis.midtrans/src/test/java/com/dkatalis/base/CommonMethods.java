package com.dkatalis.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * Class for Common Methods used in selenium
 * 
 * @author Mayur
 */
public class CommonMethods {
	
	private WebDriver driver;
	private WebDriver.Navigation navigate;
	private static final String IS_PRESENT=null;
	private static final String IS_NOTPRESENT=null;
	
	
	//constructor
	public CommonMethods(WebDriver driver)
	{
		this.driver=driver;
		navigate=driver.navigate();
	}
	
	public void clickOnElement(By locator)
	{
		driver.findElement(locator).click();
		
	}
	
	public void enterText(By locators, String textToSend)
	{
		driver.findElement(locators).sendKeys(textToSend);
	}
	
	public void navigateBack()
	{
		navigate.back();
	}
	public void navigateForward()
	{
		navigate.forward();
	}
	public void goToLink(String url)
	{
		navigate.to(url);
	}
	public void refreshPage()
	{
		navigate.refresh();
	}
	
	public void alert_alertAccept()
	{
		driver.switchTo().alert().accept();
	}
	
	public void alert_alertDismiss()
	{

		driver.switchTo().alert().dismiss();
	}
	public void alert_sendKeys(String textToSend)
	{

		driver.switchTo().alert().sendKeys(textToSend);
	}
	
		
	public void mouseHover(By locator)
	{
		
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(locator)).perform();
		
	}
	
	public void deleteAllCookies()
	{
		driver.manage().deleteAllCookies();
	}
	
	public void doubleClick(By locators)
	{
		Actions action=new Actions(driver);
		
		action.moveToElement(driver.findElement(locators)).doubleClick().perform();
		
	}
	public void rightClick(By locator)
	{
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(locator)).contextClick().perform();
	}
	
	public void verifyVisible(By locator, String ObjectDescription)
	{
		Assert.assertTrue(driver.findElement(locator).isDisplayed(), ObjectDescription);
	}
	
	public void waitForPageToLoad(By pageLocator)
	{
		waitForElementToGetDisplayed(pageLocator);
		
	}
	
	public void moveToElementAndClick(final WebElement  element)
	{
		final Actions action=new Actions(driver);
		action.moveToElement(element).click(element);
		action.perform();
	}
	
	public void deleteAllVisibleCookies() 
	{
		driver.manage().deleteAllCookies();
	}
	
	public void windowMaximise()
	{
		driver.manage().window().maximize();
	}
	
	/*
	 * this method will delete all the cookies and maximise the window.
	 */
	public void beforeMethod()
	{
		deleteAllCookies();
		windowMaximise();
		
	}
	
	/**
	 * Adding object in the method signature and returning the object
	 * in method body which is equivalent to void method
	 * 
	 */
	public Actions clickOnEsc(By locator) 
	{
		return new Actions(driver).sendKeys(Keys.ESCAPE);
		
	}
	public void verifyVisibled(String xpathLocator,String ObjectMessage)
	{
		Assert.assertTrue(isElementPresented(By.xpath(xpathLocator)), ObjectMessage);
		if(isElementPresented(By.xpath(xpathLocator)))
		{
			Reporter.log("Pass ::" + ObjectMessage + IS_PRESENT);
		}
		else
		{
			Reporter.log("Fail ::" + ObjectMessage + IS_NOTPRESENT);
		}
	}

	public boolean isElementPresented(By xpath) {
		driver.findElement(xpath);
		return true;
	}
	
	public void verifyPresent(By xpathLocator)
	{
		Assert.assertTrue(isElementPresented(xpathLocator));
		
	}
	
	public void waitForElementToGetDisplayed(By locator)
	{
		if(!isElementPresented(locator) || (isElementPresented(locator)) && (driver.findElement(locator).isDisplayed()));
		{
			waitForElementToLoad(locator, 30);
		}
	}

	public void waitForElementToLoad(By locator, int timeUnit)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	
	public void selectDropDown(By locator, String dropdownValue)
	{
		Select select=new Select(driver.findElement(locator));
		select.selectByVisibleText(dropdownValue);
	}
	
	public String getText(By locator)
	{
		return driver.findElement(locator).getText();
	}
	
	public void keysDown(By locator)
	{
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(locator)).keyDown(Keys.ARROW_DOWN);
	}
	
	public void keysUp()
	{
		Actions action=new Actions(driver);
		action.sendKeys(Keys.UP);
		
	}
	
}
