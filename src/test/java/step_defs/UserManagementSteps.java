package step_defs;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UserManagementPage;
import utils.Pw;

public class UserManagementSteps {
	
	UserManagementPage userPage = new UserManagementPage();
	
	@Given("As a user, I am on the login page")
	public void as_a_user_i_am_on_the_login_page() {
		
	    Pw.getPage().navigate("http://crater.primetech-apps.com/login");
	    
	}
	@When("I enter invalid username and valid password")
	public void i_enter_invalid_username_and_valid_password() {
	    
		Pw.getPage().fill(userPage.emailField, "dum@primetechschool.com");
		Pw.getPage().locator(userPage.passwordField).fill("primetech");;
		
	}
	@When("Click on login button")
	public void click_on_login_button() {
		
		Pw.getPage().locator(userPage.loginButton).click();		
		
	}
	@Then("I should not be logged in")
	public void i_should_not_be_logged_in() {
	    
		assertThat(Pw.getPage().locator(userPage.loginButton)).isVisible();
		
	}
	

}
