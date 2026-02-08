package com.interfaceelements;

public interface LoginInterFaceElements {
	
	String login_xpath  = "//a[text()='Log in']"; // For the login Button with text
	String username_id = "loginusername";       // For the login Button with id
	String password_css = "input#loginpassword"; // For the login Password with css # comes for css
	String signin_xpath ="//button[text()='Log in']";// For submitting the login details
	String title_id = "nameofuser"; // For getting the user Name
	String title_xpath ="//a[@id='nameofuser']";
	
	
	
	

}
