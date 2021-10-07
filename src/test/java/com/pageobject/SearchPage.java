package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		js = (JavascriptExecutor) driver;
	}

	public By searchKeyword = By.className("search-keyword");
	public By location = By.xpath("//input[contains(@id,'search-location')]");
	public By submit = By.className("search-form__submit");

	public void searchForJob(String data) throws InterruptedException {
    	WebElement element = driver.findElement(searchKeyword);
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    	wait.until(ExpectedConditions.elementToBeClickable(searchKeyword));
		driver.findElement(searchKeyword).sendKeys(data);
        driver.findElement(location).clear();
        driver.findElement(submit).click();   
	}

}
