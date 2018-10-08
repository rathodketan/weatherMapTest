package map.WhetherMapTests;

import org.testng.annotations.Test;
import org.testng.Assert;

/**
 * The Class ImpInfoTest.
 */
public class ImpInfoTest extends Setup {

	/** The whether lable */
	final String whetherLables = "Current weather and forecasts in your city";
	
	/** The current location. */
	final String currentLocation = "Current location";

	/**
	 * Imp info displayed.
	 */
	@Test(priority = 1)
	public void impInfoDisplayed() {
		Assert.assertTrue(page.verifyOpenWeatherLogo(), "Open weather map logo is not displayed");
		Assert.assertTrue(page.verifySignInSignUpLinks(), "Sign In & Sign Up links are not displayed");
		Assert.assertTrue(page.verifyWeatherDetailsTable(), "Weather details in table is not displayed");
		Assert.assertTrue(page.verifyCityNameTextBox(), "Enter City Name Text box is not displayed");
		Assert.assertTrue(page.verifySearchCityButton(), "Search city button is not displayed");
		Assert.assertEquals(page.verifyCurrentLocationLink(), currentLocation,"Current location link is not displayed");
		Assert.assertEquals(page.verifyWeatherAndForecastInfo(), whetherLables,"Current weather and forecast header is not displayed");
		Assert.assertTrue(page.verifyTermsAndConditionSaleFooter(), "Terms & Conditions of sale link is not displayed");
		Assert.assertTrue(page.verifyPrivacyPolicyFooter(), "Privacy Policy link is not displayed");
		Assert.assertTrue(page.verifyWebTermsAndConditionFooter(), "Website Terms & Condition link is not displayed");
	}
}