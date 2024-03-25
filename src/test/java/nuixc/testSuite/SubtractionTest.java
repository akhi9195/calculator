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
import nuixc.CalculatorPage;
import nuixc.util.Commons;

public class SubtractionTest extends BaseTest{
	
	@Test
	public void testTwoNumbers() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickSubtraction();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickEquals();
		
		int exepctedResult = 0;
		int actualResult = Integer.parseInt(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	@Test
	public void testMultipleNumbers() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		for(int i=0;i<10;++i) {
			calculator.getNumbersPanel().clickNumber(i);
			calculator.getOperations().clickSubtraction();
		}
	
		calculator.getOperations().clickEquals();
		
		int exepctedResult = -45;
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
		calculator.getOperations().clickSubtraction();
		}
			
		calculator.getOperations().clickEquals();
		int exepctedResult = -876543201;
		int actualResult = Integer.parseInt(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	@Test
	public void verify10digitNumberNotAcceptable() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		
		calculator.getOperations().clickSubtraction();
			for(int i=0;i<10;++i) {
				calculator.getNumbersPanel().clickNumber(i);			
			}
		    calculator.getNumbersPanel().clickNumber(1);	
			
		int exepctedResult = -12345678;
		int actualResult = Integer.parseInt(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Caluclator accepted more than 9 digit number which shouldn't be! ").isEqualTo(exepctedResult);	
	}
	
	@Test
	public void testMaximumDisplayNumbers() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		
		for(int j=0;j<100;++j) {
			calculator.getOperations().clickSubtraction();
			for(int i=0;i<10;++i) {
				calculator.getNumbersPanel().clickNumber(i);			
			}
		}
			
		calculator.getOperations().clickEquals();
		double exepctedResult = 1.23456789E8;
		double actualResult = Double.parseDouble(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	
	@Test //with 32 bit & 64 bit processor
	public void testMaxIntNegativeValue() {
		
			//not testable as displaye accepts only 9 digits 
	}
	@Test //with 32 bit & 64 bit processor
	public void testMaxLongNegativeValue() {
		
		//not testable as displaye accepts only 9 digits
	}
	
	@Test
	public void testNumbersWithFractions() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		calculator.getOperations().clickSubtraction();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getNumbersPanel().clickDot();
		calculator.getNumbersPanel().clickNumber(1);
		calculator.getOperations().clickSubtraction();
		calculator.getNumbersPanel().clickNumber(2);
		calculator.getNumbersPanel().clickDot();
		calculator.getNumbersPanel().clickNumber(9);
		calculator.getOperations().clickEquals();
		
		int exepctedResult = -10;
		int actualResult = Integer.parseInt(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}

	@Test
	public void testNegativeNumbersWithPositiveNumber() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		calculator.getOperations().clickSubtraction();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getNumbersPanel().clickDot();
		calculator.getNumbersPanel().clickNumber(1);
		calculator.getOperations().clickAddition();
		calculator.getNumbersPanel().clickNumber(2);
		calculator.getNumbersPanel().clickDot();
		calculator.getNumbersPanel().clickNumber(9);
		calculator.getOperations().clickEquals();
		
		double exepctedResult = -4.2;
		double actualResult = Double.parseDouble(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	@Test
	public void testNegativeNumbers() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		calculator.getOperations().clickSubtraction();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getNumbersPanel().clickDot();
		calculator.getNumbersPanel().clickNumber(1);
		calculator.getOperations().clickSubtraction();
		calculator.getNumbersPanel().clickNumber(2);
		calculator.getNumbersPanel().clickDot();
		calculator.getNumbersPanel().clickNumber(9);
		calculator.getOperations().clickEquals();
		
		int exepctedResult = -10;
		int actualResult = Integer.parseInt(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	@Test
	public void testTwoSmallNumbers() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		calculator.getOperations().clickSubtraction();
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getNumbersPanel().clickDot();
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getNumbersPanel().clickNumber(1);
		calculator.getOperations().clickSubtraction();
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getNumbersPanel().clickDot();
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getNumbersPanel().clickNumber(1);
		calculator.getOperations().clickEquals();
		
		double exepctedResult = -2e-8;
		double actualResult = Double.parseDouble(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	@Test
	public void testSubtractionOfPositiveNumberWithZero() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickSubtraction();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickSubtraction();
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getOperations().clickEquals();
		
		int exepctedResult = 0;
		int actualResult = Integer.parseInt(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	@Test
	public void testSubtractionOfNegativeNumberWithZero() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		calculator.getOperations().clickSubtraction();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickSubtraction();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickSubtraction();
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getOperations().clickEquals();
		
		int exepctedResult = -14;
		int actualResult = Integer.parseInt(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
}
