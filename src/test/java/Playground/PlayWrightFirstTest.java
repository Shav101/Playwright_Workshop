package Playground;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlayWrightFirstTest {
	public static void main(String[] args) {
		
		// Creating interfaces/classes
	
		// First create a playwright object
		Playwright playwright = Playwright.create(); // Its responsible to interact with the browser engine (creating an object, downloading, setting)
		
		//then create a browser object 
		//Browser browser = playwright.chromium().launch(); // Deals with the browsers Chrome/Firefox/Edge and etc
		//Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		
		
		//then create a page object = page object is basically interacts with any content of a web page
		Page page = browser.newPage(); // deals with the content of the page (going to the browser, interact with the browser)
		
		
		page.navigate("https://www.amazon.com");
		//page.title();
		System.out.println(page.title());
		
	
		page.getByText("Sign in").click();
		
		// example for getByLabel
		//page.getByLabel("Email ").fill("dummy@primetechschool.com");
		
		//Example for XPATH locator
		page.locator("//input[@name='email']").fill("Dummy@primetechschool.com");  // use .locator if you want to use xpath
		
		// example for CSS locator
		page.locator("#ap_email").fill("Dummy@primetechschool.com"); // for CSS 
		
		//page.close();
		
		//playwright.close();
		
		
		
		
	}
}
