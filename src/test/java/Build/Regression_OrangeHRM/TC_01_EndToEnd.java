package Build.Regression_OrangeHRM;

import org.testng.annotations.Test;

import pageObjects_OrangeHRM.AdminPage;
import pageObjects_OrangeHRM.LandingPage;
import pageObjects_OrangeHRM.PIMPage;
import test_Components.BaseTest;

public class TC_01_EndToEnd extends BaseTest {
	
	@SuppressWarnings("deprecation")
	@Test
	public void sanityOperation()
	{
		// LandingPage lp = new LandingPage(driver);
		String loginTitle = lp.login_To_Application("Admin", "admin123");
		//Assert.assertEquals(loginTitle, "Login Title Fail");
		AdminPage ap = new AdminPage(getDriver());
		ap.click_Admin();
		ap.searchAdminUser();
		ap.click_PIM();
		PIMPage pm = new PIMPage(getDriver());
		pm.searchPIMUser();
	}

}
