package nuixc.pageObjects;

import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import nuixc.pageComponents.Display;
import nuixc.pageComponents.NumbersPanel;
import nuixc.pageComponents.Operations;
import nuixc.util.Commons;

public class CalculatorPage {
	


	WebDriver driver;
	String baseURL ="https://nuix.github.io/SDET/senior-sdet/productionCalc/index.html";
	Properties prop ;
	By sectionElement;
	By numberSection =By.className("row-block");
	By displaySection =By.id("display");
	By operationSection =By.id("panel");
	
	
	
	
	public Operations getOperations() {
		return new Operations(driver,operationSection);
	}
	public NumbersPanel getNumbersPanel() {
		return new NumbersPanel(driver,numberSection);
	}
	
	public Display getDisplay() {
		return new Display(driver,displaySection);
	}
	 
	 public CalculatorPage(WebDriver driver) {
		this.driver = driver;
	}

	public void open() {
		driver.navigate().to(getURL());
		driver.manage().window().maximize();
	}

	private String getURL() {
		try {
				prop = Commons.readPropertiesFile(System.getProperty("user.home")+"\\eclipse-workspace\\nuixc\\src\\test\\resources\\testData_prod.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     System.out.println("baseURL: "+ prop.getProperty("baseURL"));
		return prop.getProperty("baseURL");
		
	}
	
}
