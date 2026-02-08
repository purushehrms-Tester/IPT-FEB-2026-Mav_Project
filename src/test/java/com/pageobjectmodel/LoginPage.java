package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.LoginInterFaceElements;
import com.pageobjectmanager.PageObjectManager;

public class LoginPage extends Base_Class implements LoginInterFaceElements {

	@FindBy(xpath = login_xpath)
	private WebElement login;

	@FindBy(id = username_id)
	private WebElement username;

	@FindBy(css = password_css)
	private WebElement password;

	@FindBy(xpath = signin_xpath)
	private WebElement signin;

	@FindBy(xpath = title_xpath)
	private WebElement title;
	
	public LoginPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	public void validLogin() throws IOException, InterruptedException {
		clickOnElement(login);
		//passInput(username,login_xpath);
		passInput(username,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("username"));
		passInput(password,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
		clickOnElement(signin);
		 String welcomeUserName = getText(title);
		 System.out.println("Login successful: " + welcomeUserName);
         takeScreenshot("01_Login_Success");
	    //PageFactory.initElements(driver, this);
	}

	

}
