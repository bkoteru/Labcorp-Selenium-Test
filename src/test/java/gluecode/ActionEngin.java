package gluecode;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionEngin {
public static WebDriver driver;
    
    WebDriverWait wait;
    JavascriptExecutor js;
	
	public WebDriver intiateBrowser(){
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\driver\\chromedriver.exe");
    	driver=new ChromeDriver(); 
    	wait = new WebDriverWait(driver, 20);
    	js = (JavascriptExecutor) driver;
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.manage().window().maximize();
    	
    	return driver;
	}

}
