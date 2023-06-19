package Build.Regression_OrangeHRM;

import org.testng.annotations.Test;

import pageObjects_OrangeHRM.AdminPage;
import pageObjects_OrangeHRM.LandingPage;
import pageObjects_OrangeHRM.LeavePage;
import pageObjects_OrangeHRM.PIMPage;
import pageObjects_OrangeHRM.TimePage;
import test_Components.BaseTest;

public class TC_02_Leave_Time extends BaseTest {
	
	public LeavePage leavepage;
	public TimePage timepage;
	
	@SuppressWarnings("deprecation")
	@Test
	public void sanityOperation()
	{
		String loginTitle = lp.login_To_Application("Admin", "admin123");
		leavepage = new LeavePage(driver);
		leavepage.click_Leave();
		leavepage.searchLeaveUser();
		leavepage.click_Time();
		timepage = new TimePage(driver);
		timepage.searchEmployee();
		
		
	}

}