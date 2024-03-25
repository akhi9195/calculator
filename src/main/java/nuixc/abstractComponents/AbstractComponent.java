package nuixc.abstractComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {
	
	WebElement sectionElement;
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver, By sectionElement) {
		this.driver = driver;
		this.sectionElement = driver.findElement(sectionElement);
	}
	
	public WebElement findElement(By by) {
		
		  try {
			  return sectionElement.findElement(by);
		} catch (NoSuchElementException e) {
			waitForElementToBeVisible(by);
			return sectionElement.findElement(by);
		}catch (TimeoutException e) {
			waitForElementToBeClickable(by);
			return sectionElement.findElement(by);
		}
	}
	
	public List<WebElement> findElements(By by) {
		
		 try {
			 return sectionElement.findElements(by);
		} catch (NoSuchElementException e) {
			waitForElementToBeVisible(by);
			return sectionElement.findElements(by);
		}catch (TimeoutException e) {
			waitForElementToBeClickable(by);
			return sectionElement.findElements(by);
		}
	}

	 public void waitForElementToBeVisible(By findBy)
	    {
	        WebDriverWait wait =new WebDriverWait(driver,5);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	     
	    } 
	 
	 public void waitForElementToBeClickable(By findBy)
	    {
	        WebDriverWait wait =new WebDriverWait(driver,5);
	        wait.until(ExpectedConditions.elementToBeClickable(findBy));
	     
	    } 
	
	public void waitForElementToBeDisappear(By findBy)
	    {
	        WebDriverWait wait =new WebDriverWait(driver,5);
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	    }

}
