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

public class CombinationTests extends BaseTest{
	
	@Test
	public void testWithPositiveNumbers() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		calculator.getNumbersPanel().clickNumber(9);
		calculator.getOperations().clickAddition();
		calculator.getNumbersPanel().clickNumber(1);
		calculator.getOperations().clickSubtraction();;
		calculator.getNumbersPanel().clickNumber(1);
		calculator.getOperations().clickMultiply();
		calculator.getNumbersPanel().clickNumber(9);
		calculator.getOperations().clickDivide();
		calculator.getNumbersPanel().clickNumber(1);
		calculator.getOperations().clickEquals();
		
		int exepctedResult = 81;
		int actualResult = Integer.parseInt(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	@Test
	public void testWithDecimalNumbers() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		calculator.getNumbersPanel().clickNumber(9);
		calculator.getNumbersPanel().clickDot();
		calculator.getNumbersPanel().clickNumber(9);
		calculator.getOperations().clickAddition();
		calculator.getNumbersPanel().clickNumber(1);
		calculator.getNumbersPanel().clickDot();
		calculator.getNumbersPanel().clickNumber(8);
		calculator.getOperations().clickSubtraction();;
		calculator.getNumbersPanel().clickNumber(1);
		calculator.getOperations().clickMultiply();
		calculator.getNumbersPanel().clickNumber(9);
		calculator.getNumbersPanel().clickDot();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickDivide();
		calculator.getNumbersPanel().clickNumber(1);
		calculator.getOperations().clickEquals();
		
		double exepctedResult = 103.79;
		double actualResult = Double.parseDouble(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	@Test
	public void testWithLargeNumbers() {
		
			
	}
	
	@Test
	public void testWithMultipleNumbers() {
		
			
	}
	
	
}
