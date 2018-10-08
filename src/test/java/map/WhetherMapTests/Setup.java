package map.WhetherMapTests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import map.PageObjects.WhetherMapPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

public class Setup {

	public static WebDriver driver;
	private static String driverPath = "src/main/resources/drivers/";
	public WhetherMapPage page;
	
	/**
	 * Sets the driver.
	 *
	 * @param browserType the browser type
	 * @param appURL the app url
	 */
	private void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "ie":
			driver = initIEDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}

	/**
	 * Inits the chrome driver.
	 *
	 * @param appURL the app url
	 * @return the web driver
	 */
	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}

	/**
	 * Inits the ie driver.
	 *
	 * @param appURL the app url
	 * @return the web driver
	 */
	private static WebDriver initIEDriver(String appURL) {
		System.out.println("Launching IE with new profile..");
		System.setProperty("webdriver.ie.driver", driverPath + "IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}

	/**
	 * Inits the firefox driver.
	 *
	 * @param appURL the app url
	 * @return the web driver
	 */
	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(appURL);
		return driver;
	}

	/**
	 * Initialize test base setup.
	 *
	 * @param browserType the browser type
	 * @param appURL the app url
	 */
	@Parameters({ "browserType", "appURL" })
	@BeforeSuite
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);			
		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	/**
	 * Tear down closes the web Driver instance.
	 */
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
	/**
	 * Initialize.
	 */
	@BeforeClass 
	public void initializePageFactoryElements(){
		page = PageFactory.initElements(driver, WhetherMapPage.class);
	}
}