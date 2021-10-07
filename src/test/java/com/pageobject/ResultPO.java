package com.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPO {

	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	public ResultPO(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		js = (JavascriptExecutor) driver;
	}

	public By intro = By.xpath("(//div[@class='ats-description']//span)[1]");
    public By requirement = By.xpath("//h3[text()='Requirements']");
    public By shift = By.xpath("//h3[text()='Shift']");
    public By suggestedTool = By.xpath("//h3[contains(text(),'Requirements')]/..//ul[2]/li[1]");
    public By applyNow = By.xpath("//a[text()='Apply Now']");

	public void selelctResult(String data) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='"+data+"']")));
    	WebElement element = driver.findElement(By.xpath("//*[text()='"+data+"']"));
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//*[text()='"+data+"']")).click();  
	}
	
	public void verifyDetails(String jobTitle, String jobLocation, String jobId) {
		WebElement element = driver.findElement(By.xpath("//h1[text()='"+jobTitle+"']"));
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[text()='"+jobTitle+"']")));
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'"+jobLocation+"')])[1]")));
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+jobId+"')]")));
	}
	
	public void confirmIntroduction(String desc) throws Exception {
		String text = driver.findElement(intro).getText();
	    if(!text.contains(desc)) {
	 	   throw new Exception("Failed to verify Introduction paragraph..!!!");
	    }
	}
	
	public void verifyRequirement() throws Exception {
		 boolean flag = driver.findElement(requirement).isDisplayed();
         if(!flag) {
      	   throw new Exception("Failed to verify requirements in the page...!!!");
         }
	}
	
	public void verifyHeaderShift() throws Exception {
		boolean flag = driver.findElement(shift).isDisplayed();
        if(!flag) {
     	   throw new Exception("Failed to verify shift header in the page...!!!");
        }
	}
	
	public void confirmAutomationTool() throws Exception {
		String text = driver.findElement(suggestedTool).getText();
        if(!text.contains("Selenium")) {
     	   throw new Exception("Failed to verify Automation tool");
        }
	}
	
	public void clickApplyButton() throws InterruptedException {
		WebElement element = driver.findElement(applyNow);
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    	wait.until(ExpectedConditions.elementToBeClickable(applyNow));
    	element.click();
    	Thread.sleep(5000);
	}

}
