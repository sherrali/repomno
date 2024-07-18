package stepdefinitions;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.BrowserFactory;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class logintn {
	
	WebDriver driver;	
	
@Given("User navigated to login page")
public void User_navigated_to_login_page() {
	driver = BrowserFactory.getDriver();
	driver.findElement(By.xpath("//span[text()='My Account']")).click();
	driver.findElement(By.linkText("Login")).click();
}


@When("User enters valid email address {string}")
public void user_enters_valid_email_address(String emailtext) {
   driver.findElement(By.id("input-email")).sendKeys(emailtext);
}

@And("User enters valid password {string}")
public void user_enters_valid_password(String passwordtext) {
   driver.findElement(By.id("input-password")).sendKeys(passwordtext);
}

@And("User clicks login button")
public void user_clicks_on_login_button() {
 driver.findElement(By.xpath("//input[@value='Login']")).click();
}

@Then("User should got successfulley logged in")
public void user_should_got_successfulley_logged_in() {
	Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
}

@When("User enters invalid email address")
public void user_enters_invalid_email_address() {
	driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimestamp());
}

@And("User enters invalid password {string}")
public void user_enters_invalid_password(String invalidpasswordtext) {
	driver.findElement(By.id("input-password")).sendKeys(invalidpasswordtext);
}


@Then("User should get a proper warning message about credentials missmatch")
public void user_should_get_a_proper_warning_message_about_credentials_missmatch() {
	Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
}


@When("User dont enter email address")
public void user_dont_enter_email_address() {
	driver.findElement(By.id("input-email")).sendKeys("");
}

@When("User dont enter password")
public void user_dont_enter_password() {
	driver.findElement(By.id("input-password")).sendKeys("");
}

private String getEmailWithTimestamp() {
	Date date = new Date();
	return "mastanshaik"+date.toString().replace(" ", "_").replace(":","_")+"@gmail.com";
}

}
