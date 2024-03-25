package nuixc.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import nuixc.abstractComponents.AbstractComponent;

public class Operations extends AbstractComponent{
	
	By addition = By.id("add");
	By subtraction = By.id("subtract");
	By multiply = By.id("multiply");
	By divide = By.id("divide");
	By equals = By.cssSelector("[value='=']");
	By clear = By.cssSelector("[value='C']");

	public Operations(WebDriver driver, By sectionElement) {
		super(driver,sectionElement);
	}

	
	  public void clickAddition() {
		   
			 findElement(addition).click();
	}
	  public void clickSubtraction() {
		   
			 findElement(subtraction).click();
	}
	  public void clickMultiply() {
		   
			 findElement(multiply).click();
	}
	  public void clickDivide() {
		   
			 findElement(divide).click();
	}
	  public void clickEquals() {
		   
			 findElement(equals).click();
	}
	  public void clickClear() {
		   
			 findElement(clear).click();
	}
	  
}
