import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class FillFormTest {
	public String baseUrl = "http://dev.sencha.com/extjs/5.0.0/examples/kitchensink/#form-checkout";
	public WebDriver driver;
	
	@BeforeTest
	public void setBaseURL(){
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	

	@Test
	public void verifyCheckoutForm(){
		
		WebDriverWait wait = new WebDriverWait(driver, 60); 
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".x-title-text.x-title-text-default-framed.x-title-item"), "Complete Check Out"));
			
	    driver.findElement(By.name("firstName")).sendKeys("TestFirst");
	    
	    driver.findElement(By.name("lastName")).sendKeys("TestLast");
	    
	    driver.findElement(By.name("email")).sendKeys("test@test.com");
	    
	    driver.findElement(By.name("phone")).sendKeys("123-123-1234");
	    
	    driver.findElement(By.name("mailingStreet")).sendKeys("Street Test Address");
	    
	    driver.findElement(By.name("mailingCity")).sendKeys("NewYork");
	    
	    driver.findElement(By.name("mailingState")).click();
	    driver.findElement(By.xpath("//div[@class='x-form-trigger x-form-trigger-default x-form-arrow-trigger x-form-arrow-trigger-default  x-form-trigger-focus']")).click();
	     
	    driver.findElement(By.xpath("//div[@class='x-boundlist-list-ct x-unselectable']/ul/li[contains(.,'Arizona')]")).click();
	    
	    driver.findElement(By.name("mailingPostalCode")).sendKeys("4007091234");
	    
	    driver.findElement(By.name("ccName")).sendKeys("Test Name");
	    
	    driver.findElement(By.name("ccNumber")).sendKeys("123456789123456");
	    
	    driver.findElement(By.name("ccExpireMonth")).click();
	    
	    driver.findElement(By.xpath("//div[@class='x-form-trigger x-form-trigger-default x-form-arrow-trigger x-form-arrow-trigger-default  x-form-trigger-focus']")).click();
	    
	    driver.findElement(By.xpath("//div[@class='x-boundlist-list-ct x-unselectable']/ul/li[contains(.,'May')]")).click();
	    
	    driver.findElement(By.name("ccExpireYear")).sendKeys("2021");
	    
	    driver.findElement(By.linkText("Complete Purchase")).click();
	    
	    driver.findElement(By.linkText("Reset")).click();
	   
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}
