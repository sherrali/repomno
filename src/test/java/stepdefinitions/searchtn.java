package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.BrowserFactory;
import io.cucumber.java.en.*;

public class searchtn {
	WebDriver driver;
	@Given("User opens the application")
	public void user_opens_the_application() {
		driver = BrowserFactory.getDriver();
	}

	@When("User enters the valid product {string}")
	public void user_enters_the_valid_product(String validProduct) {
		driver.findElement(By.name("search")).sendKeys(validProduct);
	}

	@And("User clicks on search button")
	public void user_clicks_on_search_button() {
		driver.findElement(By.xpath("//button[contains(@class,'btn-default')]")).click();
	}

	@Then("User shold get valid product displayed in search result")
	public void user_shold_get_valid_product_displayed_in_search_result() {
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
	}

	@When("User enters the invalid product {string}")
	public void user_enters_the_invalid_product(String invalidProduct) {
		driver.findElement(By.name("search")).sendKeys(invalidProduct);
	}

	@Then("User should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		Assert.assertEquals("There is no product that matches the search criteria.", driver.findElement(By.xpath("//input[@id='button-search']/following-sibling::p")).getText());
	}	

	@When("User dont enter any product")
	public void user_dont_enter_any_product() {
//		intentianally blank
	}
}
