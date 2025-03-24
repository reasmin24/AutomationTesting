package AutomationTest;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;


public class AutoTest {
	// Shared between all tests in this class.
	  
	  
	public static void main(String[] args) {
	Playwright playwrite = Playwright.create();
	//Launch Browser
	Browser browser = playwrite.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	Page page = browser.newPage();
	// Navigate to the page
	page.navigate("https://automationexercise.com/");
	
	 // Verify the page title
    String expectedTitle = "Automation Exercise";
    String actualTitle = page.title();

    if (actualTitle.equals(expectedTitle)) {
        System.out.println("Page launched successfully. Title matches: " + actualTitle);
    } else {
        System.out.println("Page launch failed. Expected title: " + expectedTitle + ", but got: " + actualTitle);
    }
    
    // Click on "Products" link or button
    page.locator("a[href='/products']").click();

 // Wait for the page to load
    page.waitForLoadState();
    
    
    // Verify navigation to the "Products" page
    if (page.url().contains("/products")) {
        System.out.println("Navigation to 'Products' page is successful. Current URL: " + page.url());
    } else {
        System.out.println("Failed to navigate to the 'Products' page.");
    }

 // Verify to navigate the "All Products" page
    Locator productsHeader = page.locator("h2:has-text('All Products')"); // Update selector as needed
    if (productsHeader.isVisible()) {
        System.out.println("All Products page element verified successfully.");
    } else {
        System.out.println("All Products page element verification failed.");
    }
    
 // Enter the product name "Blue Top" into the search field
    page.locator("input[name='search']").fill("Blue Top"); // Update selector if needed

    // Click the search button
    page.locator("button[id='submit_search']").click(); // Update selector if needed

    // Wait for the search results to load
    page.waitForLoadState();
    
    
 // Verify to navigate the "Searched product details" page
    Locator productsDetail = page.locator("h2:has-text('All Products')"); // Update selector as needed
    if (productsDetail.isVisible()) {
        System.out.println("All Products page element verified successfully.");
    } else {
        System.out.println("All Products page element verification failed.");
    }
    
    //Wait for search results to load
    page.waitForSelector("div[class='productinfo text-center']");

    // Verify if the search results match the search term
    Locator productNameLocator = page.locator("div[class='productinfo text-center']:has-text('Blue Top')"); // Adjust selector if needed
    if (productNameLocator.isVisible()) {
        System.out.println("Search result verified successfully: Found 'Blue Top'.");
    } else {
        System.out.println("Search result verification failed: 'Blue Top' not found.");
    }
    
    // Close the browser
    //browser.close();
	}
	
}
