package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	WebDriverWait wait;
    JavascriptExecutor js;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
    	js = (JavascriptExecutor) driver;
	}
	
	public By careerLink = By.xpath("//a[text()='Careers']");
	
	public void clickCareerLink() throws InterruptedException {
		Thread.sleep(2000);
    	js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    	WebElement element = driver.findElement(careerLink);
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    	wait.until(ExpectedConditions.elementToBeClickable(careerLink));
    	element.click();
	}

}
