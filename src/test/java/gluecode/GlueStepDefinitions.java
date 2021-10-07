package gluecode;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageobject.BasePage;
import com.pageobject.SearchPage;
import com.pageobject.ResultPO;
import com.pageobject.ReturnToJobPO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GlueStepDefinitions extends ActionEngin{
    public static WebDriver driver;
    
    WebDriverWait wait;
    JavascriptExecutor js;
    ResultPO resultPO;
    ReturnToJobPO returnPage;
    
    
    @Given("^user navigate to URL \"([^\"]*)\"$")
    public void user_navigate_to_URL(String url) throws Throwable {
    	driver = intiateBrowser();
        driver.get(url);
    }

    @When("^user click on careers link$")
    public void user_click_on_careers_link() throws Throwable {
    	Thread.sleep(2000);
    	BasePage basePage = new BasePage(driver);
    	basePage.clickCareerLink();
    	Set<String> allWindows = driver.getWindowHandles();
    	for(String window : allWindows) {
    		driver.switchTo().window(window);
    	}
    }

    @When("^user search for \"([^\"]*)\"$")
    public void user_search_for(String value) throws Throwable {
    	SearchPage searchPage = new SearchPage(driver);
    	searchPage.searchForJob(value);   
    }

    @When("^user selects \"([^\"]*)\"$")
    public void user_selects(String value) throws Throwable {
    	resultPO = new ResultPO(driver);
    	resultPO.selelctResult(value);      
    }

    @Then("^User verify \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_verify(String jobTitle, String jobLocation, String jobId) throws Throwable {
    	resultPO.verifyDetails(jobTitle, jobLocation, jobId);
    	
    }

    @Then("^user confirms introduction contains \"([^\"]*)\"$")
    public void user_confirms_introduction_contains(String description) throws Throwable {
       resultPO.confirmIntroduction(description);
    }

    @Then("^user confirms Requirements is there in page$")
    public void user_confirms_Requirements_is_there_in_page() throws Throwable {
    	resultPO.verifyRequirement();
    }

    @Then("^user confirms shift in page$")
    public void user_confirms_shift_in_page() throws Throwable {
    	resultPO.verifyHeaderShift();
    }

    @Then("^user click on Apply button$")
    public void user_click_on_Apply_button() throws Throwable {
    	resultPO.clickApplyButton();  
   }
    
    @Then("^I verify \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
    public void verifyDetails(String jobTitle, String jobLocation, String jobId) throws Throwable {
    	returnPage = new ReturnToJobPO(driver);
    	returnPage.verifyDetails(jobTitle, jobLocation, jobId);
    }

    @Then("^user clicks on return to job search button$")
    public void user_clicks_on_return_to_job_search_button() throws Throwable {
    	returnPage.clickReturnToJob();
    }
    
    @Then("^user click on page to close popup$")
    public void closePopup() throws Throwable {
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//div[@class='si-overlay']")).click();
    }
    
    @Then("^user close the browser$")
    public void user_close_the_browser() throws Throwable {
    	Thread.sleep(2000);
    	if(driver!=null){
    		driver.quit();
    	}
    }
    
}