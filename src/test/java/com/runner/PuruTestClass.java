package com.runner;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;

public class PuruTestClass extends Base_Class {

	public static void main(String[] args) throws InterruptedException, IOException {
		launchBrowser (PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("browser"));
		launchURL (PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("url"));
		PageObjectManager.getPageObjectManager().getLoginPage().validLogin();
		PageObjectManager.getPageObjectManager().getSearchPage().searchProduct();
		PageObjectManager.getPageObjectManager().getProductPage().selectProductAndAddToCart();
	    PageObjectManager.getPageObjectManager().getCarttPage().openCartAndPlaceOrder();
	    PageObjectManager.getPageObjectManager().getPurchasePage().completePurchase();
        WaitToSee();
	    browserTermination();
	}
}
	
		/*launchBrowser("chrome");
		// launchURL("https://in.search.yahoo.com/");
		// WebElement element = driver.findElement(By.name("p"));
		// passInput(element, "purushottam express");
		launchURL("https://www.google.com/");
		Thread.sleep(3000); // Told by sir not to be used but still i am using for checking purpose
		launchURL("https://letcode.in/dropdowns");
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.id("fruits"));
		selectOptions(element, "index", "1");
		navigateBack();
		Thread.sleep(3000);
		navigateForward();
		Thread.sleep(3000);
		refreshPage();
		launchURL("https://letcode.in/alert");
		driver.findElement(By.id("accept")).click();
		Thread.sleep(3000);
		acceptSimpleAlert();
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(3000);
		acceptConfirmAlert();
		driver.findElement(By.id("confirm")).click();
		Thread.sleep(3000);
		dismissConfirmAlert();
		driver.findElement(By.id("prompt")).click();
		Thread.sleep(4000);
		handlePromptAlert("Purush");
		driver.findElement(By.id("modern")).click();
		Thread.sleep(4000);
		WebElement closeBtn = driver.findElement(By.xpath("//button[@aria-label='close']"));
		closeModernAlert(closeBtn);
		Thread.sleep(4000);
		launchURL("https://letcode.in/frame");
		Thread.sleep(2000);
		switchToFrameById("firstFr");
        Thread.sleep(1000);
        WebElement fname = driver.findElement(By.name("fname"));
        passInput(fname, "Purush");
        WebElement lname = driver.findElement(By.name("lname"));
        passInput(lname, "Nana");
        switchToDefaultContent();
        Thread.sleep(5000);
        browserTermination();
	}

	{

	}

}*/
		

