package com.base;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base_Class {

	// Global WebDriver Declaration
	public static WebDriver driver;

	// Launching the Browsers
	protected static void launchBrowser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			} else if (browserName.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURED DURING BROWSER LAUNCH");

		}

		// Maximizing the Window
		driver.manage().window().maximize();
	}

	// Launching the URL
	protected static void launchURL(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURED DURING URL LAUNCH");
		}
	}

	// Passing the Input Values
	protected static void passInput(WebElement element, String value) {
		try {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOf(element));
		        element.clear();
		        element.sendKeys(value);
		    } catch (Exception e) {
		        e.printStackTrace(); // IMPORTANT: see real error
		        Assert.fail("ERROR: OCCURED DURING VALUE PASS");
			//element.sendKeys(value);
		//} catch (Exception e) {
		//	Assert.fail("ERROR: OCCURED DURING VALUE PASS");
		}
	}

	// Click
	protected static void clickOnElement(WebElement element) {
		 try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.elementToBeClickable(element));
		        element.click();
		    } catch (Exception e) {
		        e.printStackTrace();  
			Assert.fail("ERROR: OCCURED DURING ELEMENT CLICK");
		}
	}

	// Closing the Browser
	protected static void browserClose() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURED DURING BROWSER CLOSURE");
		}
	}

	// Terminating the Browser
	protected static void browserTermination() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURED DURING BROWSER TERMINATION");
		}
	}

	// Drop-down Selection
	protected static void selectOptions(WebElement element, String type, String value) {
		try {
			Select select = new Select(element);

			if (type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(value);

			} else if (type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));

			} else if (type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING DROP DOWN SELECTION");
		}
	}

	// Drop-down De-Selection
	protected static void deselectOptions(WebElement element, String type, String value) {
		try {
			Select select = new Select(element);

			if (type.equalsIgnoreCase("text")) {
				select.deselectByVisibleText(value);

			} else if (type.equalsIgnoreCase("index")) {
				select.deselectByIndex(Integer.parseInt(value));

			} else if (type.equalsIgnoreCase("value")) {
				select.deselectByValue(value);
			}

		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING DROP DOWN DESELECTION");
		}
	}

	// Navigation
	protected static void navigateBack() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING NAVIGATE BACK");
		}
	}

	protected static void navigateForward() {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING NAVIGATE BACK");
		}
	}

	protected static void refreshPage() {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING NAVIGATE BACK");
		}
	}

	// Alerts
	protected static String acceptSimpleAlert() {
		 try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		        wait.until(ExpectedConditions.alertIsPresent());

		        String alertText = driver.switchTo().alert().getText();
		        System.out.println("Alert message: " + alertText);
		        driver.switchTo().alert().accept();
		        return alertText;

		    } catch (org.openqa.selenium.TimeoutException e) {
		        System.out.println("No alert appeared.");
		        return null;

		    } catch (Exception e) {
		        e.printStackTrace();
		        Assert.fail("ERROR: OCCURRED DURING ALERT HANDLING");
		        return null;
		    }
		}
		
	


	protected static void acceptConfirmAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING CONFIRM ALERT ACCEPT");
		}
	}

	protected static void dismissConfirmAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING CONFIRM ALERT DISMISS");
		}
	}

	protected static void handlePromptAlert(String value) {
		try {
			driver.switchTo().alert().sendKeys(value);
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING PROMPT ALERT HANDLING");
		}
	}

	protected static void closeModernAlert(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED DURING MODERN ALERT HANDLING");
		}
	}

	// Frames
	protected static void switchToFrameById(String frameId) {
		try {
			driver.switchTo().frame(frameId);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED WHILE SWITCHING FRAME BY ID");
		}
	}

	protected static void switchToFrameByName(String frameName) {
		try {
			driver.switchTo().frame(frameName);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED WHILE SWITCHING FRAME BY NAME");
		}
	}

	protected static void switchToFrameByIndex(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED WHILE SWITCHING FRAME BY INDEX");
		}
	}

	protected static void switchToFrameByElement(WebElement frameElement) {
		try {
			driver.switchTo().frame(frameElement);
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED WHILE SWITCHING FRAME BY WEBELEMENT");
		}
	}

	protected static void switchToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			Assert.fail("ERROR: OCCURRED WHILE SWITCHING TO DEFAULT CONTENT");
		}
	}
		
	//get Method
		protected static String getText (WebElement element) {
		    try {
		    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		         wait.until(ExpectedConditions.visibilityOf(element));

		        String text = element.getText();
		        System.out.println(text);
		        return text;
		    } catch (Exception e) {
		    	e.printStackTrace();
		        Assert.fail("ERROR : OCCURE DURING TEXT GETTING");
		        return null;
		    }
		}
		
		protected static void WaitToSee() {
		    try {
		        Thread.sleep(2000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}
		
		protected static void takeScreenshot(String fileName) {
		    try {
		        TakesScreenshot ts = (TakesScreenshot) driver;
		        File src = ts.getScreenshotAs(OutputType.FILE);
		        File dest = new File("screenshots/" + fileName + ".png");
		        FileUtils.copyFile(src, dest);
		    } catch (Exception e) {
		        e.printStackTrace();
		        Assert.fail("ERROR OCCURRED DURING SCREENSHOT");
		    }
		}
}