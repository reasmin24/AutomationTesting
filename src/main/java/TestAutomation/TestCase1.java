package TestAutomation;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestCase1 {

	public static void main(String[] args) {
	Playwright playwright =	Playwright.create();
	BrowserType browsertype=playwright.chromium();

	Browser browser=browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
	
	Page page=browser.newPage();
	
	page.navigate("https://automationexercise.com/", new Page .NavigateOptions().setTimeout(60000));
	
	
	String title = page.title();
	// Verify page load by checking for a specific element
    if (page.isVisible("h1")) {
        System.out.println("Page loaded successfully!");
    } else {
        System.out.println("Page load failed.");
    }
	System.out.println("Title is " +title);
	
	}

}
