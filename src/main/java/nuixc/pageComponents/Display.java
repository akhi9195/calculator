package nuixc.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import nuixc.abstractComponents.AbstractComponent;

public class Display extends AbstractComponent{

	By display_text = By.xpath("div");
	public Display(WebDriver driver, By sectionElement) {
		super(driver,sectionElement);
	}

	 public String getDisplayText() {
		  return findElement(display_text).getText();
	   }
	   
}
