package com.pageobjectmanager;

import com.pageobjectmodel.CartPage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.ProductPage;
import com.pageobjectmodel.PurchasePage;
import com.pageobjectmodel.SearchPage;
import com.utility.FileReaderManager;

public class PageObjectManager {

	private static PageObjectManager pageObjectManager;
	private FileReaderManager fileReader;
	private LoginPage loginPage;
	private SearchPage searchPage;
	private ProductPage productPage;
	private CartPage carttPage;
	private PurchasePage purchasePage;
	
	
	

	public FileReaderManager getFileReader() {
		if( fileReader == null ) {
			fileReader = new FileReaderManager();
		}
		return fileReader;
	}
	
	public static PageObjectManager getPageObjectManager() {
		if( pageObjectManager == null ) {
			pageObjectManager = new PageObjectManager();
		}
		return pageObjectManager;
	}
	
	public LoginPage getLoginPage() {
		if( loginPage == null ) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}

	public SearchPage getSearchPage() {
		if( searchPage == null ) {
			searchPage = new SearchPage();
		}
		return searchPage;
	}

	public ProductPage getProductPage() {
		if( productPage == null ) {
			productPage = new ProductPage();
		}
		return productPage;
	}

	public CartPage getCarttPage() {
		if( carttPage == null ) {
			carttPage = new CartPage();
		}
		return carttPage;
	}

	public PurchasePage getPurchasePage() {
		if( purchasePage == null ) {
			purchasePage = new PurchasePage();
		}
		return purchasePage;
	}
	
	
}