package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.SearchPageInterfaceElements;

public class SearchPage extends Base_Class implements SearchPageInterfaceElements {

	@FindBy(linkText = laptop_linkText)
	private WebElement laptop;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	public void searchProduct() {
		clickOnElement(laptop);
	}
	}

