package com.PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage
{
	public AndroidDriver driver;
	public LoginPage(AndroidDriver idriver)
	{
		this.driver = idriver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="com.abof.android:id/login_email_edt")
	public WebElement Abof_Login_EmailBox;
	
	@FindBy(id="com.abof.android:id/login_password_edt_edt")
	public WebElement Abof_Login_PasswordBox;
	
	@FindBy(id="com.abof.android:id/abof_login_btn")
	public WebElement Abof_Login_SigninButton;
	
	
	

}
