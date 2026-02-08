package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.PurchasePageInterfaceElements;

public class PurchasePage extends Base_Class implements PurchasePageInterfaceElements {

	    @FindBy(id = name_id)
	    private WebElement name;

	    @FindBy(id = country_id)
	    private WebElement country;

	    @FindBy(id = city_id)
	    private WebElement city;

	    @FindBy(id = card_id)
	    private WebElement card;

	    @FindBy(id = month_id)
	    private WebElement month;

	    @FindBy(id = year_id)
	    private WebElement year;

	    @FindBy(xpath = purchase_xpath)
	    private WebElement purchase;

	    @FindBy(xpath = confirmation_xpath)
	    private WebElement confirmation;

	    public PurchasePage() {
	        PageFactory.initElements(driver, this);
	    }

	    public void completePurchase() {
	        passInput(name, "Purush");
	        WaitToSee();
	        passInput(country, "India");
	        WaitToSee();
	        passInput(city, "Chennai");
	        WaitToSee();
	        passInput(card, "123456789");
	        WaitToSee();
	        passInput(month, "02");
	        WaitToSee();
	        passInput(year, "2026");
	        WaitToSee();
	        clickOnElement(purchase);   
	        String details = getText(confirmation);
	        System.out.println(details);
	        WaitToSee();
	        takeScreenshot("03_Order_Confirmation");
	    }
}
