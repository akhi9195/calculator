package nuixc.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import nuixc.abstractComponents.AbstractComponent;

public class NumbersPanel extends AbstractComponent{

	By number_7 = By.cssSelector("[value='7']");
	public NumbersPanel(WebDriver driver, By sectionElement) {
		super(driver,sectionElement);
	}

   public String getNumber() {
	  return findElement(number_7).getAttribute("");
   }
   
   public void clickNumber7() {
	   
	 findElement(number_7).click();
 }
   
   public void clickNumber(int number) {
	   
		 findElement(By.cssSelector("[value='"+number+"']")).click();
	 }
   public void clickDot() {
	   
		 findElement(By.cssSelector("[value='.']")).click();
	 }
}
