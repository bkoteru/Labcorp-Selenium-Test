package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReturnToJobPO {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public ReturnToJobPO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		js = (JavascriptExecutor) driver;
	}

    public By returnToJobSearch = By.xpath("//span[text()='Return to Job Search']");

	public void verifyDetails(String jobTitle, String jobLocation, String jobId) throws InterruptedException {
		WebElement element = driver.findElement(By.xpath("//span[text()='"+jobTitle+"']"));
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='"+jobTitle+"']")));
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Burlington')]")));
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+jobId+"')]")));
	}
	
	public void verifyThirdParagraph() throws Exception {
		String text = driver.findElement(By.xpath("(//div[@class='content'])[2]//p[4]")).getText();
	    if(!text.contains("The right candidate for this role will participate in the test automation technology development and best practice models.")) {
	 	   throw new Exception("Failed to verify third paragraph...!!!");
	    }
	}
	
	public void clickReturnToJob() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(returnToJobSearch));
		Thread.sleep(2000);
     	driver.findElement(returnToJobSearch).click();   
	}

}
