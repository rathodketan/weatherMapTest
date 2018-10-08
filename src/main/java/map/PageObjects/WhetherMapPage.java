package map.PageObjects;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import map.WhetherMapTests.Setup;

// TODO: Auto-generated Javadoc
/**
 * The Class WhetherMapPage.
 */
public class WhetherMapPage extends Setup {

	/** The city name text box. */
	@FindBy(how = How.XPATH, using = "//input[@id='q'][contains(@placeholder,'city')]")
	public WebElement cityNameTextBox;

	/** The search button. */
	@FindBy(how = How.XPATH, using = "//form[@id='searchform']/button[@type='submit']")
	public WebElement searchButton;

	/** The no result text. */
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-warning']")
	public WebElement noResultText;

	/** The result text. */
	@FindBy(how = How.XPATH, using = "//*[@id='forecast_list_ul']//b/a")
	public WebElement resultText;

	/** The weather details. */
	@FindBy(how = How.XPATH, using = "//*[@id='forecast_list_ul']//p[1]")
	public WebElement weatherDetails;

	/** The open weather logo. */
	@FindBy(how = How.XPATH, using = "//a/img[contains(@src,'logo_OpenWeatherMap_orange.svg')]")
	public WebElement openWeatherLogo;

	/** The sign in link. */
	@FindBy(how = How.LINK_TEXT, using = "Sign In")
	public WebElement signInLink;

	/** The sign up link. */
	@FindBy(how = How.LINK_TEXT, using = "Sign Up")
	public WebElement signUpLink;

	/** The current location. */
	@FindBy(how = How.XPATH, using = "//*[@id='searchform']/span/button")
	public WebElement currentLocation;

	/** The current whether forecast. */
	@FindBy(how = How.XPATH, using = "//h2[@class='widget__title']")
	public WebElement currentWhetherForecast;

	/** The terms condition link. */
	@FindBy(how = How.LINK_TEXT, using = "Terms and conditions of sale")
	public WebElement termsConditionLink;

	/** The privacy policy link. */
	@FindBy(how = How.LINK_TEXT, using = "Privacy policy")
	public WebElement privacyPolicyLink;

	/** The web terms condition link. */
	@FindBy(how = How.LINK_TEXT, using = "Websites terms and conditions of use")
	public WebElement webTermsConditionLink;

	/** The weather details table. */
	@FindBy(how = How.XPATH, using = "//table[@class='weather-widget__items']/tbody/tr/td[1]")
	public List<WebElement> weatherDetailsTable;
	
	/** The temp from text. */
	final String tempFromText = "temperature from";
	
	/** The wind text. */
	final String windText = "wind";
	
	/** The clouds text. */
	final String cloudsText = "clouds";
	
	/** The table wind. */
	final String tableWind = "Wind";
	
	/** The table cloudiness. */
	final String tableCloudiness = "Cloudiness";
	
	/** The table pressure. */
	final String tablePressure = "Pressure";
	
	/** The table humidity. */
	final String tableHumidity = "Humidity";
	
	/** The table sunrise. */
	final String tableSunrise = "Sunrise";
	
	/** The table sunset. */
	final String tableSunset = "Sunset";
	
	/** The table geo. */
	final String tableGeo = "Geo coords";
	

	/**
	 * Enter city name.
	 *
	 * @param cityName the city name
	 */
	public void enterCityName(String cityName) {
		cityNameTextBox.sendKeys(cityName);
	}

	/**
	 * Click search button.
	 */
	public void clickSearchButton() {
		cityNameTextBox.submit();
	}

	/**
	 * Verify no result text.
	 *
	 * @return the string
	 */
	public String verifyNoResultText() {
		return noResultText.getText().substring(1).trim();
	}

	/**
	 * Verify city found text.
	 *
	 * @return the string
	 */
	public String verifyCityFoundText() {
		return resultText.getText().trim();
	}

	/**
	 * Verify weather details.
	 *
	 * @return true, if verify weather details
	 */
	public boolean verifyWeatherDetails() {
		String details = weatherDetails.getText();
		if (details.contains(tempFromText) && details.contains(windText) && details.contains(cloudsText)) {
			return true;
		}
		return false;
	}

	/**
	 * Verify open weather logo.
	 *
	 * @return true, if verify open weather logo
	 */
	public boolean verifyOpenWeatherLogo() {
		return openWeatherLogo.isDisplayed();
	}

	/**
	 * Verify sign in sign up links.
	 *
	 * @return true, if verify sign in sign up links
	 */
	public boolean verifySignInSignUpLinks() {
		if (signInLink.isDisplayed() && signUpLink.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Verify weather details table.
	 *
	 * @return true, if verify weather details table
	 */
	public boolean verifyWeatherDetailsTable() {
		boolean flag = false;
		ArrayList<String> list = new ArrayList<String>();
		list.add(tableWind);
		list.add(tableCloudiness);
		list.add(tablePressure);
		list.add(tableHumidity);
		list.add(tableSunrise);
		list.add(tableSunset);
		list.add(tableGeo);

		for (WebElement detail : weatherDetailsTable) {
			if (list.contains(detail.getText())) {
				flag = true;
				continue;
			} else {
				flag = false;
				break;
			}
		}
		return flag;
	}

	/**
	 * Verify city name text box.
	 *
	 * @return true, if verify city name text box
	 */
	public boolean verifyCityNameTextBox() {
		return cityNameTextBox.isDisplayed();
	}

	/**
	 * Verify search city button.
	 *
	 * @return true, if verify search city button
	 */
	public boolean verifySearchCityButton() {
		return searchButton.isDisplayed();
	}

	/**
	 * Verify current location link.
	 *
	 * @return the string
	 */
	public String verifyCurrentLocationLink() {
		return currentLocation.getText();
	}

	/**
	 * Verify weather and forecast info.
	 *
	 * @return the string
	 */
	public String verifyWeatherAndForecastInfo() {
		return currentWhetherForecast.getText();
	}

	/**
	 * Verify terms and condition sale footer.
	 *
	 * @return true, if verify terms and condition sale footer
	 */
	public boolean verifyTermsAndConditionSaleFooter() {
		return termsConditionLink.isDisplayed();
	}

	/**
	 * Verify privacy policy footer.
	 *
	 * @return true, if verify privacy policy footer
	 */
	public boolean verifyPrivacyPolicyFooter() {
		return privacyPolicyLink.isDisplayed();
	}

	/**
	 * Verify web terms and condition footer.
	 *
	 * @return true, if verify web terms and condition footer
	 */
	public boolean verifyWebTermsAndConditionFooter() {
		return webTermsConditionLink.isDisplayed();
	}
}
