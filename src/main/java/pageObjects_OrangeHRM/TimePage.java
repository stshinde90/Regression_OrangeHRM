package pageObjects_OrangeHRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_Components.Reusable_Methods;

public class TimePage extends Reusable_Methods {

	public WebDriver driver;
	
public TimePage(WebDriver driver) {
		
	    super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	WebElement txtbx_searchUser;
	
	@FindBy(xpath="//button[@type='submit123']")
	WebElement btn_submit;
	
	public void searchEmployee()
	{
		waitForElementToVisible(txtbx_searchUser);
		txtbx_searchUser.sendKeys("12345");
		btn_submit.click();
	}
}
