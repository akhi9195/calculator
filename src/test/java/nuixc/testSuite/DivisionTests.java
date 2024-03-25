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

public class DivisionTests extends BaseTest{
	
	@Test
	public void testTwoNumbers() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickDivide();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickEquals();
		
		int exepctedResult = 1;
		int actualResult = Integer.parseInt(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	@Test
	public void testMultipleNumbers() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		for(int i=1;i<10;++i) {
			calculator.getNumbersPanel().clickNumber(i);
			calculator.getOperations().clickDivide();
		}
	
		calculator.getOperations().clickEquals();
		
		double exepctedResult = 45;
		double actualResult = Double.parseDouble(calculator.getDisplay().getDisplayText());
		
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
		calculator.getOperations().clickDivide();
		}
			
		calculator.getOperations().clickEquals();
		double exepctedResult = 1.85302032E-65;
		double actualResult = Double.parseDouble(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	@Test
	public void testMaximumDisplayNumbers() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		
		for(int j=0;j<100;++j) {
			for(int i=1;i<10;++i) {
				calculator.getNumbersPanel().clickNumber(i);			
			}
		calculator.getOperations().clickDivide();
		}
			
		calculator.getOperations().clickEquals();
		double exepctedResult = 0;
		double actualResult = Double.parseDouble(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	
	@Test //with 32 bit & 64 bit processor
	public void testMaxIntValue() {
		
			//not testable as displaye accepts only 9 digits 
	}
	@Test //with 32 bit & 64 bit processor
	public void testMaxLongValue() {
		
		//not testable as displaye accepts only 9 digits
	}
	
	@Test
	public void testNumbersWithFractions() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getNumbersPanel().clickDot();
		calculator.getNumbersPanel().clickNumber(1);
		calculator.getOperations().clickDivide();
		calculator.getNumbersPanel().clickNumber(2);
		calculator.getNumbersPanel().clickDot();
		calculator.getNumbersPanel().clickNumber(9);
		calculator.getOperations().clickEquals();
		
		double exepctedResult = 2.44827586;
		double actualResult = Double.parseDouble(calculator.getDisplay().getDisplayText());
		
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
		calculator.getOperations().clickDivide();
		calculator.getNumbersPanel().clickNumber(2);
		calculator.getNumbersPanel().clickDot();
		calculator.getNumbersPanel().clickNumber(9);
		calculator.getOperations().clickEquals();
		
		double exepctedResult = -2.44827586;
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
		calculator.getOperations().clickDivide();
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
		
		double exepctedResult = 1.0;
		double actualResult = Double.parseDouble(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	@Test
	public void testDivideOfNegativeNumberByZero() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		calculator.getOperations().clickSubtraction();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickDivide();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickDivide();
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getOperations().clickEquals();
		
		int exepctedResult = 0;
		int actualResult = Integer.parseInt(calculator.getDisplay().getDisplayText());//Error
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	@Test
	public void testDivideOfPositiveNumberByZero() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickDivide();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickDivide();
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getOperations().clickEquals();
		
		int exepctedResult = 14;
		int actualResult = Integer.parseInt(calculator.getDisplay().getDisplayText());//Error
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	@Test
	public void testDivisionZeroByNumber() {
		
		CalculatorPage calculator = new CalculatorPage(driver);
		calculator.open();
		calculator.getNumbersPanel().clickNumber(0);
		calculator.getOperations().clickDivide();
		calculator.getNumbersPanel().clickNumber(7);
	
		calculator.getOperations().clickEquals();
		
		int exepctedResult = 0;
		int actualResult = Integer.parseInt(calculator.getDisplay().getDisplayText());
		
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
}
