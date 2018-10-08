package map.WhetherMapTests;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import map.PageObjects.WhetherMapPage;

/**
 * The Class InvalidCityTest.
 */
public class InvalidCityTest extends Setup {
	
	/** The page. */
	private WhetherMapPage page;
	
	/** The not found text. */
	private final String notFoundText = "Not found";

	/**
	 * Initialize.
	 */
	@BeforeClass
	public void initialize() {
		page = PageFactory.initElements(driver, WhetherMapPage.class);
	}

	/**
	 * End to end.
	 *
	 * @param city the city
	 */
	@Parameters({ "city" })
	@Test(priority = 1)
	public void endToEnd(String city) {
		page.enterCityName(city);
		page.clickSearchButton();
		Assert.assertEquals(page.verifyNoResultText(), notFoundText, "City not found is not displayed");
	}
}