package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Pw {

	static Playwright playwright;
	static Browser browser;
	static BrowserContext context;
	static Page page;

	public static Page getPage() {

		playwright = Playwright.create(); // Initialized playwright at the top so we wont have to keep initializing it
											// on every browser type

		String browser_type = System.getProperty("browser");
		if (browser_type == null) {
			browser_type = DataReader.getProperty("browser_type");
		}
		if (page == null) {
			switch (browser_type) {
			case "chrome":
				browser = playwright.chromium()
						.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
				break;
			case "chrome-headless":
				browser = playwright.chromium()
						.launch(new BrowserType.LaunchOptions().setHeadless(true).setChannel("chrome"));
				break;
			case "firefox":
				browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
				break;
			case "firefox-headless":
				browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
				break;
			case "webkit":
				browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
				break;
			case "edge":
				browser = playwright.chromium().launch(
						new BrowserType.LaunchOptions().setHeadless(false).setChannel("safari").setChannel("msedge"));
				break;
			case "edge-headless":
				browser = playwright.chromium().launch(
						new BrowserType.LaunchOptions().setHeadless(true).setChannel("safari").setChannel("msedge"));
				break;
			default:
				browser = playwright.chromium().launch();
				break;
			}
			context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1980,1024));
			page = context.newPage();
		}
		return page;
	}

	public static void quitPW() {

		if (page != null) {

			playwright.close();
			page = null;
		}
	}
}