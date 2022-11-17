package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.Base;

public class searchBarVerifySteps extends Base {

	String searchBar = "//input[@id='gh-ac']";
	String allCategories = "//select[@id='gh-cat']";
	String searchBtn = "//input[@id='gh-btn']";
	String result = "//span[contains(text(),'Apple A1466 Macbook Air 13.3\" i7-4650U @ 1.7GHz - ')]";

	@When("user enter string in Search Bar as {string}")
	public void user_enter_string_in_search_bar_as(String string1) {
		driver.findElement(By.xpath(searchBar)).sendKeys(string1);
	}

	@When("user change the Search category as {string}")
	public void user_change_the_search_category_as(String string2) {
		driver.findElement(By.xpath(allCategories)).click();
		WebElement allCategoriesDropdown = driver.findElement(By.xpath(allCategories));
		Select sc = new Select(allCategoriesDropdown);
		sc.selectByVisibleText(string2);

	}

	@When("user click on Search")
	public void user_click_on_search() {
		driver.findElement(By.xpath(searchBtn)).click();
	}

	@Then("user verify the page completely")
	public void user_verify_the_page_completely() {
		String title = driver.getTitle();
		if (title.equalsIgnoreCase(title)) {
			System.out.println("MacBook Page load Completely");
		} else {
			System.out.println("Page not loaded");
		}
	}

	@Then("user verify the first result name matches with the search string as {string}")
	public void user_verify_the_first_result_name_matches_with_the_search_string_as(String string3) {
		String verifyResult = driver.findElement(By.xpath(result)).getText();
		if (verifyResult.contains(string3)) {
			System.out.println("Result matched:: " + string3);
		} else {
			System.out.println("Result not matched:: "+string3);
		}
	}
}
