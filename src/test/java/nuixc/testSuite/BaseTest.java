package nuixc.testSuite;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	Properties prop;
	
	@BeforeTest
	public void setup() {
		 WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	}
	
	
	@AfterTest
	public void close() {
		 
	        driver.close();
	}
}
