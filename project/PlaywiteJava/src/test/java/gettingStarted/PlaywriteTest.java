package gettingStarted;
import com.microsoft.playwright.*;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

@SuppressWarnings("unused")
public class PlaywriteTest {

	public static void main(String[] args) {
		
		Playwright pw=Playwright.create();
	
		BrowserType browsertype=pw.chromium();
		
		
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