package Automation2;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
public class testCase2 {

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
	    	
	 // Scroll down to make the link visible
        for (int i = 0; i < 10; i++) { // Adjust the number of steps as needed
            page.evaluate("window.scrollBy(0, 100)"); // Scroll down 100 pixels
            page.waitForTimeout(500); // Wait for 500 milliseconds between scrolls
        }

        // Locate the link by its URL and click it
        Locator link = page.locator("a[href='/product_details/1']"); // Replace selector if necessary

        if (link.isVisible()) {
            link.click(); // Click the link
            
            System.out.println("Navigation to the product details page is successful.");
        } else {
            System.out.println("Link not found after scrolling.");
        }
        page.waitForLoadState();
	
        	
      //Locate the quantity input field and set its value to 4
        Locator quantityInput = page.locator("input[id='quantity']"); 
        quantityInput.fill("4");
        
      //Click on the "Add to Cart" button
        Locator addToCartButton = page.locator("button:has-text('Add to cart')");
        addToCartButton.click();
     // Wait for the popup to appear (adjust timeout if needed)
        page.waitForSelector(".modal-content"); // Ensure the popup is visible; replace ".modal-content" with the actual popup selector

        // Locate the "View Cart" button inside the popup
        Locator viewCartButton = page.locator(".modal-content a[href='/view_cart']"); // Replace selector if necessary

        // Click the "View Cart" button
        viewCartButton.click();

        // Wait for navigation to the cart page
        page.waitForLoadState();

        System.out.println("Successfully navigated to the View Cart page.");
   
     // Navigate to the cart page
        page.navigate("https://automationexercise.com/view_cart");

        // Locate the disabled quantity button
        Locator quantityButton = page.locator("button.disabled"); 
        
        // Get the text value of the quantity button
        String quantityValue = quantityButton.innerText(); // Fetch the displayed text value

        // Check if the quantity is '4'
        if ("4".equals(quantityValue)) {
            System.out.println("Success: The quantity is set to 4!");
        } else {
            System.out.println("Error: The quantity is not set to 4. Current quantity: " + quantityValue);
        }
	
     // Close the browser
        browser.close();
	}
	}

