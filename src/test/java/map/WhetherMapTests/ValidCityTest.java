package map.WhetherMapTests;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import map.PageObjects.WhetherMapPage;

/**
 * The Class ValidCityTest.
 */
public class ValidCityTest extends Setup {
	
	/** The page. */
	private WhetherMapPage page;
	
	/** The result text. */
	private final String resultText = "Mumbai, IN";

	/**
	 * Initialize.
	 */
	@BeforeClass
	public void initialize() {
		page = PageFactory.initElements(driver, WhetherMapPage.class);
	}

	/**
	 * Verify city text.
	 *
	 * @param city the city
	 */
	@Parameters({ "city" })
	@Test(priority = 1)
	public void verifyCityText(String city) {
		page.enterCityName(city);
		page.clickSearchButton();
		Assert.assertEquals(page.verifyCityFoundText(), resultText, "City not found is not displayed");
	}

	/**
	 * Verify city details.
	 */
	@Test(priority = 2)
	public void verifyCityDetails() {
		Assert.assertTrue(page.verifyWeatherDetails(), "Weather details are not displayed");
	}
}