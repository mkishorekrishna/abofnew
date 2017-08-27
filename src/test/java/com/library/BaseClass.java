package com.library;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.kirwa.nxgreport.NXGReports;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass 
{
public static DesiredCapabilities cap;
public static AndroidDriver driver ;
public static String node = "C:\\Program Files\\Appium\\node.exe";
public static String apppiumjs="C:\\Program Files\\Appium\\node_modules\\appium\\bin\\appium.js";
public static  AppiumDriverLocalService server;

	
	@BeforeSuite
	public void Appium_Server_Start()
	{
		server = AppiumDriverLocalService.buildService(new AppiumServiceBuilder().usingPort(4723).usingDriverExecutable(new File (node)).withAppiumJS(new File(apppiumjs)));
		server.start();
	}

	@AfterSuite
	public void Appium_Server_Stop()
	{
		server.stop();
	}



	@BeforeMethod
	public void setup() throws MalformedURLException
	{
	
		cap =new DesiredCapabilities();
		
		cap.setCapability("automationName", Generic.getproperties("AUTOMATIONNAME"));
		cap.setCapability("platformName", Generic.getproperties("PLATFORMNAME"));
		cap.setCapability("deviceName", Generic.getproperties("DEVICENAME"));
		cap.setCapability("platformVersion", Generic.getproperties("PLATFORMVERSION"));
		cap.setCapability("app",Generic.App_Path);
		/*cap.setCapability("appPackage", Generic.getproperties("APPPACKAGE"));
		cap.setCapability("appActivity", "APPACTIVITY");*/
		driver = new AndroidDriver(new URL(Generic.getproperties("URL")), cap);
		
		NXGReports.setWebDriver(driver);
		
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
		
	
	

}
