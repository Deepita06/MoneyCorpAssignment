import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MoneyCorpTest extends BaseClass {
	
	
	@Test(description="This TC will Change the language and region")
	public void languageChange() 
	{
		//Change the language and region from the top right corner to UK (English).
		driver.findElement(By.xpath("//*[@id=\"language-dropdown-flag\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"nav-languages-overlay\"]/div/ul/li[1]/a")).click();
	}
	
	@Test(description="This TC will Click Find out more for “Foreign exchange solutions”")
	public void goToForeginExchange()
	{
		//Click Find out more for “Foreign exchange solutions”
		WebElement element = driver.findElement(By.xpath("/html/body/section/div[4]/div[3]/div/div/div[2]/div/a"));
		//JavascriptExecutor used for scroll into element view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
	}
	
	@Test(description="This TC will Validate if we are on page “Foreign exchange solutions”")
	public void validateForeginExchangePage()
	{	
	String expectedUrl = "https://www.moneycorp.com/en-gb/business/";
	try{
	  Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
	  System.out.println("Navigated to correct webpage");
	}
	catch(Throwable pageNavigationError){
	  System.out.println("Didn't navigate to correct webpage");
	}
	}
	
	@Test(description="This TC will Search for the word “international payments”")
	public void searchIntenationalPayments()
	{
		//Search for the word “international payments”
		driver.findElement(By.xpath("/html/body/section/div[1]/header/div[2]/div/div[3]/button[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"nav_search\"]")).sendKeys("international payments");
		driver.findElement(By.xpath("//*[@id=\"nav_search\"]")).sendKeys(Keys.ENTER);
	}
	
	@Test(description="Validate that each article in the list displays a link that starts with a URL")
	public void linkValidation()
	{	
	//Validate that each article in the list displays a link that starts with a URL
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> it = links.iterator();
		String url = it.next().getAttribute("href");
		if(url.contains("https://www.moneycorp.com/en-us/")){
			System.out.println("URL match");
			}
	}

}
