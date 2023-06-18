package pageObjects_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_Components.Reusable_Methods;

public class AdminPage extends Reusable_Methods {

	public WebDriver driver;
	
public AdminPage(WebDriver driver) {
		
	    super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='']//input[@class='oxd-input oxd-input--active']")
	WebElement txtbx_searchUser;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btn_submit;
	
	public void searchAdminUser()
	{
		txtbx_searchUser.sendKeys("12345");
		btn_submit.click();
	}

	
}
