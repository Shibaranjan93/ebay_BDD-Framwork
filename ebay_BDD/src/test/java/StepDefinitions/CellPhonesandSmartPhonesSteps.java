package StepDefinitions;

import org.openqa.selenium.By;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.Base;

public class CellPhonesandSmartPhonesSteps extends Base {
	String ebayUrl = "https://www.ebay.com/";
	String shopByCategory = "//button[@id='gh-shop-a']";
	String cellPhonesAccesories = "//a[text()='Cell phones & accessories']";
	String cellPhonesSmartphones = "//a[text()='Cell Phones & Smartphones']";
	String seeAll = "//body/div[4]/div[4]/div[3]/div[1]/section[1]/div[1]/div[2]/button[1]/span[1]";
	String screenSize = "//span[text()='Screen Size']";
	String screenValue = "//body/div[@id='refineOverlay']/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/div[2]/div[2]/span[1]/label[1]/span[1]";
	String price = "//div[@id='c3-mainPanel-price']";
	String priceP1 = "//body/div[@id='refineOverlay']/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/ul[1]/li[1]/div[2]/div[1]/div[1]/div[1]/input[1]";
	String priceP2 = "//body/div[@id='refineOverlay']/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/ul[1]/li[1]/div[2]/div[1]/div[2]/div[1]/input[1]";
	String itemLocation = "//div[@id='c3-mainPanel-location']";
	String itemLocationValue = "//body/div[@id='refineOverlay']/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/fieldset[1]/div[4]/span[1]/span[1]/input[1]";
	String applyBtn = "//body/div[@id='refineOverlay']/div[2]/div[1]/form[1]/div[3]/div[2]/button[1]";
	String vrfFilterText = "//body[1]/div[4]/div[4]/div[3]/section[1]/section[1]/ul[1]/li[1]/div[1]/button[1]";
	String vrfFilter = "//body[1]/div[4]/div[4]/div[3]/section[1]/section[1]/ul[1]/li[1]/div[1]/button[1]";
	String verifySizeText = "//body[1]/div[4]/div[4]/div[3]/section[1]/section[1]/ul[1]/li[1]/div[1]/div[1]/ul[1]/li[1]/a[1]";
	String VerifyPriceText = "//body[1]/div[4]/div[4]/div[3]/section[1]/section[1]/ul[1]/li[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]";
	String verifyItemlocationText = "//body[1]/div[4]/div[4]/div[3]/section[1]/section[1]/ul[1]/li[1]/div[1]/div[1]/ul[1]/li[3]/a[1]";

	@Given("user is on ebay home page")
	public void user_is_on_ebay_home_page() {
		driver.get(ebayUrl);
		System.out.println("Usewr is on ebay home page");
	}

	@When("user navigate to Shop By Category")
	public void user_navigate_to_search_by_category() {
		driver.findElement(By.xpath(shopByCategory)).click();
	}

	@And("user navigate to Electronics")
	public void user_navigate_to_electronics() {
		System.out.println("User navigate to Electronis");
	}

	@And("user click on CellPhones & accesories")
	public void user_click_on_cell_phones_accesories() {
		driver.findElement(By.xpath(cellPhonesAccesories)).click();
		System.out.println("User click on Cellphones & accesories");
	}

	@And("user click Cell Phones & Smartphones in the left hand side navigation section")
	public void user_click_cell_phones_smartphones_in_the_left_hand_side_navigation_section() {
		driver.findElement(By.xpath(cellPhonesSmartphones)).click();
		System.out.println("User click on Cell phones & smart phones");
	}

	@And("user click on See All Shop by brand")
	public void user_click_on_shop_by_brand() {
		driver.findElement(By.xpath(seeAll)).click();
		System.out.println("User click on See All");
	}

	@And("user applied three filter as {string}")
	public void user_applied_three_filter_as(String string) {
		driver.findElement(By.xpath(screenSize)).click();
		driver.findElement(By.xpath(screenValue)).click();
		System.out.println("user click on Screen Size filter");
		driver.findElement(By.xpath(price)).click();
		driver.findElement(By.xpath(priceP1)).sendKeys("1000");
		driver.findElement(By.xpath(priceP2)).sendKeys("1500");
		System.out.println("user click on Price filter");
		driver.findElement(By.xpath(itemLocation)).click();
		driver.findElement(By.xpath(itemLocationValue)).click();
		System.out.println("user click on item location");
		driver.findElement(By.xpath(applyBtn)).click();
	}

	@Then("user verify the filter tags are {string}")
	public void user_verify_the_filter_tags_are(String string) {
		String verifyFilter = driver.findElement(By.xpath(vrfFilterText)).getText();
		if (verifyFilter.contains("3 filters applied")) {
			driver.findElement(By.xpath(vrfFilter)).click();
		} else {
			System.out.println("unable to click on 3filter");
		}
		String verifySize = driver.findElement(By.xpath(verifySizeText)).getText().split(":")[0];
		String VerifyPrice = driver.findElement(By.xpath(VerifyPriceText)).getText().split(":")[0];
		String verifyItemlocation = driver.findElement(By.xpath(verifyItemlocationText)).getText().split(":")[0];
		if ((verifySize.contains("Screen Size")) && (VerifyPrice.contains("Price"))
				&& (verifyItemlocation.contains("Item Location"))) {
			System.out.println("Filters tags are " + verifySize + ", " + VerifyPrice + ", " + verifyItemlocation);
		} else {
			System.out.println("Filters tags are not verified");
		}
	}
}
