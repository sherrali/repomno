package stepdefinitions;

import java.util.Date;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import factory.BrowserFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import junit.framework.Assert;

public class registertn {
	WebDriver driver ; 
	@Given("User navigates to register account page")
	public void user_navigates_to_register_account_page() {
		driver = BrowserFactory.getDriver();
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
	}

	@When("User enters the details into below fields")
	public void user_entrs_the_details_into_below_fields(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("secondName"));
		driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimestamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	}
	
	@When("User enters the details into below fields with duplicate email")
	public void user_entrs_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("secondName"));
		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	}

	@And("User selects privacy policy")
	public void user_selects_privacy_policy() {
		driver.findElement(By.name("agree")).click();
	}

	@And("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/h1")).getText().contains("Your Account Has Been Created!"));
		String actualmsg = driver.findElement(By.xpath("//div[@id='content']/p[1]")).getText();
		System.out.println(actualmsg);
		Assert.assertEquals("Congratulations! Your new account has been successfully created!", actualmsg);
	}

	@And("User selects yes for newsletter")
	public void user_selects_yes_for_newsletter() {
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
	}

	@Then("User should get a proper warning about dulicate email")
	public void user_should_get_a_proper_warning_about_dulicate_email() {
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText());
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
//		intentianally kept blank
	}

	@Then("User should get proper warning message for every mandatory field")
	public void user_should_get_proper_warning_message_for_every_mandatory_field() {
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
		Assert.assertEquals("E-Mail Address does not appear to be valid!", driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());
		Assert.assertEquals("Password must be between 4 and 20 characters!", driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());
	}
	private String getEmailWithTimestamp() {
		Date date = new Date();
		return "mastanshaik"+date.toString().replace(" ", "_").replace(":","_")+"@gmail.com";
	}
}
