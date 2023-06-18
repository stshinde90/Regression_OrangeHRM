package cucumber_StepDefination;

import java.net.MalformedURLException;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects_OrangeHRM.AdminPage;
import pageObjects_OrangeHRM.LandingPage;
import pageObjects_OrangeHRM.PIMPage;
import test_Components.BaseTest;

public class Cucumber_EndToEnd extends BaseTest {

	public AdminPage ap;
	public LandingPage lp;

	@Given("User is on landing Page")
	public void User_is_on_landing_Page() throws MalformedURLException {
		lp = launchApplication();
	}

	@Given("^User is logged in with (.+) and (.+)$")
	public void User_is_logged_in_with_username_and_password(String un, String pw) {
		String loginTitle = lp.login_To_Application(un, pw);
		System.out.println("The login title is " + loginTitle);
	}

	@When("User click on Admin Page")
	public void user_click_on_Admin_Page() {
		ap = new AdminPage(driver);
		ap.click_Admin();
	}

	@And("Search for Particular Admin")
	public void search_for_particular_admin() {
		ap.searchAdminUser();
	}
	@Then("User click on PIM page")
	public void user_click_on_PIM_page()
	{
		ap.click_PIM();
	}
	@And("Search for PIM User")
	public void search_for_PIM_user()
	{
		PIMPage pm = new PIMPage(driver);
		pm.searchPIMUser();
		
	}

}
