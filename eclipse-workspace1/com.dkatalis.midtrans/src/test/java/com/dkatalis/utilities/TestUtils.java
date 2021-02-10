package com.dkatalis.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.dkatalis.base.TestBase;


public class TestUtils extends TestBase {
	
	public static String screenshotPath;
	public static String screenshotName;
	
	public static void captureScreenshot() throws IOException
	{
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Date date=new Date();
		screenshotName=date.toString().replace(":", "_").replace(" ", "_")+".png";
		FileUtils.copyFile(source,new File("Screenshot/"+screenshotName));

	}
	
	

}
