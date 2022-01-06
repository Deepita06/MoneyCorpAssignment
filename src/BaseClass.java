import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	WebDriver driver;
 	
	@BeforeClass
	public void setupApplication()
	{
		
		Reporter.log("****Browser Session Started****", true);
		
		Map<String, Object> prefs = new HashMap<String, Object>();
		// Set the notification setting it will override the default setting
		prefs.put("profile.default_content_setting_values.notifications", 2);

        // Create object of ChromeOption class
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		//Webdriver setup
		System.setProperty("webdriver.chrome.driver","C:\\Eclipse_Workspace\\Driver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver(options);
		driver.get("https://www.moneycorp.com/en-gb/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Reporter.log("****Application Started****", true);
	}
	
	@AfterClass
	public void closeApplication()
	{
		driver.quit();
		Reporter.log("****Browser Session End****", true);
		
	}

}
