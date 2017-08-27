package com.TestScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjectModel.LoginPage;
import com.kirwa.nxgreport.NXGReports;
import com.kirwa.nxgreport.logging.LogAs;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen;
import com.kirwa.nxgreport.selenium.reports.CaptureScreen.ScreenshotOf;
import com.library.BaseClass;
import com.library.Generic;

public class Home extends BaseClass
{
	@Test
	void TC1() throws InterruptedException
	
	{
		LoginPage Login = new LoginPage(driver);
		//Assert.assertEquals(LoginPage.Ab, arg1);
		Assert.assertTrue(Login.Abof_Login_EmailBox.isDisplayed(), "Box is not displayed");
		NXGReports.addStep("First step", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		Login.Abof_Login_EmailBox.sendKeys(Generic.readFromExcel("Data", 1,0));
		
		Generic.handleKeyboard();
		Thread.sleep(3000);
		Login.Abof_Login_PasswordBox.sendKeys(Generic.readFromExcel("Data", 1, 1));
		Generic.handleKeyboard();
		Thread.sleep(3000);
		Login.Abof_Login_SigninButton.click();
		Thread.sleep(3000);
		System.out.println("TC HOME OAGE");
		
	}

}
