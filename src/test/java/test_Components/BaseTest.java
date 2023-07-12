package test_Components;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects_OrangeHRM.LandingPage;

public class BaseTest {

	public static WebDriver driver;
	public LandingPage lp;
	public DesiredCapabilities cap;

	// ====== Thread Local for parallel Execution ================//
	public static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return dr.get();
	}

	public static void setDriver(WebDriver driverref) {
		dr.set(driverref);
	}

	public static void unload() {
		dr.remove();
	}
	
	// ====== Thread Local for parallel Execution ================//

	String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : "chrome";

	public WebDriver initializeDriver() throws MalformedURLException {
		// Launch Browser and open URL

		if (browserName.contains("chrome")) {
			System.out.println("The regression is executed on" + browserName);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			setDriver(driver);

		} else if (browserName.contains("remote")) {
			cap = DesiredCapabilities.chrome();
			URL url = new URL("http://localhost:4444/wd/hub");
			driver = new RemoteWebDriver(url, cap);
			setDriver(driver);
		} 
		else 
		{
			return null;
		}

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		return getDriver();

	}

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File dstFile = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + "//.png");
		FileUtils.copyFile(srcFile, dstFile);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + "//.png";
	}

	
	
	@BeforeSuite
	public void startDockerScale() throws IOException, InterruptedException {
		if (browserName.contains("remote")) {

			File fi = new File("output.txt");
			if (fi.delete()) {
				System.out.println("File Deleted Successfully");
			}

			StartDocker st = new StartDocker();
			st.startBatFile();
		}
	}

	@AfterSuite
	public void StopDockerDelete() throws IOException, InterruptedException {
		if (browserName.contains("remote")) {

			StopDocker sp = new StopDocker();
			sp.stopBatFile();
		}
	}

	@BeforeTest(alwaysRun = true)
	public WebDriver launchApplication() throws MalformedURLException {
		driver = initializeDriver();
		lp = new LandingPage(getDriver());
		lp.goTo();
		return getDriver();
	}

	@AfterTest(alwaysRun = true)
	public void teardown() {
		getDriver().close();
		unload();
	}

}
