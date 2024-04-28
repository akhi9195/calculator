package nuixc.testSuite;

import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import nuixc.pageObjects.CalculatorPage;
import nuixc.util.Commons;

public class AdditionTests2 extends BaseTest{
	
	@Test
	public void testTwoNumbers() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickAddition();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickEquals();
		
		int exepctedResult = 14;
		int actualResult = Integer.parseInt(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	@Test
	public void testMultipleNumbers() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		for(int i=0;i<10;++i) {
			calculator.getNumbersPanel().clickNumber(i);
			calculator.getOperations().clickAddition();
		}
	
		calculator.getOperations().clickEquals();
		
		int exepctedResult = 45;
		int actualResult = Integer.parseInt(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	@Test
	public void test9digitNumbers() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		
		for(int j=0;j<10;++j) {
			for(int i=0;i<10;++i) {
				calculator.getNumbersPanel().clickNumber(i);			
			}
		calculator.getOperations().clickAddition();
		}
			
		calculator.getOperations().clickEquals();
		double exepctedResult = 1.23456789e+9;
		double actualResult = Double.parseDouble(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	
}
