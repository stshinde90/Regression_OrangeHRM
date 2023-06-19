package abstract_Components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable_Methods {
	
	
	public WebDriver driver;
	
	public Reusable_Methods(WebDriver driver) {
			
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		
		@FindBy(xpath="//nav[@role='navigation']//li[1]//span")
		WebElement btn_admin;
		
		
		@FindBy(xpath="//nav[@role='navigation']//li[2]//span")
		WebElement btn_PIM;
		
		@FindBy(xpath="//nav[@role='navigation']//li[3]//span")
		List<WebElement> btn_Leave;
		
		@FindBy(xpath="//nav[@role='navigation']//li[4]//span")
		List<WebElement> btn_Time;
		
		public void click_Admin()
		{
			waitForElementToVisible(btn_admin);
			btn_admin.click();
		}
		
		public void click_PIM()
		{
			btn_PIM.click();
		}
		
		public void click_Leave()
		{
			btn_Leave.get(0).click();
		}
		
		public void click_Time()
		{
			btn_Time.get(0).click();
		}
		
		public void waitForElementToAppear(By findBy) {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		}

		public void waitForElementToVisible(WebElement element) {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
		}

		public void waitForElementToDisappear(WebElement ele) throws InterruptedException {

			Thread.sleep(3000);
			// WebDriverWait wait = new WebDriverWait(driver, 10);
			// wait.until(ExpectedConditions.invisibilityOf(ele));
		}
		

}
