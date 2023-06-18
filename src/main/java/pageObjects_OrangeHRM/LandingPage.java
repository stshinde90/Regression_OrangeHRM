package pageObjects_OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstract_Components.Reusable_Methods;

public class LandingPage extends Reusable_Methods {

	public WebDriver driver;
	
public LandingPage(WebDriver driver) {
		
	    super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name="username")
	WebElement txtbx_username;
	
	@FindBy(name="password")
	WebElement txtbx_password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement btn_submit;
	
	public void goTo()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public String login_To_Application(String username, String password)
	{
		txtbx_username.sendKeys(username);
		txtbx_password.sendKeys(password);
		btn_submit.click();	
		String LoginTitile = driver.getTitle();
		return LoginTitile;
	}
}
