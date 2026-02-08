package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.ProductPageInterfaceElements;

public class ProductPage extends Base_Class implements ProductPageInterfaceElements {

    @FindBy(xpath = sony_vaio_i5_xpath)
    private WebElement sonyVaio;

    @FindBy(xpath = add_to_cart_xpath)
    private WebElement addToCart;

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectProductAndAddToCart() {
        clickOnElement(sonyVaio);
        clickOnElement(addToCart);
        acceptSimpleAlert();
    }
}
