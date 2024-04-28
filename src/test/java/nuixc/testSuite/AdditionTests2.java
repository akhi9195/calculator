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
	public void testLatestOperator() {
		
		
		
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickMultiply();
		calculator.getOperations().clickSubtraction();
		calculator.getOperations().clickAddition();
		calculator.getNumbersPanel().clickNumber(7);
		calculator.getOperations().clickEquals();
		
		int exepctedResult = 14;
		int actualResult = Integer.parseInt(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);	
	}
	
	@Test ////made it wrong intentionally.
	public void testClear() {



		calculator.getNumbersPanel().clickNumber(1);
		calculator.getOperations().clickAddition();
		calculator.getOperations().clickClear();
		
		for(int i=2;i<10;++i) {
			calculator.getNumbersPanel().clickNumber(i);
			calculator.getOperations().clickAddition();
		}
	
		calculator.getOperations().clickEquals();
		
		int exepctedResult = 440;//made it wrong intentionally.
		int actualResult = Integer.parseInt(calculator.getDisplay().getDisplayText());
		
		Assertions.assertThat(actualResult).as("Expected and Actual results doesn't matched.").isEqualTo(exepctedResult);		
	}
}
