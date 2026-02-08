package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.CartPageInterfaceElements;

public class CartPage extends Base_Class implements CartPageInterfaceElements {

    @FindBy(linkText = cart_link)
    private WebElement cart;

    @FindBy(xpath = place_order_xpath)
    private WebElement placeOrder;

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    public void openCartAndPlaceOrder() throws InterruptedException {
        clickOnElement(cart);
        WaitToSee();
        takeScreenshot("02_Cart_Page");
        clickOnElement(placeOrder);
    }
}